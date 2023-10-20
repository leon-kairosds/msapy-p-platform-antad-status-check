/*
 * Copyright (c) 2023 Kairos DS
 *
 * Licensed under the GNU General Public License, Version 3 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * https://www.gnu.org/licenses/gpl-3.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.bancoppel.platform.antad.status.check.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancoppel.commons.annotation.ValidateHeaders;
import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.AntadStatusCheckConstants;
import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.constant.RoutesConstants;
import com.bancoppel.platform.antad.status.check.exceptions.ErrorResponse;
import com.bancoppel.platform.antad.status.check.model.AntadResponse;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
import com.bancoppel.platform.antad.status.check.model.CatalogAgreementResponse;
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountRequest;
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountResponse;
import com.bancoppel.platform.antad.status.check.model.ConsultaEstatusRequest;
import com.bancoppel.platform.antad.status.check.model.IdAgreementRequest;
import com.bancoppel.platform.antad.status.check.model.MessagingNotificationsRequest;
import com.bancoppel.platform.antad.status.check.model.MswResponseRequest;
import com.bancoppel.platform.antad.status.check.model.MswResponseResponse;
import com.bancoppel.platform.antad.status.check.model.NotificacionNegativaRequest;
import com.bancoppel.platform.antad.status.check.model.NotificacionPositivaRequest;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentRequest;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;
import com.bancoppel.platform.antad.status.check.service.feign.IAntadOperationFeign;
import com.bancoppel.platform.antad.status.check.service.feign.ICatalogAgreementFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IConfirmationPaymentFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IDepositAccountDetailFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IPaymentOnlineFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IPaymentValidateFeign;
import com.bancoppel.platform.antad.status.check.service.feign.ISendMessagingNotificationFeign;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 
 * @Descripción: Controlador de la clase.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: May , 2023
 * @Empresa: Coppel DSB III
 */
@RestController
@Validated
@Slf4j
@RequestMapping(value = RoutesConstants.BASE_PATH)
public class AntadStatusCheckTestController {

	/**
	 * Inyección de la dependencia {@link checkCheckingAccountService}.
	 */
	@Autowired
	private IPaymentOnlineFeign paymentOnlineFeign;
	/**
	 * Inyección de la dependencia {@link checkCheckingAccountService}.
	 */
	@Autowired
	private IConfirmationPaymentFeign confirmationPaymentFeign;

	@Autowired
	private ISendMessagingNotificationFeign sendMessagingNotificationFeign;
	
	@Autowired
	private IPaymentValidateFeign paymentValidateFeign;
	
	@Autowired
	private ICatalogAgreementFeign catalogAgreementFeign;
	
	@Autowired
	private IDepositAccountDetailFeign accountDetailFeign;
	
	@Autowired
	private IAntadOperationFeign antadOperationFeign;

	/**
	 * Endpoint utilizado para la funcionalidad de consulta de cuenta cheque del
	 * cliente
	 * 
	 * @param request Objeto de tipo {@link AntadStatusCheckRequest}
	 * @return ResponseEntity body CheckCheckingAccountResponse object, status ok
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API_PAYMENT_ONLINE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID) })
	@ApiResponses(value = {
			@ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK, response = ServicesPaymentResponse.class),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_RESOURCE_NOT_FOUND, message = ApiConstants.RESOURCE_NOT_FOUND, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_REQUEST_TIME_OUT, message = ApiConstants.REQUEST_TIME_OUT, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR, response = ErrorResponse.class) })
	@PostMapping(value = RoutesConstants.SEND_PAYMENT_ONLINE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ValidateHeaders
	public ResponseEntity<ServicesPaymentResponse> getPaymentOnline(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@Valid @RequestBody ServicesPaymentRequest request) {
		log.debug(AntadStatusCheckConstants.LOG_PAYMENT_ONLINE_CONTROLLER);

		return paymentOnlineFeign.sendPaymentOnlineRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);

	}

	/**
	 * Endpoint utilizado para la funcionalidad de consulta de cuenta cheque del
	 * cliente
	 * 
	 * @param request Objeto de tipo {@link AntadStatusCheckRequest}
	 * @return ResponseEntity body CheckCheckingAccountResponse object, status ok
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API_CONFIRMATION_PAYMENT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID) })
	@ApiResponses(value = {
			@ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK, response = ServicesPaymentResponse.class),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_RESOURCE_NOT_FOUND, message = ApiConstants.RESOURCE_NOT_FOUND, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_REQUEST_TIME_OUT, message = ApiConstants.REQUEST_TIME_OUT, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR, response = ErrorResponse.class) })

	@PostMapping(value = RoutesConstants.SEND_CONFIRMATION_PAYMENT_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ValidateHeaders
	public ResponseEntity<ServicesPaymentResponse> getPaymentConfirmation(
			@RequestHeader @ApiIgnore HttpHeaders httpHeaders, @Valid @RequestBody ServicesPaymentRequest request) {
		log.debug(AntadStatusCheckConstants.LOG_CONFIRMATION_PAYMENT_CONTROLLER);

		return confirmationPaymentFeign.sendConfirmationPaymentRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}

	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_MESSAGING_NOTIFICATION)
	public ResponseEntity<HttpStatus> messagingNotification(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid MessagingNotificationsRequest messagingNotificationsRequest) {

		return new ResponseEntity<>(
				sendMessagingNotificationFeign.sendMessagingNotification(
								httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
								httpHeaders.getFirst(ApiConstants.UUID), 
								httpHeaders.getFirst(ApiConstants.ACCEPT),
								httpHeaders.getFirst(ApiConstants.DEVICE_ID),
								httpHeaders.getFirst(ApiConstants.CHANNEL_ID), messagingNotificationsRequest)
						.getStatusCode().CREATED);
	}
	
	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_CONSULTA_STATUS)
	public ResponseEntity<AntadResponse> consultaStatus(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid ConsultaEstatusRequest request) {

		return paymentValidateFeign.consultaEstatusRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}
	
	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_NOTIFICACION_POSITIVA)
	public ResponseEntity<AntadResponse> notificacionPositiva(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid NotificacionPositivaRequest request) {

		return paymentValidateFeign.notificacionPositivaRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}
	
	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_NOTIFICACION_NEGATIVA)
	public ResponseEntity<AntadResponse> notificacionNegativa(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid NotificacionNegativaRequest request) {

		return paymentValidateFeign.notificacionNegativaRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}
	
	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_CATALOG_AGREEMENT)
	public ResponseEntity<CatalogAgreementResponse> catalogAgreement(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid IdAgreementRequest request) {

		return catalogAgreementFeign.getAgreementId(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}
	
	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_ACCOUNT_DETAIL)
	public ResponseEntity<CheckCheckingAccountResponse> depositAccountDetail(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid CheckCheckingAccountRequest request) {

		return accountDetailFeign.getAccountDetail(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}
	
	/**
	 * Endpoint utilizado para la funcionalidad de realizar una transferencia SPEI.
	 * 
	 * @param speiTransferRequest request para realizar transferencia.
	 * @return obejct Response.
	 */
	@ApiIgnore
	@ApiOperation(value = ApiConstants.MSW_RESPONSE_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR) })
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID) })
	@ValidateHeaders
	@PostMapping(value = ApiConstants.API_ENDPOINT_MSW_RESPONSE)
	public ResponseEntity<MswResponseResponse> sendMswResponse(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@RequestBody @Valid MswResponseRequest request) {

		return antadOperationFeign.sendMswResponse(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request);
	}
}

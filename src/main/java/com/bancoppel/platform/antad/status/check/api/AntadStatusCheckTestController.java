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
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckResponse;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentRequest;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;
import com.bancoppel.platform.antad.status.check.service.IAntadConfirmationPaymentService;
import com.bancoppel.platform.antad.status.check.service.IAntadPaymentOnlineService;
import com.bancoppel.platform.antad.status.check.service.feign.IConfirmationPaymentFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IPaymentOnlineFeign;

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
	
	

	/**
	 * Endpoint utilizado para la funcionalidad de consulta de cuenta cheque del
	 * cliente
	 * 
	 * @param request Objeto de tipo {@link AntadStatusCheckRequest}
	 * @return ResponseEntity body CheckCheckingAccountResponse object, status ok
	 */
	@ApiOperation(value = ApiConstants.OPERATION_API_PAYMENT_ONLINE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.DEVICE_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CHANNEL_ID),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID) })
	@ApiResponses(value = {
			@ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK, response = AntadStatusCheckResponse.class),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_RESOURCE_NOT_FOUND, message = ApiConstants.RESOURCE_NOT_FOUND, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_REQUEST_TIME_OUT, message = ApiConstants.REQUEST_TIME_OUT, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR, response = ErrorResponse.class) })

	@PostMapping(value = RoutesConstants.SEND_PAYMENT_ONLINE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ValidateHeaders
	public ResponseEntity<ServicesPaymentResponse> getPaymentOnline(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@Valid @RequestBody ServicesPaymentRequest request) {
		log.debug(AntadStatusCheckConstants.LOG_PAYMENT_ONLINE_CONTROLLER);

		//return new ResponseEntity<>(paymentOnlineFeign.sendPaymentOnlineRequestService(httpHeaders, request), HttpStatus.OK);
		return paymentOnlineFeign.sendPaymentOnlineRequest(
															httpHeaders.getFirst(ApiConstants.AUTHORIZATION), 
															httpHeaders.getFirst(ApiConstants.UUID), 
															httpHeaders.getFirst(ApiConstants.ACCEPT), 
															httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
															httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
															request);

	}

	/**
	 * Endpoint utilizado para la funcionalidad de consulta de cuenta cheque del
	 * cliente
	 * 
	 * @param request Objeto de tipo {@link AntadStatusCheckRequest}
	 * @return ResponseEntity body CheckCheckingAccountResponse object, status ok
	 */
	@ApiOperation(value = ApiConstants.OPERATION_API_PAYMENT_ONLINE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.ACCEPT),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.AUTHORIZATION),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.CONTENT_TYPE),
			@ApiImplicitParam(required = true, paramType = Constants.HEADER_WORD_CONSTANT, name = ApiConstants.UUID) })
	@ApiResponses(value = {
			@ApiResponse(code = ApiConstants.CODE_OK, message = ApiConstants.OK, response = AntadStatusCheckResponse.class),
			@ApiResponse(code = ApiConstants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_RESOURCE_NOT_FOUND, message = ApiConstants.RESOURCE_NOT_FOUND, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_REQUEST_TIME_OUT, message = ApiConstants.REQUEST_TIME_OUT, response = ErrorResponse.class),
			@ApiResponse(code = ApiConstants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR, response = ErrorResponse.class) })

	@PostMapping(value = RoutesConstants.SEND_CONFIRMATION_PAYMENT_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ValidateHeaders
	public ResponseEntity<ServicesPaymentResponse> getPaymentConfirmation(@RequestHeader @ApiIgnore HttpHeaders httpHeaders,
			@Valid @RequestBody ServicesPaymentRequest request) {
		log.debug(AntadStatusCheckConstants.LOG_CONFIRMATION_PAYMENT_CONTROLLER);

		//return new ResponseEntity<>(confirmationPaymentFeign.sendConfirmationPaymentRequestService(httpHeaders, request), HttpStatus.OK);
		return confirmationPaymentFeign.sendConfirmationPaymentRequest(
													httpHeaders.getFirst(ApiConstants.AUTHORIZATION), 
													httpHeaders.getFirst(ApiConstants.UUID), 
													httpHeaders.getFirst(ApiConstants.ACCEPT), 
													httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
													httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
													request);
	}

	


}

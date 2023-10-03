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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.bancoppel.platform.antad.status.check.service.IAntadStatusCheckService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

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
public class AntadStatusCheckController {

	/**
	 * Inyección de la dependencia {@link checkCheckingAccountService}.
	 */
	@Autowired
	private IAntadStatusCheckService antadStatusCheckService;

	/**
	 * Endpoint utilizado para la funcionalidad de consulta de cuenta cheque del
	 * cliente
	 * 
	 * @param request Objeto de tipo {@link AntadStatusCheckRequest}
	 * @return ResponseEntity body CheckCheckingAccountResponse object, status ok
	 */
	@ApiOperation(value = ApiConstants.OPERATION_API, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

	@PostMapping(value = RoutesConstants.RETRIEVE_CATALOG_PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ValidateHeaders
	public ResponseEntity<AntadStatusCheckResponse> getCheckCheckingAccount(
			@Valid @RequestBody AntadStatusCheckRequest request) {
		log.debug(AntadStatusCheckConstants.LOG_CHECK_STATUS_ANTAD_CONTROLLER);

		return new ResponseEntity<>(antadStatusCheckService.getAntadStatusCheckService(request), HttpStatus.OK);
	}

}

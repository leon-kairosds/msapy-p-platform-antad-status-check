/*
 * Copyright (c) 2023 Bancoppel
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

package com.bancoppel.platform.antad.status.check.constant;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constantes de la clase controller.
 */
@Component
@Getter
public class ErrorResolverConstants {

	/**
	 * Constante para representar un código de error causado por
	 * DataNotFoundException.
	 */
	@Value("${constants.errorResolver.errorCodes.dataNotFoundException}")
	private String dataNotFoundException;
	/**
	 * Constant used to show the message 'Invalid Request'.
	 */
	@Value("${constants.errorResolver.messages.notFoundException}")
	private String dataNotFoundExceptionText;
	/**
	 * Constante para mostrar un mensaje cuando un cliente no es autorizado.
	 */
	@Value("${constants.errorResolver.messages.unauthorizedText}")
	private String unauthorizedText;
	/**
	 * Constante para representar un código de error causado por
	 * BadRequestException.
	 */
	@Value("${constants.errorResolver.errorCodes.badRequestException}")
	private String badRequestException;
	/**
	 * Constante para representar un código de error causado por
	 * UnauthorizedException.
	 */
	@Value("${constants.errorResolver.errorCodes.unauthorizedException}")
	private String unauthorizedException;
	/**
	 * Constante para representar un código de error causado por
	 * NoHandlerFoundException.
	 */
	@Value("${constants.errorResolver.errorCodes.noHandlerFoundException}")
	private String noHandlerFoundException;
	/**
	 * Constante para representar un código de error causado por
	 * HttpRequestMethodNotSupportedException.
	 */
	@Value("${constants.errorResolver.errorCodes.httpRequestMethodNotSupportedException}")
	private String httpRequestMethodNotSupportedException;
	/**
	 * Constante para representar un código de error causado por
	 * HttpMediaTypeNotAcceptableException.
	 */
	@Value("${constants.errorResolver.errorCodes.httpMediaTypeNotAcceptableException}")
	private String httpMediaTypeNotAcceptableException;
	/**
	 * Constante para representar un código de error causado por
	 * HttpMediaTypeNotSupportedException.
	 */
	@Value("${constants.errorResolver.errorCodes.httpMediaTypeNotSupportedException}")
	private String httpMediaTypeNotSupportedException;
	/**
	 * Constante para representar un código de error causado por
	 * ServletRequestBindingException.
	 */
	@Value("${constants.errorResolver.errorCodes.servletRequestBindingException}")
	private String servletRequestBindingException;
	/**
	 * Constante para representar un código de error causado por
	 * HttpMessageNotReadableException.
	 */
	@Value("${constants.errorResolver.errorCodes.httpMessageNotReadableException}")
	private String httpMessageNotReadableException;
	/**
	 * Constante para representar un código de error causado por
	 * MethodArgumentNotValidException.
	 */
	@Value("${constants.errorResolver.errorCodes.methodArgumentNotValidException}")
	private String methodArgumentNotValidException;
	/**
	 * Constante para representar un código de error causado por
	 * ConstraintViolationException.
	 */
	@Value("${constants.errorResolver.errorCodes.constraintViolationException}")
	private String constraintViolationException;
	/**
	 * Constante para representar un código de error causado por un error
	 * desconocido.
	 */
	@Value("${constants.errorResolver.errorCodes.exception}")
	private String exception;
	/**
	 * Constante para representar un código de error causado por
	 * HystrixRuntimeException.
	 */
	@Value("${constants.errorResolver.errorCodes.hystrixRuntimeException}")
	private String hystrixRuntimeException;
	/**
	 * Constante para representar un mensaje de error causado por un error
	 * desconocido.
	 */
	@Value("${constants.errorResolver.messages.genericErrorDescription}")
	private String genericErrorDescription;
	/**
	 * Constante para mostrar un mensaje genérico del catálogo de errores. Constant
	 * that is used to show a generic message about the error catalog.
	 */
	@Value("${constants.errorResolver.messages.genericFailureDescription}")
	private String genericFailureDescription;
	/**
	 * Constante para mostrar un mensaje LegacyError.
	 */
	@Value("${constants.errorResolver.messages.legacyErrorLabel}")
	private String legacyErrorLabel;
	/**
	 * Constante para mostrar un mensaje 'Invalid Request'.
	 */
	@Value("${constants.errorResolver.messages.invalidRequest}")
	private String invalidRequest;

	/**
	 * Constante que representar un String 'type'.
	 */
	public static final String ERROR_RESPONSE_TYPE = "type";
	/**
	 * Constante que representar un String 'code'.
	 */
	public static final String ERROR_RESPONSE_CODE = "code";
	/**
	 * Constante que representar un String 'details'.
	 */
	public static final String ERROR_RESPONSE_DETAILS = "details";
	/**
	 * Constante que representar un String 'location'.
	 */
	public static final String ERROR_RESPONSE_LOCATION = "location";
	/**
	 * Constante que representar un String 'moreInfo'.
	 */
	public static final String ERROR_RESPONSE_MORE_INFORMATION = "moreInfo";
	/**
	 * Constante para representar un mensaje de error generico al consultar una base
	 * de datos.
	 */
	@Value("${constants.errorResolver.errorCodes.externalResourceException}")
	private String externalResourceException;

	/**
	 * Constante para mostrar un mensaje cuando ocurre un error al consultar una
	 * base de datos.
	 */
	@Value("${constants.errorResolver.messages.externalResourceException}")
	private String externalResourceExceptionDetail;

	/**
	 * Constante para representar un mensaje de error causado por un timeout al
	 * consultar la bd.
	 */
	@Value("${constants.errorResolver.errorCodes.databaseTimeoutException}")
	private String databaseTimeoutException;
	/**
	 * Constante para mostrar un mensaje cuando ocurre un timeout al consultar la
	 * bd.
	 */
	@Value("${constants.errorResolver.messages.databaseTimeoutException}")
	private String databaseTimeoutExceptionDetail;

	/**
	 * Constructor privado para evitar la instancia de la clase.
	 */
	private ErrorResolverConstants() {

	}

}

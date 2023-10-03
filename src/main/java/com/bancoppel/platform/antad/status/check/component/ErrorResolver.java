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

package com.bancoppel.platform.antad.status.check.component;

import com.bancoppel.commons.exceptions.ExternalResourceException;
import com.bancoppel.commons.exceptions.NotValidHeadersException;
import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.ErrorResolverConstants;
import com.bancoppel.platform.antad.status.check.constant.SpecialCharacterConstants;
import com.bancoppel.platform.antad.status.check.exceptions.ErrorResponse;
import com.bancoppel.platform.antad.status.check.exceptions.ErrorType;
import com.bancoppel.platform.antad.status.check.exceptions.custom.BadRequestException;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DatabaseTimeoutException;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DownstreamException;
import com.bancoppel.platform.antad.status.check.exceptions.custom.UnauthorizedException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixRuntimeException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * Administrador de excepciones.
 */
@RestControllerAdvice
public class ErrorResolver {

	/**
	 * Variable para logeo.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ErrorResolver.class);

	/**
	 * Bean de constantes de errores definidos en el yaml.
	 */
	@Autowired
	private ErrorResolverConstants errorResolverConstants;

	/**
	 * Método para logear el detalle de la excepción.
	 */
	private static void writeToLog(ErrorResponse errorResponse, Exception exception) {
		LOGGER.error(ErrorResolverConstants.ERROR_RESPONSE_TYPE, errorResponse.getType());
		LOGGER.error(ErrorResolverConstants.ERROR_RESPONSE_CODE, errorResponse.getCode());
		LOGGER.error(ErrorResolverConstants.ERROR_RESPONSE_DETAILS, errorResponse.getDetails());
		LOGGER.error(ErrorResolverConstants.ERROR_RESPONSE_LOCATION, errorResponse.getLocation());
		LOGGER.error(ErrorResolverConstants.ERROR_RESPONSE_MORE_INFORMATION, errorResponse.getMoreInfo());

		String message = Objects.isNull(exception) ? SpecialCharacterConstants.EMPTY_STRING : exception.getMessage();
		LOGGER.error(message, exception);
	}

	/**
	 * DownstreamException handler.
	 *
	 * @param req  Objeto Http Servlet de petición.
	 * @param resp Objeto Http Servlet de respuesta.
	 * @param ex   Excepción recibida DownstreamException.
	 * @return ErrorResponse Objeto de respuesta específica para
	 *         DownstreamException.
	 */
	@ExceptionHandler(DownstreamException.class)
	@ResponseBody
	public ErrorResponse resolveDownstreamException(HttpServletRequest req, HttpServletResponse resp,
			DownstreamException ex) {
		LOGGER.error(ex.getMessage(), ex);

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setType(ex.getType());
		errorResponse.setCode(ex.getCode());
		errorResponse.setDetails(ex.getDetails());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setMoreInfo(ex.getMoreInfo());
		errorResponse.setTimestamp(ex.getTimestamp());
		errorResponse.setUuid(ex.getUuid());
		resp.setStatus(ex.getStatus());

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for BadRequestException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida BadRequestException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         BadRequestException.
	 */
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveBadRequestException(HttpServletRequest req, BadRequestException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getBadRequestException());
		errorResponse.setDetails(ex.getMessage());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for UnauthorizedException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida UnauthorizedException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         UnauthorizedException.
	 */
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveUnAuthorizedException(HttpServletRequest req, UnauthorizedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getUnauthorizedException());
		errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for NoHandlerFoundException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida UnauthorizedException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         NoHandlerFoundException.
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorResponse resolveNoHandlerFoundException(HttpServletRequest req, NoHandlerFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getNoHandlerFoundException());
		errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for HttpRequestMethodNotSupportedException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida UnauthorizedException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         HttpRequestMethodNotSupportedException.
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveHttpRequestMethodNotSupportedException(HttpServletRequest req,
			HttpRequestMethodNotSupportedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(errorResolverConstants.getHttpRequestMethodNotSupportedException());
		errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for HttpMediaTypeNotAcceptableException. See
	 * https://www.baeldung.com/spring-httpmediatypenotacceptable
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida HttpMediaTypeNotAcceptableException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         HttpMediaTypeNotAcceptableException.
	 */
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String resolveHttpMediaTypeNotAcceptableException(HttpServletRequest req,
			HttpMediaTypeNotAcceptableException ex) {
		ObjectMapper mapper = new ObjectMapper();

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(errorResolverConstants.getHttpMediaTypeNotAcceptableException());
		errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		String errorResponseString = ex.getMessage();

		try {
			errorResponseString = mapper.writeValueAsString(errorResponse);
		} catch (JsonProcessingException jsonProcessingException) {
			LOGGER.error(jsonProcessingException.getMessage(), jsonProcessingException);
		}

		return errorResponseString;
	}

	/**
	 * Handler for HttpMediaTypeNotSupportedException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida HttpMediaTypeNotAcceptableException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         HttpMediaTypeNotSupportedException.
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveHttpMediaTypeNotSupportedException(HttpServletRequest req,
			HttpMediaTypeNotSupportedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(errorResolverConstants.getHttpMediaTypeNotSupportedException());
		errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for ServletRequestBindingException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida ServletRequestBindingException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         ServletRequestBindingException.
	 */
	@ExceptionHandler(ServletRequestBindingException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveServletRequestBindingException(HttpServletRequest req,
			ServletRequestBindingException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getServletRequestBindingException());
		if (!StringUtils.isBlank(ex.getMessage())) {
			errorResponse.setDetails(ex.getMessage());
		}
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for HttpMessageNotReadableException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida HttpMessageNotReadableException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         HttpMessageNotReadableException.
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveHttpMessageNotReadableException(HttpServletRequest req,
			HttpMessageNotReadableException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		String message = (ex == null || ex.getMessage() == null) ? SpecialCharacterConstants.EMPTY_STRING
				: ex.getMessage();

		int index = (message != null && !message.isEmpty()) ? message.indexOf(SpecialCharacterConstants.COLON)
				: SpecialCharacterConstants.INT_NEGATIVE_ONE;
		message = (message != null && index != SpecialCharacterConstants.INT_NEGATIVE_ONE)
				? message.substring(SpecialCharacterConstants.INT_ZERO_VALUE, index)
				: errorResolverConstants.getGenericErrorDescription();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(errorResolverConstants.getHttpMessageNotReadableException());
		errorResponse.setDetails(message);
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));
		errorResponse.setLocation(req.getRequestURI());

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for MethodArgumentNotValidException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida MethodArgumentNotValidException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         MethodArgumentNotValidException.
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveMethodArgumentNotValidException(HttpServletRequest req,
			MethodArgumentNotValidException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(errorResolverConstants.getMethodArgumentNotValidException());

		Map<String, List<String>> groupedErrors = new HashMap<>();
		List<String> fields = new ArrayList<>();
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			String message = fieldError.getDefaultMessage();
			String field = fieldError.getField();
			groupedErrors.computeIfAbsent(message, key -> Collections.singletonList(field));
			fields.add(field);
		}

		if (!groupedErrors.isEmpty()) {
			errorResponse.setDetails(groupedErrors.toString());
		}

		errorResponse.setDetails(fields.toString());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for ConstraintViolationException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida ConstraintViolationException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         ConstraintViolationException.
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveConstraintViolation(HttpServletRequest req, ConstraintViolationException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.INVALID.name());
		errorResponse.setCode(errorResolverConstants.getConstraintViolationException());

		List<String> violationMessages = new ArrayList<>();
		ex.getConstraintViolations().forEach(violation -> violationMessages.add(violation.getMessage()));

		errorResponse.setDetails(String.join(SpecialCharacterConstants.COMMA_SEPARATOR, violationMessages));
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for Exception.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida Exception.
	 * @return errorResponse Objeto de respuesta específica para Exception.
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse resolveException(HttpServletRequest req, Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.FATAL.name());
		errorResponse.setCode(errorResolverConstants.getException());
		errorResponse.setDetails(errorResolverConstants.getGenericErrorDescription());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler for HystrixRuntimeException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida HystrixRuntimeException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         HystrixRuntimeException.
	 */
	@ExceptionHandler(HystrixRuntimeException.class)
	public ErrorResponse resolveHystrixRuntimeException(HttpServletRequest req, HttpServletResponse res,
			HystrixRuntimeException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		Throwable fallExc = null;
		if (ex.getFallbackException() != null && (fallExc = ex.getFallbackException().getCause()) != null
				&& fallExc instanceof DatabaseTimeoutException) {
			errorResponse = resolveDatabaseTimeoutException(req, res, (DatabaseTimeoutException) fallExc);
		} else {
			errorResponse.setType(ErrorType.ERROR.name());
			errorResponse.setCode(errorResolverConstants.getHystrixRuntimeException());
			errorResponse.setDetails(ex.getMessage());
			errorResponse.setLocation(req.getRequestURI());
			errorResponse.setTimestamp(ZonedDateTime.now());
			errorResponse.setUuid(req.getHeader(ApiConstants.UUID));
			ErrorResolver.writeToLog(errorResponse, ex);
			res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return errorResponse;

	}

	/**
	 * Handler para manejar la excepcion {@link DatabaseTimeoutException}.
	 *
	 * @param req Request del DatabaseTimeoutException.
	 * @param ex  Excepcion DatabaseTimeoutException atrapada.
	 * @return errorResponse Mensaje de error personalizado.
	 */
	@ExceptionHandler(DatabaseTimeoutException.class)
	@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
	public ErrorResponse resolveDatabaseTimeoutException(HttpServletRequest req, HttpServletResponse res,
			DatabaseTimeoutException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getDatabaseTimeoutException());
		errorResponse.setDetails(errorResolverConstants.getDatabaseTimeoutExceptionDetail());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));
		res.setStatus(HttpServletResponse.SC_REQUEST_TIMEOUT);

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler para manejar la excepcion {@link ExternalResourceException}.
	 * ex.getMessage()
	 * 
	 * @param req Request del ExternalResourceException.
	 * @param ex  Excepcion ExternalResourceException atrapada.
	 * @return errorResponse Mensaje de error personalizado.
	 * 
	 */
	@ExceptionHandler(ExternalResourceException.class)
	@ResponseStatus(value = HttpStatus.REQUEST_TIMEOUT)
	public ErrorResponse resolveExternalResourceException(HttpServletRequest req, ExternalResourceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getExternalResourceException());
		errorResponse.setDetails(errorResolverConstants.getExternalResourceExceptionDetail());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}

	/**
	 * Handler de NotValidHeadersException.
	 *
	 * @param req Objeto Http Servlet de petición.
	 * @param ex  Excepción recibida NotValidHeadersException.
	 * @return errorResponse Objeto de respuesta específica para
	 *         NotValidHeadersException.
	 */
	@ExceptionHandler(NotValidHeadersException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse resolveNotValidHeadersException(HttpServletRequest req, NotValidHeadersException ex) {
		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setType(ErrorType.ERROR.name());
		errorResponse.setCode(errorResolverConstants.getBadRequestException());
		errorResponse.setDetails(ex.getMessage());
		errorResponse.setLocation(req.getRequestURI());
		errorResponse.setTimestamp(ZonedDateTime.now());
		errorResponse.setUuid(req.getHeader(ApiConstants.UUID));

		ErrorResolver.writeToLog(errorResponse, ex);

		return errorResponse;
	}
}

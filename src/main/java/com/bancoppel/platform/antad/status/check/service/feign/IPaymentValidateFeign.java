package com.bancoppel.platform.antad.status.check.service.feign;

import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeoutException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.FeignConstants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DownstreamException;
import com.bancoppel.platform.antad.status.check.model.AntadRequest;
import com.bancoppel.platform.antad.status.check.model.ConsultaEstatusRequest;
import com.bancoppel.platform.antad.status.check.model.NotificacionNegativaRequest;
import com.bancoppel.platform.antad.status.check.model.NotificacionPositivaRequest;
import com.bancoppel.platform.antad.status.check.model.AntadResponse;
import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.commons.exceptions.ExternalResourceException;
import com.bancoppel.commons.exceptions.NotValidHeadersException;

import feign.FeignException;
import feign.RetryableException;

/**
 * Interfaz de tipo Feign que consume la api de payment validate.
 * 
 * @author Kairos DS - Leon Fernando.
 */
@FeignClient(url = FeignConstants.PAYMENT_VALIDATE_URL, name = FeignConstants.PAYMENT_VALIDATE_AUTORIZACION_NAME)
public interface IPaymentValidateFeign {

	/**
	 * Metodo que consume al Api Payment Validate.
	 * 
	 * @param authorization Cabecera Authorization.
	 * @param uuid          Cabecera uuid.
	 * @param accept        Cabecera Accept.
	 * @param deviceId      identificador de dispositivo.
	 * @param request       a api.
	 * @return Respuesta HttpStatus.
	 */
	@HandledProcedure(name = ApiConstants.LOG_PAYMENT_VALIDATE, value = ApiConstants.LOG_PAYMENT_VALIDATE, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })

	@PostMapping(value = FeignConstants.PAYMENT_VALIDATE_CONSULTA_ESTATUS_ENDPOINT)
	ResponseEntity<AntadResponse> consultaEstatusRequest(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody ConsultaEstatusRequest request);

	/**
	 * Metodo que consume al Api Payment Validate.
	 * 
	 * @param authorization Cabecera Authorization.
	 * @param uuid          Cabecera uuid.
	 * @param accept        Cabecera Accept.
	 * @param deviceId      identificador de dispositivo.
	 * @param request       a api.
	 * @return Respuesta HttpStatus.
	 */
	@HandledProcedure(name = ApiConstants.LOG_PAYMENT_VALIDATE, value = ApiConstants.LOG_PAYMENT_VALIDATE, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })

	@PostMapping(value = FeignConstants.PAYMENT_VALIDATE_NOTIFICACION_POSITIVA_ENDPOINT)
	ResponseEntity<AntadResponse> notificacionPositivaRequest(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody NotificacionPositivaRequest request);

	/**
	 * Metodo que consume al Api Payment Validate.
	 * 
	 * @param authorization Cabecera Authorization.
	 * @param uuid          Cabecera uuid.
	 * @param accept        Cabecera Accept.
	 * @param deviceId      identificador de dispositivo.
	 * @param request       a api.
	 * @return Respuesta HttpStatus.
	 */
	@HandledProcedure(name = ApiConstants.LOG_PAYMENT_VALIDATE, value = ApiConstants.LOG_PAYMENT_VALIDATE, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })

	@PostMapping(value = FeignConstants.PAYMENT_VALIDATE_NOTIFICACION_NEGATIVA_ENDPOINT)
	ResponseEntity<AntadResponse> notificacionNegativaRequest(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody NotificacionNegativaRequest request);
}


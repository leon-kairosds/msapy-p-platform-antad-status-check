package com.bancoppel.platform.antad.status.check.service.feign;

import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeoutException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.commons.exceptions.ExternalResourceException;
import com.bancoppel.commons.exceptions.NotValidHeadersException;
import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.FeignConstants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DownstreamException;
import com.bancoppel.platform.antad.status.check.model.MswResponseRequest;
import com.bancoppel.platform.antad.status.check.model.MswResponseResponse;

import feign.FeignException;
import feign.RetryableException;

@FeignClient(url = FeignConstants.ANTAD_OPERATION_URL, name = FeignConstants.MSW_REQUEST_NAME)
public interface IAntadOperationFeign {

	/**
	 * Metodo que consume al Api SendMessagingNotification.
	 * 
	 * @param authorization Cabecera Authorization.
	 * @param uuid          Cabecera uuid.
	 * @param accept        Cabecera Accept.
	 * @param deviceId      identificador de dispositivo.
	 * @param request       a api.
	 * @return Respuesta HttpStatus.
	 */
	@HandledProcedure(name = ApiConstants.LOG_ANTAD_OPERATION, value = ApiConstants.LOG_ANTAD_OPERATION, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })
	@PostMapping(value = FeignConstants.MSW_RESPONSE_ENDPOINT)
	ResponseEntity<MswResponseResponse> sendMswResponse(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId, @RequestBody MswResponseRequest request);

}

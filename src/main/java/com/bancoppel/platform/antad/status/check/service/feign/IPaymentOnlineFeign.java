package com.bancoppel.platform.antad.status.check.service.feign;

import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeoutException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.constant.FeignConstants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DownstreamException;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentRequest;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;
import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.commons.exceptions.ExternalResourceException;
import com.bancoppel.commons.exceptions.NotValidHeadersException;

import feign.FeignException;
import feign.RetryableException;
import io.swagger.annotations.ApiImplicitParam;

/**
 * Interfaz de tipo Feign que consume la api de captureline operation.
 * 
 * @author Kairos DS - Leon Fernando.
 */
@FeignClient(url = FeignConstants.PAYMENT_ONLINE_URL, name = FeignConstants.PAYMENT_ONLINE_NAME)
public interface IPaymentOnlineFeign {

	/**
	 * Metodo que consume al Api Captureline Operation.
	 * 
	 * @param authorization Cabecera Authorization.
	 * @param uuid          Cabecera uuid.
	 * @param accept        Cabecera Accept.
	 * @param deviceId      identificador de dispositivo.
	 * @param request       a api.
	 * @return Respuesta HttpStatus.
	 */
	@HandledProcedure(name = ApiConstants.LOG_PAYMENT_ONLINE, value = ApiConstants.LOG_PAYMENT_ONLINE, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })

	@PostMapping(value = FeignConstants.PAYMENT_ONLINE_ENDPOINT)
	ResponseEntity<ServicesPaymentResponse> sendPaymentOnlineRequest(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody ServicesPaymentRequest request);

}

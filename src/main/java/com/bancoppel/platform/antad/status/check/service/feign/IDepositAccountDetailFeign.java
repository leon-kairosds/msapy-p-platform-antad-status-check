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
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountRequest;
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountResponse;
import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.commons.exceptions.ExternalResourceException;
import com.bancoppel.commons.exceptions.NotValidHeadersException;

import feign.FeignException;
import feign.RetryableException;

/**
 * Interfaz de tipo Feign que consume la api de captureline operation.
 * 
 * @author Kairos DS - Leon Fernando.
 */
@FeignClient(url = FeignConstants.ACCOUNT_DETAIL_URL, name = FeignConstants.ACCOUNT_DETAIL_NAME)
public interface IDepositAccountDetailFeign {

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
	@HandledProcedure(name = ApiConstants.LOG_CHECK_CHECKING_ACCOUNT, value = ApiConstants.LOG_CHECK_CHECKING_ACCOUNT, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })

	@PostMapping(value = FeignConstants.ACCOUNT_DETAIL_ENDPOINT)
	ResponseEntity<CheckCheckingAccountResponse> getAccountDetail(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody CheckCheckingAccountRequest request);

}

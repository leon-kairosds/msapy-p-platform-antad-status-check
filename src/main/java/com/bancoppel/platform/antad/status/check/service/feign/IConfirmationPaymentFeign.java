/*
 *
 * Copyright (c) 2023, Bancoppel All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modifications are not
 * permitted.
 *
 * Bancoppel claims copyright in this computer program as an unpublished work.
 *
 * This program is a confidential trade secret and the property of Bancoppel.
 *
 * Use, examination, reproduction, disassembly, decompiling, transfer and/or disclosure to others of
 * all or any part of this software program are strictly prohibited except by express written
 * agreement with Bancoppel.
 *
 * This software is provided by the copyright holders and contributors "as is" and any express or
 * implied warranties, including, but not limited to, the implied warranties of merchantability and
 * fitness for a particular purpose are disclaimed. In no event shall the copyright owner or
 * contributors be liable for any direct, indirect, incidental, special, exemplary, or consequential
 * damages (including, but not limited to, procurement of substitute goods or services; Loss of use,
 * data, or profits; Or business interruption) however caused and on any theory of liability,
 * whether in contract, strict liability, or tort (including negligence or otherwise) arising in any
 * way out of the use of this software, even if advised of the possibility of such damage.
 *
 * Developed by Bancoppel.
 */
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
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentRequest;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;
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
@FeignClient(url = FeignConstants.CONFIRMATION_PAYMENT_URL, name = FeignConstants.CONFIRMATION_PAYMENT_NAME)
public interface IConfirmationPaymentFeign {

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
	@HandledProcedure(name = ApiConstants.LOG_CONFIRMATION_PAYMENT, value = ApiConstants.LOG_CONFIRMATION_PAYMENT, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, TimeoutException.class, RetryableException.class })

	@PostMapping(value = FeignConstants.CONFIRMATION_PAYMENT_ENDPOINT)
	ResponseEntity<ServicesPaymentResponse> sendConfirmationPaymentRequest(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody ServicesPaymentRequest request);

}

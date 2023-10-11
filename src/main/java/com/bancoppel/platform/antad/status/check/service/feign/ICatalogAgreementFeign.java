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

package com.bancoppel.platform.antad.status.check.service.feign;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.FeignConstants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DownstreamException;
import com.bancoppel.platform.antad.status.check.model.CatalogAgreementResponse;
import com.bancoppel.platform.antad.status.check.model.IdAgreementRequest;
import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.commons.exceptions.ExternalResourceException;
import com.bancoppel.commons.exceptions.NotValidHeadersException;

import feign.FeignException;
import feign.RetryableException;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.concurrent.CompletionException;
import java.util.concurrent.TimeoutException;

/**
 * Interfaz de tipo Feign que consume el Api GetFlagSpei.
 * 
 * @author Kairos DS - Leon Fernando.
 */
@FeignClient(url = FeignConstants.CATALOG_AGREEMENT_URL, name = FeignConstants.CATALOG_AGREEMENT_NAME)
public interface ICatalogAgreementFeign {

	/**
	 * Metodo que consume al Api GetFlagSpei.
	 * 
	 * @param authorization              Cabecera Authorization.
	 * @param uuid                       Cabecera uuid.
	 * @param accept                     Cabecera Accept.
	 * @param deviceId                   id de disposiivo.
	 * @param getPaymentAgreementRequest request a api.
	 * @return Respuesta HttpStatus.
	 */
	@HandledProcedure(name = ApiConstants.LOG_PAYMENT_AGREEMENT, value = ApiConstants.LOG_PAYMENT_AGREEMENT, ignoreExceptions = {
			DownstreamException.class, FeignException.class, NotValidHeadersException.class, CompletionException.class,
			ExternalResourceException.class, RetryableException.class, TimeoutException.class })
	@PostMapping(value = FeignConstants.CATALOG_AGREEMENT_ENDPOINT)
	ResponseEntity<CatalogAgreementResponse> getAgreementId(
			@RequestHeader(name = ApiConstants.AUTHORIZATION) String authorization,
			@RequestHeader(name = ApiConstants.UUID) String uuid,
			@RequestHeader(name = ApiConstants.ACCEPT) String accept,
			@RequestHeader(name = ApiConstants.DEVICE_ID) String deviceId,
			@RequestHeader(name = ApiConstants.CHANNEL_ID) String channelId,
			@RequestBody IdAgreementRequest agreementRequest);
}

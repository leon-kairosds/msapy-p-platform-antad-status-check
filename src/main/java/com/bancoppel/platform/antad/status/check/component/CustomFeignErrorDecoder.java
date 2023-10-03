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

import com.bancoppel.platform.antad.status.check.component.CustomFeignErrorDecoder;
import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DownstreamException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** Clase que implementa el ErrorDecoder para feign. */

public class CustomFeignErrorDecoder implements ErrorDecoder {

	/**
	 * Variable para logeo.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFeignErrorDecoder.class);

	/** Instancia de errorDecoder. */
	private ErrorDecoder errorDecoder = new ErrorDecoder.Default();

	/** Función que trata la excepción recibida. */
	@Override
	public Exception decode(String methodKey, Response response) {
		if (response.body() == null) {
			LOGGER.error(Constants.MSG_CURLY_BRACKETS, Constants.MSG_ERROR_RESPONSE_HAS_NO_BODY);
			return errorDecoder.decode(methodKey, response);
		}

		Map<String, String> errorResponse;
		try {
			final String body = Util.toString(response.body().asReader());
			ObjectMapper mapper = new ObjectMapper();
			errorResponse = mapper.readValue(body, new TypeReference<Map<String, String>>() {
			});
		} catch (IOException ex) {
			LOGGER.error(Constants.MSG_ERROR_FORMAT, ex);
			return errorDecoder.decode(methodKey, response);
		}

		HttpStatus status = HttpStatus.valueOf(response.status());

		Map<String, Object> map = new HashMap<>();
		map.put(Constants.MSG_STATUS, status.value());
		map.put(Constants.MSG_REQUEST,
				com.bancoppel.platform.antad.status.check.util.Util.getJson(response.request()));
		map.put(Constants.MSG_RESPONSE,
				com.bancoppel.platform.antad.status.check.util.Util.getJson(errorResponse));
		String mapString = com.bancoppel.platform.antad.status.check.util.Util.getJson(map);
		LOGGER.debug(Constants.ERROR_FEIGN_DETAILS, mapString);

		return new DownstreamException(status.value(), errorResponse);

	}
}

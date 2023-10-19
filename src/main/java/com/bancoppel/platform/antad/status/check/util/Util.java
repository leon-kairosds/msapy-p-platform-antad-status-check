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

package com.bancoppel.platform.antad.status.check.util;

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Enumeration;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

/**
 * Clase de utilerias generales.
 */
public class Util {

	/**
	 * Variable para logeo.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	/**
	 * Constructor privado para evitar la instancia de esta clase.
	 */
	private Util() {

	}

	/**
	 * Método para obtener un json String.
	 * 
	 * @param object.
	 * @return Json Serializado.
	 */
	public static String getJson(Object object) {
		String jsonString = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonString = mapper.writeValueAsString(object);
		} catch (JsonProcessingException ex) {
			LOGGER.error(ex.getMessage(), ex);
		}

		return jsonString;
	}

	/**
	 * Método para imprimir los headers de la petición Http.
	 * 
	 * @param request.
	 */
	public static void printHeaders(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();

		if (!Objects.isNull(headerNames)) {

			while (headerNames.hasMoreElements()) {
				String key = headerNames.nextElement();
				String value = request.getHeader(key);
				LOGGER.debug(Constants.MSG_TO_LOG_HEADER, key, value);
			}
		}
	}
}

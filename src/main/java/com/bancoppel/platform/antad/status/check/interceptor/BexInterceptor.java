/* Copyright (c) 2023 Kairos DS
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

package com.bancoppel.platform.antad.status.check.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.interceptor.BexInterceptor;
import com.bancoppel.platform.antad.status.check.util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase que se ejecuta cuando inicia la petición del controlador.
 */
@Component
public class BexInterceptor extends HandlerInterceptorAdapter {

	/**
	 * Variable para logeo.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BexInterceptor.class);

	/**
	 * Método para configurar el MDC y guardar el tiempo inicial de la petición.
	 * 
	 * @throws ServletRequestBindingException excepcion lanzada cuando el algoritmo
	 *                                        no fue encontrado
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ServletRequestBindingException {
		long t0 = System.currentTimeMillis();
		request.setAttribute(Constants.T0_REQ_ATTRIBUTE, t0);

		MDC.put(Constants.SID_MDC_LABEL, request.getHeader(ApiConstants.SID));
		MDC.put(Constants.UUID_MDC_LABEL, request.getHeader(ApiConstants.UUID));

		LOGGER.info(Constants.START_REQUEST, request.getRequestURI());

		Util.printHeaders(request);

		return true;
	}

}

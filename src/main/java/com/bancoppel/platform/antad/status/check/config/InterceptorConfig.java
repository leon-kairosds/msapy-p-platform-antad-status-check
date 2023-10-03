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

package com.bancoppel.platform.antad.status.check.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.interceptor.BexInterceptor;

/**
 * Clase de configuración que hereda de WebMvcConfigurer para interceptar
 * cualquier petición.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	/**
	 * Bean que se ejecuta antes del controlador para validar la sesión.
	 */
	@Autowired
	private BexInterceptor bexInterceptor;

	/**
	 * Clase de constantes referentes a los valores de las APIS.
	 */
	@Autowired
	private ApiConstants apiConstants;

	/**
	 * Método addInterceptors para registrar los interceptor existentes.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(bexInterceptor).addPathPatterns(apiConstants.getInterceptorPath());
	}

}

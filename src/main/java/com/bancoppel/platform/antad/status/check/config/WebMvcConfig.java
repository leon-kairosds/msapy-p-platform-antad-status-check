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
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;

/**
 * Clase de configuración para el contexto web-mvc.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * Bean de constantes obtenidas del archivo properties.
	 */
	@Autowired
	private ApiConstants apiConstants;

	/**
	 * Método de auto-configuración para ignorar el Media-type.
	 *
	 * @param configurer - configurer
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(Boolean.TRUE).ignoreAcceptHeader(Boolean.TRUE);
	}

	/**
	 * Indicar la URI de los recursos.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(apiConstants.getLabel()).addResourceLocations(apiConstants.getResourceLocation());
		registry.addResourceHandler(apiConstants.getWebjars()).addResourceLocations(apiConstants.getWebjarsLocation());

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

}

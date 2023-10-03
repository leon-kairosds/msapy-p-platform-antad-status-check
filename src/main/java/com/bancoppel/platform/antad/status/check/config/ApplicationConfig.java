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

package com.bancoppel.platform.antad.status.check.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.bancoppel.platform.antad.status.check.component.CustomFeignErrorDecoder;

/**
 * Beans generales de configuración.
 */
@Configuration
public class ApplicationConfig {

	/**
	 * Bean para validar query params, request params y body params
	 * 
	 * @return postprocessor del methodvalidation.
	 */
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	/**
	 * Bean para procesar respuestas diferentes a 200 en peticiones feign.
	 * 
	 * @return errordecoder de customfeign.
	 */
	@Bean
	public CustomFeignErrorDecoder customFeignErrorDecoder() {
		return new CustomFeignErrorDecoder();
	}
}

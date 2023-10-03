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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bancoppel.platform.antad.status.check.constant.ApiConstants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase de configuración para swagger-ui.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Bean para obtener valores del archivo properties.
	 */
	@Autowired
	private ApiConstants apiConstants;

	/**
	 * Bean para escanear las APIs existentes y generar swagger-ui.
	 * 
	 * @return product api
	 */
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(Boolean.FALSE).select()
				.apis(RequestHandlerSelectors.basePackage(apiConstants.getBasePackage())).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	/**
	 * Builder de the ApiInfo.
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(apiConstants.getTitle()).description(apiConstants.getDescriptionApi())
				.version(apiConstants.getVersion()).contact(new Contact(apiConstants.getNameDeveloper(),
						apiConstants.getContactUrl(), apiConstants.getEmailDeveloper()))
				.build();
	}

}

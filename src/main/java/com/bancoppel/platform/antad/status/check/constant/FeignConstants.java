/*
 * Copyright (c) 2019 Bancoppel
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

package com.bancoppel.platform.antad.status.check.constant;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
public class FeignConstants {

 
  /**
   * Constante que representa el nombre del feign get payment agreement.
   */
  public static final String CATALOG_AGREEMENT_NAME = "${constants.feign.name.getCatalogAgreement}";

 
  /**
   * Constructor privado para evitar la instancia de esta clase.
   */
  private FeignConstants() {}

}

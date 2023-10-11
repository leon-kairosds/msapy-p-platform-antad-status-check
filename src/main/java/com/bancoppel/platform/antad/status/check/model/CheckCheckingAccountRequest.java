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

package com.bancoppel.platform.antad.status.check.model;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @Descripción: POJO que define la petición al servicio.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: Abr 4, 2023
 * @Empresa: Kairos DS
 */

@ApiModel
@Data
public class CheckCheckingAccountRequest {

	/**
	 * Propiedad para el numero de cuenta de la cuenta.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "Numero de cuenta", example = "13000000056")
	private String cuenta;

}

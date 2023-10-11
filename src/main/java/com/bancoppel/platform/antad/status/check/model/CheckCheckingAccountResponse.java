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

package com.bancoppel.platform.antad.status.check.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @Descripción: POJO que define la respuesta del servicio.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: Abr 21, 2023
 * @Empresa: Kairos DS
 */
@Data
@ApiModel
@ToString
public class CheckCheckingAccountResponse {

	/**
	 * Propiedad para el status de la cuenta de la cuenta asociada..
	 */
	private String cuenta;

	/**
	 * Propiedad para el status de la cuenta de la cuenta asociada..
	 */
	private String producto;

	/**
	 * Propiedad para el status de la cuenta de la cuenta asociada..
	 */
	private String num_cte;
	/**
	 * Propiedad para sdo_actual de la cuenta asociada..
	 */
	private String sdo_actual;
	/**
	 * Propiedad para la cuenta clabe de la cuenta asociada..
	 */
	private String status_cta;
	/**
	 * Propiedad para la cuenta clabe de la cuenta asociada..
	 */
	private String telefono;
	/**
	 * Propiedad para la cuenta clabe de la cuenta asociada..
	 */
	private String num_tarjeta;
	/**
	 * Propiedad para la cuenta clabe de la cuenta asociada..
	 */
	private String status_tarjeta;
}
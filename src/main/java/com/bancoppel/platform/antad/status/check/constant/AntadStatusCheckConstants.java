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

package com.bancoppel.platform.antad.status.check.constant;

import lombok.Getter;

import org.springframework.stereotype.Component;

/**
 * 
 * @Descripción: Clase que contiene las constantes del Api de convenios.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: May 4, 2023
 * @Empresa: Kairos DS
 */
@Component
@Getter
public class AntadStatusCheckConstants {
	/**
	 * Descripcion.
	 */
	public static final String LOG_CHECK_STATUS_ANTAD_CONTROLLER = "Post getAntadStatusCheckService";
	/**
	 * Descripcion.
	 */
	public static final String LOG_PAYMENT_ONLINE_CONTROLLER = "Post getPaymentOnlineResponse";
	/**
	 * Descripcion.
	 */
	public static final String LOG_CONFIRMATION_PAYMENT_CONTROLLER = "Post getConfirmationPaymentResponse";
	/**
	 * Constante usada para nombrar el metodo de fallback de negocio.
	 */
	public static final String STATUS_FALLBACK = "getAntadStatusCheckServiceFallback";

	public static final String ACCOUNT_BUSINESS_TIME = "BUSINESS CALL - [Obtiene la cuenta]";
	/**
	 * Descripcion de log de tiempo de inicio para la consulta.
	 */
	public static final String TIME_REPOSITORY_ACCOUNT = "DATABASE CALL - [Obtiene los datos de cuenta del cliente]";
	/**
	 * Mensaje que indica que el convenio del servicio no fue encontrado.
	 */
	public static final String MSG_ACCOUNT_NOT_FOUNT = "Datos del cliente no encotrados";

	public static final String MSG_CARD_NOT_FOUNT = "Datos del cliente no encotrados";

}

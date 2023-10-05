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
	 * Constante que representa la URL del feign send messaging notification.
	 */
	public static final String PAYMENT_ONLINE_URL = "${constants.feign.url.paymentOnline}";
	/**
	 * Constante que representa el nombre del feign send messaging notification.
	 */
	public static final String PAYMENT_ONLINE_NAME = "${constants.feign.name.paymentOnline}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_ONLINE_ENDPOINT = "${constants.feign.path.paymentOnline}";
	/**
	 * Constante que representa la URL del feign send messaging notification.
	 */
	public static final String CONFIRMATION_PAYMENT_URL = "${constants.feign.url.confirmationPayment}";
	/**
	 * Constante que representa el nombre del feign send messaging notification.
	 */
	public static final String CONFIRMATION_PAYMENT_NAME = "${constants.feign.name.confirmationPayment}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String CONFIRMATION_PAYMENT_ENDPOINT = "${constants.feign.path.confirmationPayment}";
	/**
	 * Constante que representa la URL del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_URL = "${constants.feign.url.paymentValidate}";
	/**
	 * Constante que representa el nombre del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_NAME = "${constants.feign.name.paymentValidate}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_ENDPOINT = "${constants.feign.path.paymentValidate}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_AUTORIZACION_URL = "${constants.feign.url.paymentValidate}";
	/**
	 * Constante que representa el nombre del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_AUTORIZACION_NAME = "${constants.feign.name.paymentValidate.autorizacion}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_AUTORIZACION_ENDPOINT = "${constants.feign.path.paymentValidate.autorizacion}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_CONSULTA_ESTATUS_ENDPOINT = "${constants.feign.path.paymentValidate.consultaEstatus}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_NOTIFICACION_POSITIVA_ENDPOINT = "${constants.feign.path.paymentValidate.notificacionPositiva}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String PAYMENT_VALIDATE_NOTIFICACION_NEGATIVA_ENDPOINT = "${constants.feign.path.paymentValidate.notificacionNegativa}";
	/**
	 * Constante que representa la URL del feign send messaging notification.
	 */
	public static final String SEND_MESSAGING_NOTIFICATION_URL = "${constants.feign.url.sendMessagingNotification}";
	/**
	 * Constante que representa el nombre del feign send messaging notification.
	 */
	public static final String SEND_MESSAGING_NOTIFICATION_NAME = "${constants.feign.name.sendMessagingNotification}";
	/**
	 * Constante que representa el endpoint del feign send messaging notification.
	 */
	public static final String SEND_MESSAGING_NOTIFICATION_ENDPOINT = "${constants.feign.path.sendMessagingNotification}";
	/**
   * Constructor privado para evitar la instancia de esta clase.
   */
  private FeignConstants() {}

}

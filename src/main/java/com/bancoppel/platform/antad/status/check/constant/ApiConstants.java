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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Clase que contiene las constantes del API.
 */
@Component
@Getter
public class ApiConstants {

	/**
	 * Constante usada para representar el nombre de la operacion para obtener todos
	 * los convenios con ANTAD
	 */
	public static final String OPERATION_API = "retrieve-check-status-antad";
	/**
	 * Constante usada para representar el nombre de la operacion para obtener todos
	 * los convenios con ANTAD
	 */
	public static final String OPERATION_API_PAYMENT_ONLINE = "send-payment-online";
	/**
	 * Constante usada para representar el nombre de la operacion para obtener todos
	 * los convenios con ANTAD
	 */
	public static final String OPERATION_API_CONFIRMATION_PAYMENT = "send-confirmation-payment";
	/**
	 * Constante utilizada para mostrar el status code 200.
	 */
	public static final int CODE_OK = 200;
	/**
	 * Constante utilizada para mostrar un mensaje acerca de un OK.
	 */
	public static final String OK = "OK";

	/**
	 * Constante utilizada para mostrar el status code 400.
	 */
	public static final int CODE_BAD_REQUEST = 400;

	/**
	 * Constante utilizada para mostrar un mensaje acerca de una petición mal
	 * formada.
	 */
	public static final String BAD_REQUEST = "Bad Request";
	/**
	 * Constante utilizada para mostrar el status code 404.
	 */
	public static final int CODE_RESOURCE_NOT_FOUND = 404;

	/**
	 * Constante utilizada para mostrar un mensaje acerca de recurso que no pudo ser
	 * encontrado.
	 */
	public static final String RESOURCE_NOT_FOUND = "Resource not found";
	/**
	 * Constante utilizada para mostrar el status code 408.
	 */
	public static final int CODE_REQUEST_TIME_OUT = 408;
	/**
	 * Constante utilizada para mostrar un mensaje de time out.
	 */
	public static final String REQUEST_TIME_OUT = "Request time out";
	/**
	 * Constante utilizada para mostrar el status code 500.
	 */
	public static final int CODE_INTERNAL_ERROR = 500;

	/**
	 * Constante utilizada para mostrar un mensaje acerca de un Internal server
	 * error.
	 */
	public static final String INTERNAL_ERROR = "Internal server error";

	/**
	 * Constante utilizada para representar el nombre del header Content-Type.
	 */
	public static final String CONTENT_TYPE = "Content-Type";

	/**
	 * Constante utilizada para representar el nombre del header Accept.
	 */
	public static final String ACCEPT = "Accept";

	/**
	 * Constante utilizada para representar el nombre del header sid.
	 */
	public static final String SID = "sid";

	/**
	 * Constante utilizada para representar el nombre del header uuid.
	 */
	public static final String UUID = "uuid";

	/**
	 * Constante utilizada para representar el nombre del header deviceId.
	 */
	public static final String DEVICE_ID = "deviceId";
	/**
	 * Constante utilizada para representar el nombre del header Authorization.
	 */
	public static final String AUTHORIZATION = "Authorization";
	/**
	 * Constante utilizada para representar el nombre del header client_id.
	 */
	public static final String CLIENT_ID = "client_id";
	/**
	 * Constante utilizada para representar el nombre del header Accept-Language.
	 */
	public static final String ACCEPT_LANGUAGE = "Accept-Language";
	/**
	 * Constante utilizada para representar el nombre del header Host.
	 */
	public static final String HOST = "Host";
	/**
	 * Constante utilizada para representar el nombre del header User-Agent.
	 */
	public static final String USER_AGENT = "User-Agent";
	/**
	 * Constante utilizada para representar el nombre del header Content-Encoding.
	 */
	public static final String CONTENT_ENCODING = "Content-Encoding";
	/**
	 * Constante utilizada para representar el nombre del header Content-Language.
	 */
	public static final String CONTENT_LANGUAGE = "Content-Language";
	/**
	 * Constante utilizada para representar el nombre del header Content-Length.
	 */
	public static final String CONTENT_LENGTH = "Content-Length";
	/**
	 * Constante utilizada para representar el nombre del header Content-MD5.
	 */
	public static final String CONTENT_MD5 = "Content-MD5";
	/**
	 * Constante utilizada para representar el nombre del header Accept-Charset.
	 */
	public static final String ACCEPT_CHARSET = "Accept-Charset";
	/**
	 * Constante utilizada para representar el nombre del header Date.
	 */
	public static final String DATE = "Date";
	/**
	 * Constante utilizada para representar el nombre del header Accept-Encoding.
	 */
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	/**
	 * Constante utilizada para representar el nombre del header ChannelId.
	 */
	public static final String CHANNEL_ID = "Channel_Id";
	/**
	 * Constante utilizada para representar el nombre del header ChannelId.
	 */
	public static final String REFRESH_TOKEN = "refresh_token";
	
	/**
	 * Endpoint del Controlador para restaurar sesion.
	 */
//	public static final String API_ENDPOINT_SERVICE_PAYMENT = "${constants.api.uri.specificPaths.services}";
	
	/**
	 * Constante path base de messaging notifications.
	 */
	public static final String  API_ENDPOINT_MESSAGING_NOTIFICATION = "${api.messaging.notification.send}";
	/**
	 * Constante path base de messaging notifications.
	 */
	public static final String  API_ENDPOINT_CONSULTA_STATUS = "${api.consulta.status}";
	/**
	 * Constante path base de messaging notifications.
	 */
	public static final String  API_ENDPOINT_NOTIFICACION_POSITIVA = "${api.notification.positiva}";
	/**
	 * Constante path base de messaging notifications.
	 */
	public static final String  API_ENDPOINT_NOTIFICACION_NEGATIVA = "${api.notification.negativa}";
	/**
	 * Constante path base de messaging notifications.
	 */
	public static final String  API_ENDPOINT_CATALOG_AGREEMENT = "${api.catalogo.agreement}";
	/**
	 * Constante path base de messaging notifications.
	 */
	public static final String  API_ENDPOINT_ACCOUNT_DETAIL = "${api.account.detail}";
	/**
	 * Constante que contiene el mensaje a logear de msw Request.
	 */
	public static final String LOG_PAYMENT_ONLINE = "SERVICE CALL - [Envio de peticion a payment online]";
	/**
	 * Constante que contiene el mensaje a logear de msw Request.
	 */
	public static final String LOG_CONFIRMATION_PAYMENT = "SERVICE CALL - [Envio de peticion a confirmation payment]";
	/**
	 * Constante que contiene el mensaje a logear de msw Request.
	 */
	public static final String LOG_PAYMENT_VALIDATE = "SERVICE CALL - [Envio de peticion a payment validate]";
	/**
	 * Constante que contiene el mensaje a logear de sendMessagingNotification.
	 */
	public static final String LOG_SEND_MESSAGING_NOTIFICATION = "SERVICE CALL - [Envio de mensaje de notifiación]";
	/**
	 * Constante que contiene el mensaje a logear de getPaymentAgreement.
	 */
	public static final String LOG_PAYMENT_AGREEMENT = "SERVICE CALL - [Obtiene contrato de pago]";
	/**
	 * Descripcion.
	 */
	public static final String LOG_CHECK_CHECKING_ACCOUNT = "SERVICE CALL - [Account Details]";
	/**
	 * Constant path pattern for interceptor.
	 */
	@Value("${constants.api.uri.basePath}")
	private String basePath;
	/**
	 * Constant path pattern for interceptor logout.
	 */
	@Value("${constants.api.uri.interceptorPath}")
	private String interceptorPath;
	/**
	 * Swagger configuration Starts here. Application base package.
	 */
	@Value("${constants.swagger.basePackage}")
	private String basePackage;

	/**
	 * Swagger title.
	 */
	@Value("${constants.swagger.title}")
	private String title;

	/**
	 * Application description.
	 */
	@Value("${constants.swagger.descriptionApi}")
	private String descriptionApi;

	/**
	 * Swagger version.
	 */
	@Value("${constants.swagger.version}")
	private String version;

	/**
	 * Developer name.
	 */
	@Value("${constants.swagger.nameDeveloper}")
	private String nameDeveloper;

	/**
	 * Contact URL.
	 */
	@Value("${constants.swagger.contactUrl}")
	private String contactUrl;

	/**
	 * Developer email.
	 */
	@Value("${constants.swagger.emailDeveloper}")
	private String emailDeveloper;

	/**
	 * Application label.
	 */
	@Value("${constants.swagger.label}")
	private String label;

	/**
	 * Application resourceLocation.
	 */
	@Value("${constants.swagger.resourceLocation}")
	private String resourceLocation;

	/**
	 * Application webjars.
	 */
	@Value("${constants.swagger.webjars}")
	private String webjars;

	/**
	 * Application webjarsLocation.
	 */
	@Value("${constants.swagger.webjarsLocation}")
	private String webjarsLocation;
}

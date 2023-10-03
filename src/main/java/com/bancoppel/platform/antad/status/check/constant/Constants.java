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

/**
 * Clase de constantes.
 */
public class Constants {

	/**
	 * Constante que representa un String 'JSON'.
	 */
	public static final String JSON_STRING = "JSON";
	/**
	 * Formato de hora, fecha y zona horaria.
	 */
	public static final String DATE_TIME_FORMAT_Z = "yyyy-MM-dd'T'HH:mm:ssZ";
	/**
	 * Constante para identificar un password enmascarado.
	 */
	public static final String REGEX_MASK = "\\b[0-9][0-9][a-zA-Z0-9]{6}\\b";
	/**
	 * Constante usada para remplazar un password enmascarado.
	 */
	public static final String REPLACE_MASK = "********";
	/**
	 * Constante utilizada para validar el lenguaje.
	 */
	public static final String REGEX_VALID_LANGUAGE = "en|en-([a-z][a-z]|[A-Z][A-Z])|es|es-([a-z][a-z]|[A-Z][A-Z])";
	/**
	 * Constante para establecer el formato yyMMdd.
	 */
	public static final String FORMATTER_INITIAL = "yyMMdd";
	/**
	 * Constante para establecer el formato yyyy-MM-dd.
	 */
	public static final String FORMATTER_FINISH = "yyyy-MM-dd";
	/**
	 * Constante usada como llave para el atributo id de la sesión.
	 */
	public static final String SID_MDC_LABEL = "mdc.sid";
	/**
	 * Constante usada como llave para el atributo uuid header.
	 */
	public static final String UUID_MDC_LABEL = "mdc.uuid";
	/**
	 * Constante usada como llave para el atributo customer id.
	 */
	public static final String USER_MDC_LABEL = "mdc.user";
	/**
	 * Constante usada como llave para el atributo representative.
	 */
	public static final String REPRESENTATIVE_MDC_LABEL = "mdc.representative";
	/**
	 * Constante para el logear el mensaje de la petición.
	 */
	public static final String LOGIN_REQUEST = "loginRequest: {}";
	/**
	 * Constante para logear el mensaje de respuesta.
	 */
	public static final String LOGIN_RESPONSE = "loginResponse: {}";
	/**
	 * Constante para mostrar un error legacyError.
	 */
	public static final String LEGACY_ERROR_PREFIX = "legacyError: ";
	/**
	 * Constante para logear los headers.
	 */
	public static final String MSG_TO_LOG_HEADER = "[{} : {}]";
	/**
	 * Mensaje para operaciones no autorizadas.
	 */
	public static final String NOT_AUTHORIZED = "Not authorized";
	/**
	 * Constante para la llave req.t0.
	 */
	public static final String T0_REQ_ATTRIBUTE = "req.t0";
	/**
	 * Constante para mostrar el tiempo de petición y respuesta.
	 */
	public static final String TIME_ELAPSED_MESSAGE = "Time elapsed for request/response roundtrip [{}], {}";
	/**
	 * Constante para el mensaje si el chanel id no esta presente.
	 */
	public static final String MISSING_CHANNELID_MSG = "Missing request header 'ChannelId' "
			+ "for method parameter of type String";
	/**
	 * Mensaje cuando el legalRepresentativeId no esta presente.
	 */
	public static final String MISSING_REPRESENTATIVE_MSG = "Required String parameter "
			+ "'legalRepresentativeId' is not present";
	/**
	 * Constante para el legalRepresentativeId.
	 */
	public static final String ERROR_MSG_LEGAL = "{must be 01 to 99=[legalRepresentativeId]}";
	/**
	 * Constante para la anotación UNCHECKED.
	 */
	public static final String UNCHECKED = "unchecked";

	/**
	 * Constante para catClientSegment.
	 */
	public static final String CATSEGMENT = "catClientSegment";
	/**
	 * Constante para el campo del estatus de la migración.
	 */
	public static final String MIGRATIONSTATUS = "migrationStatusId";
	/**
	 * Constante llaves.
	 */
	public static final String MSG_CURLY_BRACKETS = "{}";
	/**
	 * Constante del mensaje de error genérico.
	 */
	public static final String MSG_ERROR_RESPONSE_HAS_NO_BODY = "Failed to parse the playload: Response has no body.";
	/**
	 * Constante del formato de error.
	 */
	public static final String MSG_ERROR_FORMAT = "Failed to parse the playload. The format of the message does not "
			+ "correspond with the predefined for ambar {}";
	/**
	 * Constante del mensaje de estatus.
	 */
	public static final String MSG_STATUS = "status";
	/**
	 * Constante del mensaje de la petición.
	 */
	public static final String MSG_REQUEST = "request";
	/**
	 * Constante del mensaje de respuesta.
	 */
	public static final String MSG_RESPONSE = "response";
	/**
	 * Constante de los detalles de error del cliente feign.
	 */
	public static final String ERROR_FEIGN_DETAILS = "Error feign details {}";

	/**
	 * Constante del estatus default.
	 */
	public static final int DEFAULT_STATUS_HTTP = 0;
	/**
	 * Nombre de la excepción.
	 */
	public static final String DOWN_STREAM_EXCEPTION_NAME = "DownstreamException";
	/**
	 * Constante detalles del error.
	 */
	public static final String ERROR_RESPONSE_DETAILS_FIELD_NAME = "details";
	/**
	 * Constante uuid.
	 */
	public static final String ERROR_RESPONSE_UUID_FIELD_NAME = "uuid";
	/**
	 * Constante estampa de tiempo.
	 */
	public static final String ERROR_RESPONSE_TIMESTAMP_FIELD_NAME = "timestamp";
	/**
	 * Constante para el tipo de cuenta.
	 */
	public static final String ACCOUNT_TYPE_STRING = "accountType";
	/**
	 * Constant that is used to show a message about the begin of the request.
	 */
	public static final String START_REQUEST = "Inicia Llamado [{}]";
	/**
	 * Constante para la palabra header.
	 */
	public static final String HEADER_WORD_CONSTANT = "header";

	/**
	 * Private constructor will prevent the instantiation of this class.
	 */
	private Constants() {

	}

}

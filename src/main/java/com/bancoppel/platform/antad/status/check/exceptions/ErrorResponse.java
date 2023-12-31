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

package com.bancoppel.platform.antad.status.check.exceptions;

import com.bancoppel.platform.antad.status.check.constant.SpecialCharacterConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;

import java.time.ZonedDateTime;

/**
 * Clase error para respuesta del controlador.
 */
@Setter
public class ErrorResponse {

	/**
	 * Tipo de error.
	 */
	private String type;
	/**
	 * Código del error.
	 */
	private String code;
	/**
	 * Detalles del error.
	 */
	private String details;
	/**
	 * Ubicación del error.
	 */
	private String location;
	/**
	 * Información adicional del error.
	 */
	private String moreInfo;
	/**
	 * UUID header de la petición.
	 */
	private String uuid;
	/**
	 * Fecha y hora cuando ocurre el error.
	 */
	private ZonedDateTime timestamp;

	/**
	 * Método para obtener el tipo de error.
	 * 
	 * @return type
	 */
	public String getType() {
		return type != null ? type : SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Método para obtener el código de error.
	 * 
	 * @return code
	 */
	public String getCode() {
		return code != null ? code : SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Método para obtener el detalle del error.
	 * 
	 * @return details
	 */
	public String getDetails() {
		return details != null ? details : SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Método para obtener la ubicación del error.
	 * 
	 * @return location
	 */
	public String getLocation() {
		return location != null ? location : SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Método para obtener la información adicional del error.
	 * 
	 * @return more info
	 */
	public String getMoreInfo() {
		return moreInfo != null ? moreInfo : SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Método para obtener el UUID.
	 * 
	 * @return uuid
	 */
	public String getUuid() {
		return uuid != null ? uuid : SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Método para obtener fecha y hora del error en formato yyyy-MM-dd'T'HH:mm:ssZ.
	 * 
	 * @return timestamp
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

}

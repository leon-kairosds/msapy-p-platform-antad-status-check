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

package com.bancoppel.platform.antad.status.check.exceptions.custom;

import java.util.Collections;
import java.util.List;

/**
 * Excepción de tipo BadRequest.
 */
public class BadRequestException extends RuntimeException {

	/**
	 * Identificador único generado ID.
	 */
	private static final long serialVersionUID = 8925303792177335247L;

	/**
	 * Lista de campos con error.
	 */
	private final List<String> badFields;

	/**
	 * Constructor para inizializar la lista de campos con error.
	 * 
	 * @param message   Mensaje de excepción arrojada por bad request.
	 * @param badFields Lista de campos que originaron la excepción.
	 */
	public BadRequestException(String message, List<String> badFields) {
		super(message);
		this.badFields = Collections.unmodifiableList(badFields);
	}

	/**
	 * Método para obtener la lista de campos.
	 * 
	 * @return List Lista de los campos.
	 */
	public List<String> getBadFields() {
		return badFields;
	}

}

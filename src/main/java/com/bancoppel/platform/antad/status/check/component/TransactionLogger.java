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

package com.bancoppel.platform.antad.status.check.component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.bancoppel.platform.antad.status.check.constant.SpecialCharacterConstants;

import java.time.Instant;

/**
 * Administra la trazabilidad de transacciones.
 */
@RequestScope
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TransactionLogger {

	/**
	 * Nombre de la transacción.
	 */
	private String transaction;
	/**
	 * Tiempo inicial de la transacción.
	 */
	private Instant beginTime;
	/**
	 * Tiempo total de la transacción.
	 */
	private long elapsedTime = 0L;
	/**
	 * Código de error.
	 */
	private String errorCode;
	/**
	 * Descripción del error.
	 */
	private String errorDescription;

	/**
	 * Asgina código de error y la descripción en casa de existir.
	 * 
	 * @param errorCode        parametro para código de error.
	 * @param errorDescription parametro para descripción del error.
	 */
	public void setErrorData(String errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * Método para encender el trazado de la transacción.
	 * 
	 * @param transaction Nombre de la transacción.
	 */
	public void startTransaction(String transaction) {
		this.transaction = transaction;
		this.beginTime = Instant.now();
		this.errorCode = SpecialCharacterConstants.EMPTY_STRING;
		this.errorDescription = SpecialCharacterConstants.EMPTY_STRING;
	}

	/**
	 * Apaga la transación.
	 */
	public void stopTransaction() {
		this.elapsedTime = Instant.now().toEpochMilli() - beginTime.toEpochMilli();
	}

	/**
	 * Generar String de logeo.
	 */
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(this.transaction).append(SpecialCharacterConstants.COMMA_SEPARATOR).append(this.elapsedTime);

		if (!this.errorCode.isEmpty()) {
			output.append(SpecialCharacterConstants.COMMA_SEPARATOR).append(this.errorCode)
					.append(SpecialCharacterConstants.COMMA_SEPARATOR).append(this.errorDescription);
		}

		return output.toString();
	}

	/**
	 * Mensaje de logueo.
	 * 
	 * @param transaction transaction.
	 * @param mg          message.
	 * 
	 * @return Mensaje completo para imprimir en log.
	 */
	public String message(String transaction, String mg) {
		StringBuilder output = new StringBuilder();
		output.append(transaction).append(SpecialCharacterConstants.COMMA_SEPARATOR).append(mg);

		return output.toString();
	}
}

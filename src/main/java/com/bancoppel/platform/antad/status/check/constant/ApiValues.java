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

package com.bancoppel.platform.antad.status.check.constant;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

/**
 * @author Kairos DS - Leon Fernando.
 */
@Component
@Getter
public class ApiValues {

	public static final String SUCESS = "00";
	
	public static final String NOT_FOUND = "NE";
	
	public static final String AUTORIZATED_WITH_NEGATIVE= "R0";
	
	public static final String AUTORIZATED_WITHOUT_NOTIFICATION= "NP";
	
	public static final String TOTAL_AMOUNT = "0";

	public static final String FIRM_AMOUNT = "0";

	public static final String SBC_AMOUNT = "0";

	public static final String REM_AMOUNT = "0";
	
	public static final String TIPO_PAGO = "Pago de Servicios";
	
	/**
	 * Patrón de ruta constante para el cierre de sesión del interceptor.
	 */
	@Value("${constants.apiValues.values.apply.payment.business}")
	private String business;
	
	/**
	 * Variable que representa.
	 */
	@Value("${constants.apiValues.values.apply.payment.currency}")
	private String currency;
	/**
	 * Variable que representa.
	 */
	@Value("${constants.apiValues.values.apply.payment.paymentMethod}")
	private String paymentMethod;
	
	@Value("${constants.apiValues.values.branch}")
	private String branch;
	
	@Value("${constants.apiValues.emailTemplate.antad}")
	private String emailTemplateAntad;
	
	@Value("${constants.apiValues.values.destinationAccountNumber}")
	private String destinationAccountNumber;
	
	@Value("${constants.apiValues.values.categoria}")
	private String categoria;
	
	@Value("${constants.apiValues.values.statusEmisor}")
	private String statusEmisor;
	
	@Value("${constants.apiValues.values.confirmBus}")
	private String confirmationBus;

	@Value("${constants.apiValues.values.reverseBus}")
	private String reverseBus;
	
	@Value("${constants.apiValues.values.horario}")
	private String horario;

}

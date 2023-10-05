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

package com.bancoppel.platform.antad.status.check.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * @author Kairos DS - Leon Fernando.
 *
 *         POJO que define el request de negocio.
 */
@ApiModel
@Getter
@Setter
@NoArgsConstructor
public class MessagingNotificationsRequest {
	/**
	 * Propiedad que indica la plantilla html que usara Latinia.
	 */
	@ApiModelProperty(notes = "Plantilla html a utilizar", example = "BPI_SERANTAD")
	private String idPlantilla;

	/**
	 * Propiedad que indica el modo en que Latinia enviara el mensaje.
	 */
	@NotNull
	@ApiModelProperty(notes = "Modo se enviara el mensaje", example = "1")
	private String tipoMensaje;

	/**
	 * Propiedad que indica el mensaje html que usara Latinia.
	 */
	@ApiModelProperty(notes = "Mensaje html que usara Latinia.", example = "PORTAL_BPI")
	private String idMensaje;

	/**
	 * Propidad que indica el id del usuario bancoppel. En caso de que la propiedad
	 * tenga el valor "000000000" deberan venir con valores correctos las siguients
	 * propiedades: correoAlterno y/o celularAlterno
	 */
	@NotNull
	@ApiModelProperty(notes = "Id del cliente", example = "000000000")
	private String cliente;

	/**
	 * Propiedad que contiene la cuenta.
	 */
	@NotNull
	@ApiModelProperty(notes = "Cuenta del cliente", example = "250088762")
	private String cuenta;

	/**
	 * Propiedad que contiene la tarjeta.
	 */
	@ApiModelProperty(notes = "numero de tarjeta", example = "250088762")
	private String tarjeta;

	/**
	 * Propiedad que contiene el transactionId.
	 */
	@ApiModelProperty(notes = "ID de Transaccion", example = "023101001")
	private String transactionId;

	/**
	 * Propiedad que contiene el status de una accion.
	 */
	@ApiModelProperty(notes = "estatus de la accion", example = "1")
	private int estatus;

	/**
	 * Propiedad que contiene la fecha y hora de registro.
	 */
	@NotNull
	@ApiModelProperty(notes = "Fecha y hora del registro", example = "2021-12-21")
	private String fechaHoraRegistro;

	/**
	 * Propiedad que contiene la fecha y hora de recuperado.
	 */
	@NotNull
	@ApiModelProperty(notes = "Fecha y hora de recuperado", example = "2021-12-21")
	private String fechaHoraRecuperado;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@NotNull
	@ApiModelProperty(notes = "message1", example = "Mensaje 1")
	private String message1;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message2", example = "Mensaje 2")
	private String message2;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message3", example = "Mensaje 3")
	private String message3;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message4", example = "Mensaje 4")
	private String message4;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message5", example = "Mensaje 5")
	private String message5;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message6", example = "Mensaje 6")
	private String message6;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message7", example = "Mensaje 7")
	private String message7;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message8", example = "Mensaje 8")
	private String message8;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message9", example = "Mensaje 9")
	private String message9;

	/**
	 * Propiedad que contiene el mensaje que se mostrara al usuario.
	 */
	@ApiModelProperty(notes = "message10", example = "Mensaje 10")
	private String message10;

	/**
	 * Propiedad no necesaria que contiene el correo del usuario. En caso de que las
	 * propiedades: cliente y celularAlterno. Vengan vacias, nullas o la propiedad
	 * "cliente" con valor: "000000000" esta propiedad se vuelve obligatoria.
	 */
	@ApiModelProperty(notes = "correo alterno", example = "correo@bancoppel.com")
	private String correoAlterno;

	/**
	 * Propiedad no necesaria que contiene el numero de celular del usuario. En caso
	 * de que las propiedades: cliente y correoAlterno. Vengan vacias, nullas o la
	 * propiedad "cliente" con valor: "000000000" esta propiedad se vuelve
	 * obligatoria.
	 */
	@ApiModelProperty(notes = "celular alterno", example = "5512345678")
	private String celularAlterno;

	/**
	 * Propiedad para el importe 1.
	 */
	@NotNull
	@ApiModelProperty(notes = "importe 1", example = "100")
	private BigDecimal importe1;

	/**
	 * Propiedad para el importe 2.
	 */
	@ApiModelProperty(notes = "importe 2", example = "200")
	private BigDecimal importe2;

	/**
	 * Propiedad para el importe 3.
	 */
	@ApiModelProperty(notes = "importe 3", example = "300")
	private BigDecimal importe3;

	/**
	 * Propiedad para el importe 4.
	 */
	@ApiModelProperty(notes = "importe 4", example = "400")
	private BigDecimal importe4;

	/**
	 * Propiedad para el importe 5.
	 */
	@ApiModelProperty(notes = "importe 5", example = "500")
	private BigDecimal importe5;

	/**
	 * Propiedad que contiene la fecha y hora 1.
	 */
	@NotNull
	@ApiModelProperty(notes = "fecha 1", example = "2024-05-04")
	private String fecha1;

	/**
	 * Propiedad que contiene la fecha y hora 2.
	 */
	@NotNull
	@ApiModelProperty(notes = "fecha 2", example = "2024-05-04")
	private String fecha2;
}

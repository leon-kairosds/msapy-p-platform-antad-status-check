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

package com.bancoppel.platform.antad.status.check.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @Descripción: POJO que define la petición al servicio.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: Abr 4, 2023
 * @Empresa: Kairos DS
 */

@ApiModel
@Data
public class AntadStatusCheckRequest {
	
	private String userName;
	private String password;
	private String token;
	private String macAddress;
	private String comercio;
	private String sucursal;
	private String caja;
	private String cajero;
	private String ticket;
	private String folioComercio;
	private String operacion;
	private String referencia;
	private String monto;
	private String emisor;
	private String modoIngreso;
	private String comision;
	private String sku;
	private String referencia2;
	private String referencia3;
	
	private String numAuth;
	private String mensajeTicket;
	private String folioTransaccion;
	
	private String reintento;
	private String invoiceBranch;
	private String originAccountNumber;
	private String virtualUser;
}

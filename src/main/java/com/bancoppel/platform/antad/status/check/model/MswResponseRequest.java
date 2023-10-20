/*
 * Copyright (c) 2023, Bancoppel All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modifications are not
 * permitted.
 *
 * Bancoppel claims copyright in this computer program as an unpublished work.
 *
 * This program is a confidential trade secret and the property of Bancoppel.
 *
 * Use, examination, reproduction, disassembly, decompiling, transfer and/or disclosure to others of
 * all or any part of this software program are strictly prohibited except by express written
 * agreement with Bancoppel.
 *
 * This software is provided by the copyright holders and contributors "as is" and any express or
 * implied warranties, including, but not limited to, the implied warranties of merchantability and
 * fitness for a particular purpose are disclaimed. In no event shall the copyright owner or
 * contributors be liable for any direct, indirect, incidental, special, exemplary, or consequential
 * damages (including, but not limited to, procurement of substitute goods or services; Loss of use,
 * data, or profits; Or business interruption) however caused and on any theory of liability,
 * whether in contract, strict liability, or tort (including negligence or otherwise) arising in any
 * way out of the use of this software, even if advised of the possibility of such damage.
 *
 * Developed by Bancoppel.
 */

package com.bancoppel.platform.antad.status.check.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

/**
 * 
 * @Descripción: POJO que define la petición al servicio.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: May 15, 2023
 * @Empresa: Kairos DS
 */

@ApiModel
@Data
public class MswResponseRequest {
	/**
	 * Propiedad para el numero de categoria del servicio.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "numero de categoria", example = "08")
	private String numCategoria;
	/**
	 * Propiedad para el numero de convenio del servicio.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "numero de convenio", example = "001")
	private String numConvenio;
	/**
	 * Propiedad para el numero de sucursal del servicio.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "ID de la sucursal", example = "0920")
	private String idSucursal;
	/**
	 * Propiedad para el numero de transaccion del servicio.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "transaccion Sucursal", example = "8805")
	private String transSuc;
	@ApiModelProperty(notes = "transaccion Central", example = "1602")
	private String transCentral;
	@ApiModelProperty(notes = "transaccion Interact", example = "20006")
	private String transInteract;
	/**
	 * Propiedad para el folio de sucursal del servicio.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "folio sucursal", example = "9832741112491734")
	private String folioSuc;
	/**
	 * Propiedad para fecha de pago del servicio.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "fecha de pago", example = "2023-05-15")
	private LocalDate fechaPago;
	/**
	 * Propiedad para el numero de trama del servicio.
	 */
	@ApiModelProperty(notes = "numero de trama", example = "1")
	private int numTrama;
	/**
	 * Propiedad para los campos del servicio.
	 */
	@ApiModelProperty(notes = "campos", example = "20087")
	private String campo1;
	private String campo2;
	private String campo3;
	private String campo4;
	private String campo5;
	private String campo6;
	private String campo7;
	private String campo8;
	private String campo9;
	private String campo10;
	private String campo11;
	private String campo12;
	private String campo13;
	private String campo14;
	private String campo15;
	private String campo16;
	private String campo17;
	private String campo18;
	private String campo19;
	private String campo20;
	private String campo21;
	private String campo22;
	private String campo23;
	private String campo24;
	private String campo25;
	private String campo26;
	private String campo27;
	private String campo28;
	private String campo29;
	private String campo30;
	private String campo31;
	private String campo32;
	private String campo33;
	private String campo34;
	private String campo35;
	private String campo36;
	private String campo37;
	private String campo38;
	private String campo39;
	private String campo40;
	/**
	 * Propiedad para el numero de trama del servicio.
	 */
	@ApiModelProperty(notes = "cadena de peticion", example = "20096001 224.00 11111111")
	private String cadenaReq;
	/**
	 * Propiedad para el numero de trama del servicio.
	 */
	@ApiModelProperty(notes = "Cadena de respueta", example = "000009 1 PAGO APLICADO DUMMY 001")
	private String cadenaRply;
	/**
	 * Propiedad para el usuario que inserta en msw response.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "usuario que inserta", example = "93440138")
	private String userInsert;
	/**
	 * Propiedad para la fecha de insercion en msw response.
	 */
	@NotEmpty
	@ApiModelProperty(notes = "fecha de insercion", example = "2023-05-15 10:00:00")
	private String fechaInsert;
}

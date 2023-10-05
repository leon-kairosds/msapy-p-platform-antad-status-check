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

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * POJO que define la respuesta genérica de negocio.
 */
@Getter
@Setter
public class MessagingNotificationsResponse {

	/**
	 * Código de la respuesta.
	 */
	@ApiModelProperty(notes = "codigo de la transaccion")
	private String code;

}

package com.bancoppel.platform.antad.status.check.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties
@ApiModel
public class AntadResponse {
	/**
	 * Propiedad para el usuario de antad.
	 */
	private String userName;
	/**
	 * Propiedad para el password del usuario de antad.
	 */
	private String password;
	/**
	 * Propiedad de el token del servicio de antad.
	 */
	private String token;
	/**
	 * Propiedad para la macAddress del equipo que se utilizara para peticion antad.
	 */
	private String macAddress;
	/**
	 * Propiedad para el comercio.
	 */
	private String comercio;
	/**
	 * Propiedad para el campo respCode.
	 */
	private String respCode;
	/**
	 * Propiedad para el campo NumAuth.
	 */
	private String NumAuth;
	/**
	 * Propiedad para el campo mensajeTicket.
	 */
	private String mensajeTicket;
	/**
	 * Propiedad para el campo mensajeCajero.
	 */
	private String mensajeCajero;
	/**
	 * Propiedad para el campo folioTransaccion.
	 */
	private String folioTransaccion;

	/**
	 * Propiedad para el campo folioComercio.
	 */
	private String folioComercio;
	/**
	 * Propiedad de el campo comision.
	 */
	private String comision;
	/**
	 * Propiedad de el campo datosAdicionales.
	 */
	private String datosAdicionales;

	/**
	 * Propiedad de el campo claveAcceso.
	 */
	private String claveAcceso;

	/**
	 * Propiedad de el campo comision.
	 */
	@Value("${constants.apiValues.values.sucursal}")
	private String sucursal;
	/**
	 * Propiedad de el campo datosAdicionales.
	 */
	@Value("${constants.apiValues.values.caja}")
	private String caja;

	/**
	 * Propiedad de el campo claveAcceso.
	 */
	@Value("${constants.apiValues.values.cajero}")
	private String cajero;

}

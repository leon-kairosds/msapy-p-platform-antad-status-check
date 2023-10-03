package com.bancoppel.platform.antad.status.check.exceptions.custom;

/**
 * 
 * @Descripción: Clase para gestionar los errores de conexion con la base de
 *               datos.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: May 4, 2023
 * @Empresa: Coppel DSB III
 */
public class DatabaseTimeoutException extends RuntimeException {

	/**
	 * ID unico generado.
	 */
	private static final long serialVersionUID = 1564916113132251702L;

	/**
	 * Constructor por defecto.
	 */
	public DatabaseTimeoutException() {
		super();
	}

	/**
	 * Constructor que define el mensage de error.
	 */
	public DatabaseTimeoutException(String message) {
		super(message);
	}

	/**
	 * Constructor que encapsula una excepcion del tipo throwable.
	 */
	public DatabaseTimeoutException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Constructor para definir el mensaje y encapsular la excepcion.
	 * 
	 * @param arg0 Mensaje de la excepcion.
	 * @param arg1 Excepcion a encapsular.
	 */
	public DatabaseTimeoutException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}

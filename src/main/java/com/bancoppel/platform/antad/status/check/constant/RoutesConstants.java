package com.bancoppel.platform.antad.status.check.constant;

public class RoutesConstants {

	/**
	 * Base path del ms.
	 */
	public static final String BASE_PATH = "${constants.api.uri.basePath}";
	/**
	 * Constante para el path.
	 */
	public static final String RETRIEVE_CATALOG_PATH = "${api.detail.mapping}";

	/**
	 * Constante para el path.
	 */
	public static final String SEND_PAYMENT_ONLINE_PATH = "${api.payment.online.mapping}";

	/**
	 * Constante para el path.
	 */
	public static final String SEND_CONFIRMATION_PAYMENT_PATH = "${api.confirmation.payment.mapping}";
	

	/**
	 * Constructor privado para evitar la instancia de esta clase.
	 */
	private RoutesConstants() {

	}

}

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

package com.bancoppel.platform.antad.status.check.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Clase con constantes para mapeo de parámetros de entrada.
 * 
 * @author Kairos DS - Leon Fernando.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MappingConstants {

	/**
	 * Nombre del campo originCustomerNumber.
	 */
	public static final String ORIGIN_CUSTOMER_NUMBER_FIELD_NAME = "originCustomerNumber";

	/**
	 * Nombre del campo business.
	 */
	public static final String BUSINESS_FIELD_NAME = "business";

	/**
	 * Nombre del campo virtualBranch.
	 */
	public static final String VIRTUAL_BRANCH_FIELD_NAME = "virtualBranch";

	/**
	 * Nombre del campo virtualUser.
	 */
	public static final String VIRTUAL_USER_FIELD_NAME = "virtualUser";

	/**
	 * Nombre del campo transCarg.
	 */
	public static final String CARGO_TRANSACTION_FIELD_NAME = "transCarg";

	/**
	 * Nombre del campo transPayment.
	 */
	public static final String ABONO_TRANSACTION_FIELD_NAME = "transPayment";

	/**
	 * Nombre del campo transBranch.
	 */
	public static final String BRANCH_TRANSACTION_FIELD_NAME = "transBranch";

	/**
	 * Nombre del campo originAccountNumber.
	 */
	public static final String ORIGIN_ACCOUNT_NUMBER_FIELD_NAME = "originAccountNumber";

	/**
	 * Nombre del campo destinationAccountNumber.
	 */
	public static final String DESTINATION_ACCOUNT_NUMBER_FIELD_NAME = "destinationAccountNumber";

	/**
	 * Nombre del campo check.
	 */
	public static final String CHECK_FIELD_NAME = "check";

	/**
	 * Nombre del campo amount.
	 */
	public static final String AMOUNT_FIELD_NAME = "amount";

	/**
	 * Nombre del campo currency.
	 */
	public static final String CURRENCY_FIELD_NAME = "currency";

	/**
	 * Nombre del campo reference.
	 */
	public static final String REFERENCE_FIELD_NAME = "reference";

	/**
	 * Nombre del campo numCardOrigin.
	 */
	public static final String ORIGIN_CARD_NUMBER_FIELD_NAME = "numCardOrigin";

	/**
	 * Nombre del campo numCardDestination.
	 */
	public static final String DESTINATION_CARD_NUMBER_FIELD_NAME = "numCardDestination";

	/**
	 * Nombre del campo userAuthorizes.
	 */
	public static final String USER_AUTHORIZES_FIELD_NAME = "userAuthorizes";

	/**
	 * Nombre del campo amountAll.
	 */
	public static final String TOTAL_AMOUNT_FIELD_NAME = "amountAll";

	/**
	 * Nombre del campo amountFirme.
	 */
	public static final String FIRM_AMOUNT_FIELD_NAME = "amountFirme";

	/**
	 * Nombre del campo amountSBS.
	 */
	public static final String SBC_AMOUNT_FIELD_NAME = "amountSBS";

	/**
	 * Nombre del campo amountRem.
	 */
	public static final String REM_AMOUNT_FIELD_NAME = "amountRem";

	/**
	 * Nombre del campo daysRet.
	 */
	public static final String RET_DAYS_FIELD_NAME = "daysRet";

	/**
	 * Nombre del campo docto.
	 */
	public static final String DOCTO_FIELD_NAME = "docto";

	/**
	 * Nombre del campo category.
	 */
	public static final String CATEGORY_FIELD_NAME = "category";

	/**
	 * Nombre del campo agreement.
	 */
	public static final String AGREEMENT_FIELD_NAME = "agreement";

	/**
	 * Nombre del campo refPhone.
	 */
	public static final String PHONE_REF_FIELD_NAME = "refPhone";

	/**
	 * Nombre del campo refChecker.
	 */
	public static final String VERIFIER_REF_FIELD_NAME = "refChecker";

	/**
	 * Nombre del campo paymentMethod.
	 */
	public static final String PAYMENT_METHOD_FIELD_NAME = "paymentMethod";

	/**
	 * Nombre del campo paymentType.
	 */
	public static final String PAYMENT_TYPE_FIELD_NAME = "paymentType";

	/**
	 * Nombre del campo agreementAmount.
	 */
	public static final String AGREEMENT_AMOUNT_FIELD_NAME = "agreementAmount";

	/**
	 * Nombre del campo agreementTaxAmount.
	 */
	public static final String AGREEMENT_TAX_AMOUNT_FIELD_NAME = "agreementTaxAmount";

	/**
	 * Nombre del campo agreementAmount.
	 */
	public static final String CUSTOMER_AMOUNT_FIELD_NAME = "customerAmount";

	/**
	 * Nombre del campo agreementTaxAmount.
	 */
	public static final String CUSTOMER_TAX_AMOUNT_FIELD_NAME = "customerTaxAmount";

	/**
	 * Nombre del campo agreementTaxAmount.
	 */
	public static final String REPONSE_CODE_BUS = "codeResponseBus";

	/**
	 * Nombre del campo invoiceBranch.
	 */
	public static final String INVOICE_BRANCH = "invoiceBranch";

	public static final String COMISSION_AMOUNT_FIELD_NAME = "commissionAmount";
	public static final String TAX_AMOUNT_FIELD_NAME = "commissiontaxAmount";

	public static final String COMISSION_AMOUNT_TRANS_FIELD_NAME = "transCommission";
	public static final String TAX_AMOUNT_CODE_TRANS_NAME = "transTaxcommission";

	/**
	 * Nombre del campo agreementTax.
	 */
	public static final String AGREEMENT_TAX_FIELD_NAME = "agreementTax";
	/**
	 * Nombre del campo agreementTax.
	 */
	public static final String AGREEMENT_VALUE_ADDED_TAX_FIELD_NAME = "agreementValueAddedTax";
	/**
	 * Nombre del campo agreementTax.
	 */
	public static final String CLIENT_TAX_FIELD_NAME = "clientTax";
	/**
	 * Nombre del campo agreementTax.
	 */
	public static final String CLIENT_VALUE_ADDED_TAX_FIELD_NAME = "clientValueAddedTax";
}

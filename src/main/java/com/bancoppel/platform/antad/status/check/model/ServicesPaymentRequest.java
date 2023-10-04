/*
 *
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

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.constant.MappingConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * POJO que define la petición del endpoint de pago de servicios.
 */
@Data
@NoArgsConstructor
public class ServicesPaymentRequest {

	/**
	 * Campo numCliente.
	 */
	@NotBlank(message = "originCustomerNumber no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.ORIGIN_CUSTOMER_NUMBER_FIELD_NAME)
	private String originCustomerNumber;

	/**
	 * Campo pEmpresa.
	 */
	@NotBlank(message = "business no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.BUSINESS_FIELD_NAME)
	private String business;

	/**
	 * Campo pSucursal.
	 */
	@NotBlank(message = "virtualBranch no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.VIRTUAL_BRANCH_FIELD_NAME)
	private String virtualBranch;

	/**
	 * Campo pUsuario.
	 */
	@NotBlank(message = "virtualUser no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.VIRTUAL_USER_FIELD_NAME)
	private String virtualUser;

	/**
	 * Campo pTransCargo.
	 */
	@NotBlank(message = "transCarg no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.CARGO_TRANSACTION_FIELD_NAME)
	private String transCarg;

	/**
	 * Campo pTransAbono.
	 */
	@NotBlank(message = "transPayment no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.ABONO_TRANSACTION_FIELD_NAME)
	private String transPayment;

	/**
	 * Campo pTransSuc y cTransacc_suc..
	 */
	@NotNull(message = "transBranch no puede ser nulo.")
	@JsonProperty(MappingConstants.BRANCH_TRANSACTION_FIELD_NAME)
	private String transBranch;

	/**
	 * Campo pNumCtaOrigen.
	 */
	@NotBlank(message = "originAccountNumber no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.ORIGIN_ACCOUNT_NUMBER_FIELD_NAME)
	private String originAccountNumber;

	/**
	 * Campo pNumCtaDestino.
	 */
	@NotBlank(message = "destinationAccountNumber no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.DESTINATION_ACCOUNT_NUMBER_FIELD_NAME)
	private String destinationAccountNumber;

	/**
	 * Campo pCheque.
	 */
	@NotNull(message = "check no puede ser nulo.")
	@JsonProperty(MappingConstants.CHECK_FIELD_NAME)
	private String check;

	/**
	 * Campo pMonto.
	 */
	@NotNull(message = "amount no puede ser nulo.")
	@DecimalMin(value = "-1", inclusive = false, message = Constants.LOG_BADREQUEST_DECIMAL)
	@JsonProperty(MappingConstants.AMOUNT_FIELD_NAME)
	private String amount;

	/**
	 * Campo pMoneda.
	 */
	@NotBlank(message = "currency no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.CURRENCY_FIELD_NAME)
	private String currency;

	/**
	 * Campo pReferencia.
	 */
	@NotBlank(message = "reference no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.REFERENCE_FIELD_NAME)
	private String reference;

	/**
	 * Campo pNumTarjetaOrigen.
	 */
	@NotNull(message = "numCardOrigin no puede ser nulo.")
	@JsonProperty(MappingConstants.ORIGIN_CARD_NUMBER_FIELD_NAME)
	private String numCardOrigin;

	/**
	 * Campo pNumTarjetaDestino.
	 */
	@NotNull(message = "numCardDestination no puede ser nulo.")
	@JsonProperty(MappingConstants.DESTINATION_CARD_NUMBER_FIELD_NAME)
	private String numCardDestination;

	/**
	 * Campo pUsuAutoriza.
	 */
	@NotNull(message = "userAuthorizes no puede ser nulo.")
	@JsonProperty(MappingConstants.USER_AUTHORIZES_FIELD_NAME)
	private String userAuthorizes;

	/**
	 * Campo pMontoTotal.
	 */
	@NotNull(message = "amountAll no puede ser nulo.")
	@JsonProperty(MappingConstants.TOTAL_AMOUNT_FIELD_NAME)
	private BigDecimal amountAll;

	/**
	 * Campo pMontoFirme.
	 */
	@NotNull(message = "amountFirme no puede ser nulo.")
	@JsonProperty(MappingConstants.FIRM_AMOUNT_FIELD_NAME)
	private BigDecimal amountFirme;

	/**
	 * Campo pMontoSBC.
	 */
	@NotNull(message = "amountSBS no puede ser nulo.")
	@JsonProperty(MappingConstants.SBC_AMOUNT_FIELD_NAME)
	private BigDecimal amountSBS;

	/**
	 * Campo pMontoRem.
	 */
	@NotNull(message = "amountRem no puede ser nulo.")
	@JsonProperty(MappingConstants.REM_AMOUNT_FIELD_NAME)
	private BigDecimal amountRem;

	/**
	 * Campo pDiasRet s.
	 */
	@NotNull(message = "daysRet no puede ser nulo.")
	@JsonProperty(MappingConstants.RET_DAYS_FIELD_NAME)
	private String daysRet;

	/**
	 * Campo pDocto.
	 */
	@NotNull(message = "docto no puede ser nulo.")
	@JsonProperty(MappingConstants.DOCTO_FIELD_NAME)
	private String docto;

	/**
	 * Campo pCategoria.
	 */
	@NotBlank(message = "category no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.CATEGORY_FIELD_NAME)
	private String category;

	/**
	 * Campo pConvenio.
	 */
	@NotBlank(message = "agreement no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.AGREEMENT_FIELD_NAME)
	private String agreement;

	/**
	 * Campo cRefTelefono.
	 */
	@NotBlank(message = "refPhone no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.PHONE_REF_FIELD_NAME)
	private String refPhone;

	/**
	 * Campo cRefVerificador.
	 */
	@NotBlank(message = "refChecker no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.VERIFIER_REF_FIELD_NAME)
	private String refChecker;

	/**
	 * Campo cFormaPago.
	 */
	@NotBlank(message = "paymentMethod no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.PAYMENT_METHOD_FIELD_NAME)
	private String paymentMethod;

	/**
	 * Diferenciador entre GDF y otros.
	 */
	@NotBlank(message = "paymentType no puede ser vació/nulo.")
	@JsonProperty(MappingConstants.PAYMENT_TYPE_FIELD_NAME)
	private String paymentType;

	/**
	 * Campo commissiontaxAmount.
	 */
	@JsonProperty(MappingConstants.AGREEMENT_AMOUNT_FIELD_NAME)
	private String agreementAmount;

	/**
	 * Campo commissionAmount.
	 *
	 */
	@JsonProperty(MappingConstants.AGREEMENT_TAX_AMOUNT_FIELD_NAME)
	private String agreementTaxAmount;
	/**
	 * Campo commissiontaxAmount.
	 */
	@JsonProperty(MappingConstants.TAX_AMOUNT_FIELD_NAME)
	private String commissiontaxAmount;

	/**
	 * Campo commissionAmount.
	 */
	@JsonProperty(MappingConstants.COMISSION_AMOUNT_FIELD_NAME)
	private String commissionAmount;

	/**
	 * Campo commissiontaxAmount.
	 */
	@JsonProperty(MappingConstants.CUSTOMER_AMOUNT_FIELD_NAME)
	private String customerAmount;

	/**
	 * Campo commissionAmount.
	 */
	@JsonProperty(MappingConstants.CUSTOMER_TAX_AMOUNT_FIELD_NAME)
	private String customerTaxAmount;

	/**
	 * Campo codeResponseBus.
	 */
	@JsonProperty(MappingConstants.REPONSE_CODE_BUS)
	private String codeResponseBus;

	/**
	 * Campo invoiceBranch.
	 */
	@JsonProperty(MappingConstants.INVOICE_BRANCH)
	private String invoiceBranch;

	/**
	 * Campo pTransCargo.
	 */
	@JsonProperty(MappingConstants.COMISSION_AMOUNT_TRANS_FIELD_NAME)
	private String transCommission;

	/**
	 * Campo pTransAbono.
	 */
	@JsonProperty(MappingConstants.TAX_AMOUNT_CODE_TRANS_NAME)
	private String transTaxcommission;

	/**
	 * Campo agreementTax.
	 */
	@JsonProperty(MappingConstants.AGREEMENT_TAX_FIELD_NAME)
	private String agreementTax;

	/**
	 * Campo agreementValueAddedTax.
	 */
	@JsonProperty(MappingConstants.AGREEMENT_VALUE_ADDED_TAX_FIELD_NAME)
	private String agreementValueAddedTax;

	/**
	 * Campo clientTax.
	 */
	@JsonProperty(MappingConstants.CLIENT_TAX_FIELD_NAME)
	private String clientTax;

	/**
	 * Campo clientValueAddedTax.
	 */
	@JsonProperty(MappingConstants.CLIENT_VALUE_ADDED_TAX_FIELD_NAME)
	private String clientValueAddedTax;

}

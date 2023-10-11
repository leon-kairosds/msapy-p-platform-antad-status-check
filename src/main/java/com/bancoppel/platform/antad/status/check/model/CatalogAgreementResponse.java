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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class CatalogAgreementResponse {
	/**
	 * Propiedad para el numero de convenio del servicio.
	 */
	private String agreementNumber;
	/**
	 * Propiedad para el numero de categoria del servicio.
	 */
	private String categoryNumber;
	/**
	 * Propiedad de la cuenta prestadora del servicio.
	 */
	private String providerAccount;
	/**
	 * Propiedad para el estatus del convenio del servicio.
	 */
	private String agreementStatus;
	/**
	 * Propiedad para el campo trans_suc_cargo.
	 */
	private String chargeSubsidiary;
	/**
	 * Propiedad para el campo trans_cen_cargo_cliente.
	 */
	private String paymentClient;
	/**
	 * Propiedad para el campo trans_cen_abono_convenio.
	 */
	private String chargeAgreement;
	/**
	 * Propiedad para el numero de la cuenta destino.
	 */
	private String targetAccount;
	/**
	 * Propiedad para el nombre del convenio.
	 */
	private String agreementName;
	/**
	 * Propiedad para el numero de transacción.
	 */
	private String transaccionNumber;

	/**
	 * Propiedad de la fecha de apertura del servicio.
	 */
	private String openingDate;
	/**
	 * Propiedad de la fecha de clausura del servicio.
	 */
	private String closingDate;
	/**
	 * Propiedad de la fecha de alta del servicio.
	 */
	private String registerDate;
	/**
	 * Propiedad del estatus del convenio del servicio.
	 */
	private String statusAgreement;
	/**
	 * Propiedad del tipo de referencia del servicio.
	 */
	private String referenceType;
	/**
	 * Propiedad del nombre legal del convenio del servicio.
	 */
	private String legalAgreementName;
	/**
	 * Propiedad del rfc del convenio del servicio.
	 */
	private String agreementRfc;
	/**
	 * Propiedad del nombre comercial del convenio del servicio.
	 */
	private String businessAgreementName;
	/**
	 * Propiedad de la direccion del convenio del servicio.
	 */
	private String addressAgreement;
	/**
	 * Propiedad de la ciudad del convenio del servicio.
	 */
	private String city;
	/**
	 * Propiedad del estado del convenio del servicio.
	 */
	private String estate;
	/**
	 * Propiedad del codigo del convenio del servicio.
	 */
	private String zipCode;
	/**
	 * Propiedad del departamento del convenio del servicio.
	 */
	private String department;
	/**
	 * Propiedad del telefono corporativo del convenio del servicio.
	 */
	private String corporatePhoneNumber;
	/**
	 * Propiedad del fax corporativo del convenio del servicio.
	 */
	private String corporateFaxNumber;
	/**
	 * Propiedad del nombre de contacto del convenio del servicio.
	 */
	private String contactName1;
	/**
	 * Propiedad del numero de telefono del contacto del convenio del servicio.
	 */
	private String contactNumberPhone1;
	/**
	 * Propiedad del numero de extension del contacto del convenio del servicio.
	 */
	private String contactExtensionNumber1;
	/**
	 * Propiedad del correo del contacto del convenio del servicio.
	 */
	private String contactEmail1;
	/**
	 * Propiedad del nombre de contacto del convenio del servicio.
	 */
	private String contactName2;
	/**
	 * Propiedad del numero de telefono del contacto del convenio del servicio.
	 */
	private String contactNumberPhone2;
	/**
	 * Propiedad del numero de extension del contacto del convenio del servicio.
	 */
	private String contactExtensionNumber2;
	/**
	 * Propiedad del correo del contacto del convenio del servicio.
	 */
	private String contactEmail2;
	/**
	 * Propiedad del nombre de contacto del convenio del servicio.
	 */
	private String contactName3;
	/**
	 * Propiedad del numero de telefono del contacto del convenio del servicio.
	 */
	private String contactNumberPhone3;
	/**
	 * Propiedad del numero de extension del contacto del convenio del servicio.
	 */
	private String contactExtensionNumber3;
	/**
	 * Propiedad del correo del contacto del convenio del servicio.
	 */
	private String contactEmail3;
	/**
	 * Propiedad del numero de la cuenta clabe del servicio.
	 */
	private String accountNumberKey;
	/**
	 * Propiedad del tipo de pago del servicio.
	 */
	private String paymentType;
	/**
	 * Propiedad de la frecuencia de pago del servicio.
	 */
	private String paymentFrequency;
	/**
	 * Propiedad de la bandera del archivo de notificacion del servicio.
	 */
	private String notificationFileFlag;
	/**
	 * Propiedad de la frecuencia de notificacion del servicio.
	 */
	private String notificationFrequency;
	/**
	 * Propiedad de la bandera por comision transaccion del convenio del servicio.
	 */
	private String transactionFeeAgreementflag;
	/**
	 * Propiedad de la comision transaccion del convenio del servicio.
	 */
	private String transactionFeeAgreementValue;
	/**
	 * Propiedad de la bandera por comision total del convenio del servicio.
	 */
	private String totalTransactionFeeAgreementflag;
	/**
	 * Propiedad de la comision total del convenio del servicio.
	 */
	private String totalTransactionFeeAgreementValue;
	/**
	 * Propiedad de la bandera de impuestos comision del convenio del servicio.
	 */
	private String taxComissionAgreementflag;
	/**
	 * Propiedad de impuestos comision del convenio del servicio.
	 */
	private String taxComissionAgreementVaue;
	/**
	 * Propiedad de la bandera total de impuestos comision del convenio del
	 * servicio.
	 */
	private String totalTaxComissionAgreementflag;
	/**
	 * Propiedad del total de impuestos comision del convenio del servicio.
	 */
	private String totalTaxComissionAgreementValue;
	/**
	 * Propiedad de la bandera iva incluido del convenio del servicio.
	 */
	private String vatIncludedAgreementFlag;
	/**
	 * Propiedad del iva incluido del convenio del servicio.
	 */
	private String vatAgreement;
	/**
	 * Propiedad de la bandera por comision del cliente del servicio.
	 */
	private String transactionFeeClientflag;
	/**
	 * Propiedad de la comision del cliente del servicio.
	 */
	private String transactionFeeClientValue;
	/**
	 * Propiedad de la bandera de impuesto del cliente del servicio.
	 */
	private String vatIncludedClientFlag;
	/**
	 * Propiedad del impuesto del cliente del servicio.
	 */
	private String vatClient;
	/**
	 * Propiedad de la bandera de refencia 1 del servicio.
	 */
	private String referenceFlag1;
	/**
	 * Propiedad de la longitud de la referencia 1 del servicio.
	 */
	private String longitudeReference1;
	/**
	 * Propiedad de la bandera del calculo dv de la referencia 1 del servicio.
	 */
	private String checkerDigitCalculationReferenceFlag1;
	/**
	 * Propiedad del nombre de la rutina dv de la referencia 1 del servicio.
	 */
	private String checkerDigitRoutineNameReference1;
	/**
	 * Propiedad de la bandera de refencia 2 del servicio.
	 */
	private String referenceFlag2;
	/**
	 * Propiedad de la longitud de la referencia 2 del servicio.
	 */
	private String longitudeReference2;
	/**
	 * Propiedad de la bandera del calculo dv de la referencia 2 del servicio.
	 */
	private String checkerDigitCalculationReferenceFlag2;
	/**
	 * Propiedad del nombre de la rutina dv de la referencia 2 del servicio.
	 */
	private String checkerDigitRoutineNameReference2;
	/**
	 * Propiedad de la bandera de reporte del servicio.
	 */
	private String reportFlag;
	/**
	 * Propiedad del nombre del reporte del servicio.
	 */
	private String reportName;
	/**
	 * Propiedad de la cuenta prestadora del servicio.
	 */
	private String lenderAccount;
	/**
	 * Propiedad de la cuenta contable del servicio.
	 */
	private String ledgerAccount;
	/**
	 * Propiedad de la transaccion sucursal cargo del servicio.
	 */
	private String transactionBranchCharge;
	/**
	 * Propiedad de la transaccion sucursal efectivo del servicio.
	 */
	private String cashBranchTransaction;
	/**
	 * Propiedad de la transaccion central cargo cliente del servicio.
	 */
	private String centralCustomerChargeTransaction;
	/**
	 * Propiedad de la transaccion central efectivo cliente del servicio.
	 */
	private String customerCashCentralTransaction;
	/**
	 * Propiedad de la transaccion central abono convenio del servicio.
	 */
	private String creditorCashCentralTransaction;
	/**
	 * Propiedad de la transaccion cliq cpl del servicio.
	 */
	private String transactionCliqCpl;
	/**
	 * Propiedad de la transaccion aliq cpl del servicio.
	 */
	private String transactionAliqCpl;
	/**
	 * Propiedad de la transaccion central efectivo cliente del servicio.
	 */
	private String centralTransactionCashClientCpl;
	/**
	 * Propiedad del nombre de referencia 1 del servicio.
	 */
	private String referenceName1;
	/**
	 * Propiedad del nombre de referencia 2 del servicio.
	 */
	private String referenceName2;
	/**
	 * Propiedad del nombre del archivo de cobranza del servicio.
	 */
	private String collectionFileName;
	/**
	 * Propiedad de la ruta del archivo de cobranza del servicio.
	 */
	private String collectionFilePath;
	/**
	 * Propiedad del proceso automatico del servicio.
	 */
	private String automaticProcess;
	/**
	 * Propiedad de la fecha de ultimo pagoa del servicio.
	 */
	private String lastPaymentDate;
	/**
	 * Propiedad del usuario de alta del servicio.
	 */
	private String userRegister;
	/**
	 * Propiedad del usuario de actualizacion del servicio.
	 */
	private String userUpdate;
	/**
	 * Propiedad de la fecha de actualizacion del servicio.
	 */
	private String updateDate;
	/**
	 * Propiedad de pagos programados del servicio.
	 */
	private String scheduledPayments;
	/**
	 * Propiedad de la transaccion central de abono cr del servicio.
	 */
	private String creditCentralTransactionCr;
	/**
	 * Propiedad de la transaccion central de abono cf del servicio.
	 */
	private String creditCentralTransactionCf;
	/**
	 * Propiedad del canal del servicio.
	 */
	private String channel;
	/**
	 * Propiedad del id emisor del servicio.
	 */
	private String senderId;
	/**
	 * Propiedad de la bandera del esquema cycdp del servicio.
	 */
	private String cycdpScheme;
	/**
	 * Propiedad de la cuenta prestadora del servicio.
	 */
	private String queryAheadAntad;
	/**
	 * Propiedad de la bandra del importe del servicio.
	 */
	private String amountFlag;
	/**
	 * Propiedad de la bandera de escaneo codigo de barras del servicio.
	 */
	private String barcodeScanning;
	/**
	 * Propiedad de la bandera de leyenda del servicio.
	 */
	private String messageFlag;
	/**
	 * Propiedad de la longitud minima del servicio.
	 */
	private String minimumLength;
	/**
	 * Propiedad de la longitud maxima del servicio.
	 */
	private String maximumLength;
	/**
	 * Propiedad del tipo de longitud de dato del servicio.
	 */
	private String dataTypeLength;
	/**
	 * Propiedad del horario de inicio del servicio.
	 */
	private String startTime;
	/**
	 * Propiedad del horario de fin del servicio.
	 */
	private String finishTime;
}

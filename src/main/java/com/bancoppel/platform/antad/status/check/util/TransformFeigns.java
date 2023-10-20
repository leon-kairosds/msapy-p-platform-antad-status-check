package com.bancoppel.platform.antad.status.check.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.constant.SpecialCharacterConstants;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentRequest;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;
import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
import com.bancoppel.platform.antad.status.check.constant.ApiValues;
import com.bancoppel.platform.antad.status.check.model.AntadResponse;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
import com.bancoppel.platform.antad.status.check.model.CatalogAgreementResponse;
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountRequest;
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountResponse;
import com.bancoppel.platform.antad.status.check.model.ConsultaEstatusRequest;
import com.bancoppel.platform.antad.status.check.model.IdAgreementRequest;
import com.bancoppel.platform.antad.status.check.model.MessagingNotificationsRequest;
import com.bancoppel.platform.antad.status.check.model.MessagingNotificationsResponse;
import com.bancoppel.platform.antad.status.check.model.MswResponseRequest;
import com.bancoppel.platform.antad.status.check.model.MswResponseResponse;
import com.bancoppel.platform.antad.status.check.model.NotificacionNegativaRequest;
import com.bancoppel.platform.antad.status.check.model.NotificacionPositivaRequest;
import com.bancoppel.platform.antad.status.check.service.feign.IAntadOperationFeign;
import com.bancoppel.platform.antad.status.check.service.feign.ICatalogAgreementFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IConfirmationPaymentFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IDepositAccountDetailFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IPaymentValidateFeign;
import com.bancoppel.platform.antad.status.check.service.feign.ISendMessagingNotificationFeign;

@Service
public class TransformFeigns {
	
	@Autowired
	IPaymentValidateFeign paymentValidateFeign;
	
	@Autowired
	ISendMessagingNotificationFeign messagingNotificationFeign;
	
	@Autowired
	IConfirmationPaymentFeign confirmationPaymentFeign;
	
	@Autowired
	IDepositAccountDetailFeign depositAccountDetailFeign;
	
	@Autowired
	ICatalogAgreementFeign catalogAgreementFeign;
	
	@Autowired
	IAntadOperationFeign antadOperationFeign;
	
	@Autowired
	public ApiValues apiValues;
	
	private String localDat = LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.FORMATTER_FINISH));
	
	private String localDate = LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern(Constants.SEND_NOTIFICATION_DATE_PATTERN));
	
	private LocalDate date = LocalDate.now();
	
	ConsultaEstatusRequest transformConsultaEstatus(AntadStatusCheckRequest antadStatusCheckRequest) {
		
		
		
		ConsultaEstatusRequest consultaEstatusRequest = new ConsultaEstatusRequest();
		
		consultaEstatusRequest.setUserName(antadStatusCheckRequest.getUserName());
		consultaEstatusRequest.setPassword(antadStatusCheckRequest.getPassword());
		consultaEstatusRequest.setToken(antadStatusCheckRequest.getToken());
		consultaEstatusRequest.setMacAddress(antadStatusCheckRequest.getMacAddress());
		consultaEstatusRequest.setComercio(antadStatusCheckRequest.getComercio());
		consultaEstatusRequest.setSucursal(antadStatusCheckRequest.getSucursal());
		consultaEstatusRequest.setCaja(antadStatusCheckRequest.getCaja());
		consultaEstatusRequest.setCajero(antadStatusCheckRequest.getCajero());
		consultaEstatusRequest.setHorario(apiValues.getHorario());
		consultaEstatusRequest.setTicket(antadStatusCheckRequest.getTicket());
		consultaEstatusRequest.setFolioComercio(antadStatusCheckRequest.getFolioComercio());
		consultaEstatusRequest.setOperacion(antadStatusCheckRequest.getOperacion());
		consultaEstatusRequest.setReferencia(antadStatusCheckRequest.getReferencia());
		consultaEstatusRequest.setMonto(antadStatusCheckRequest.getMonto());
		consultaEstatusRequest.setEmisor(antadStatusCheckRequest.getEmisor());
		consultaEstatusRequest.setModoIngreso(antadStatusCheckRequest.getModoIngreso());
		consultaEstatusRequest.setComision(antadStatusCheckRequest.getComision());
		consultaEstatusRequest.setSku(antadStatusCheckRequest.getSku());
		consultaEstatusRequest.setReferencia2(antadStatusCheckRequest.getReferencia2());
		consultaEstatusRequest.setReferencia3(antadStatusCheckRequest.getReferencia3());
		
		return consultaEstatusRequest;
	}
	
	public AntadResponse getConsultaEstatus(AntadStatusCheckRequest request, HttpHeaders httpHeaders) {
		
		return paymentValidateFeign.consultaEstatusRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), transformConsultaEstatus(request)).getBody();	
	}
	
	private NotificacionPositivaRequest transformNotificacionPositiva(AntadStatusCheckRequest antadStatusCheckRequest) {
		
		NotificacionPositivaRequest notificacion = new NotificacionPositivaRequest();
		notificacion.setUserName(antadStatusCheckRequest.getUserName());
		notificacion.setPassword(antadStatusCheckRequest.getPassword());
		notificacion.setToken(antadStatusCheckRequest.getToken());
		notificacion.setMacAddress(antadStatusCheckRequest.getMacAddress());
		notificacion.setComercio(antadStatusCheckRequest.getComercio());
		notificacion.setSucursal(antadStatusCheckRequest.getSucursal());
		notificacion.setCaja(antadStatusCheckRequest.getCaja());
		notificacion.setCajero(antadStatusCheckRequest.getCajero());
		notificacion.setHorario(apiValues.getHorario());
		notificacion.setTicket(antadStatusCheckRequest.getTicket());
		notificacion.setFolioComercio(antadStatusCheckRequest.getFolioComercio());
		notificacion.setOperacion(antadStatusCheckRequest.getOperacion());
		notificacion.setReferencia(antadStatusCheckRequest.getReferencia());
		notificacion.setMonto(antadStatusCheckRequest.getMonto());
		notificacion.setEmisor(antadStatusCheckRequest.getEmisor());
		notificacion.setModoIngreso(antadStatusCheckRequest.getModoIngreso());
		notificacion.setComision(antadStatusCheckRequest.getComision());
		notificacion.setReferencia2(antadStatusCheckRequest.getReferencia2());
		notificacion.setReferencia3(antadStatusCheckRequest.getReferencia3());
		notificacion.setReintento(antadStatusCheckRequest.getReintento());
		notificacion.setFac(localDat);
				
		return notificacion;
	}
	
	public AntadResponse getNotificacionPositiva(AntadStatusCheckRequest request, HttpHeaders httpHeaders) {
		
		return paymentValidateFeign.notificacionPositivaRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), transformNotificacionPositiva(request)).getBody();	
	}
	
	
	private NotificacionNegativaRequest transformNotificacionNegativa(AntadStatusCheckRequest antadStatusCheckRequest) {
		
		NotificacionNegativaRequest notificacion = new NotificacionNegativaRequest();
		notificacion.setUserName(antadStatusCheckRequest.getUserName());
		notificacion.setPassword(antadStatusCheckRequest.getPassword());
		notificacion.setToken(antadStatusCheckRequest.getToken());
		notificacion.setMacAddress(antadStatusCheckRequest.getMacAddress());
		notificacion.setComercio(antadStatusCheckRequest.getComercio());
		notificacion.setSucursal(antadStatusCheckRequest.getSucursal());
		notificacion.setCaja(antadStatusCheckRequest.getCaja());
		notificacion.setCajero(antadStatusCheckRequest.getCajero());
		notificacion.setHorario(apiValues.getHorario());
		notificacion.setTicket(antadStatusCheckRequest.getTicket());
		notificacion.setFolioComercio(antadStatusCheckRequest.getFolioComercio());
		notificacion.setOperacion(antadStatusCheckRequest.getOperacion());
		notificacion.setReferencia(antadStatusCheckRequest.getReferencia());
		notificacion.setMonto(antadStatusCheckRequest.getMonto());
		notificacion.setEmisor(antadStatusCheckRequest.getEmisor());
		notificacion.setModoIngreso(antadStatusCheckRequest.getModoIngreso());
		notificacion.setComision(antadStatusCheckRequest.getComision());
		notificacion.setReferencia2(antadStatusCheckRequest.getReferencia2());
		notificacion.setReferencia3(antadStatusCheckRequest.getReferencia3());
		notificacion.setReintento(antadStatusCheckRequest.getReintento());
		notificacion.setFac(localDat);
				
		return notificacion;
	}
	
	public AntadResponse getNotificacionNegativa(AntadStatusCheckRequest request, HttpHeaders httpHeaders) {
		
		return paymentValidateFeign.notificacionNegativaRequest(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), transformNotificacionNegativa(request)).getBody();	
	}
	
	private ServicesPaymentRequest transformConfirmationPayment(AntadStatusCheckRequest request, CatalogAgreementResponse car, CheckCheckingAccountResponse numberCardDestination, CheckCheckingAccountResponse numberCardOrigin, String responseBus) {
		
		ServicesPaymentRequest servicesPaymentRequest = new ServicesPaymentRequest();

		servicesPaymentRequest.setOriginCustomerNumber(numberCardOrigin.getNum_cte());
		servicesPaymentRequest.setBusiness(apiValues.getBusiness());
		servicesPaymentRequest.setVirtualBranch(apiValues.getBranch());
		servicesPaymentRequest.setVirtualUser(request.getVirtualUser());
		servicesPaymentRequest.setTransCarg(car.getTransactionBranchCharge());
		servicesPaymentRequest.setTransCommission(car.getTransactionBranchCharge()); // Pendiente
		servicesPaymentRequest.setTransPayment(car.getCreditorCashCentralTransaction()); // Pendiente
		servicesPaymentRequest.setTransBranch(car.getCreditorCashCentralTransaction()); // Pendiente
		servicesPaymentRequest.setOriginAccountNumber(request.getOriginAccountNumber());
		servicesPaymentRequest.setDestinationAccountNumber(apiValues.getDestinationAccountNumber());
		servicesPaymentRequest.setCheck("0");
		servicesPaymentRequest.setAmount(request.getMonto());
		servicesPaymentRequest.setCurrency(apiValues.getCurrency()); // Pendientes
		servicesPaymentRequest.setReference(request.getReferencia());
		servicesPaymentRequest.setNumCardOrigin(numberCardOrigin.getNum_tarjeta());
		servicesPaymentRequest.setNumCardDestination(numberCardDestination.getNum_tarjeta());
		servicesPaymentRequest.setUserAuthorizes(request.getVirtualUser());
		servicesPaymentRequest.setAmountAll(new BigDecimal(ApiValues.TOTAL_AMOUNT)); // Pendientes en constatnte
		servicesPaymentRequest.setAmountFirme(new BigDecimal(ApiValues.FIRM_AMOUNT)); // Pendientes en constatnte
		servicesPaymentRequest.setAmountSBS(new BigDecimal(ApiValues.SBC_AMOUNT)); // Pendientes en constatnte
		servicesPaymentRequest.setAmountRem(new BigDecimal(ApiValues.REM_AMOUNT)); // Pendientes en constatnte
		servicesPaymentRequest.setDaysRet("0");
		servicesPaymentRequest.setDocto("0");
		servicesPaymentRequest.setCategory(apiValues.getCategoria());
		servicesPaymentRequest.setAgreement(car.getAgreementNumber());
		servicesPaymentRequest.setRefPhone(numberCardOrigin.getTelefono());
		servicesPaymentRequest.setRefChecker(numberCardOrigin.getTelefono()); // Pendientes
		servicesPaymentRequest.setPaymentMethod(apiValues.getPaymentMethod()); // Pendientes
		servicesPaymentRequest.setPaymentType(ApiValues.TIPO_PAGO); // Pendientes
		servicesPaymentRequest.setAgreementAmount(car.getTransactionFeeAgreementValue()); // Pendiente
		servicesPaymentRequest.setAgreementTaxAmount(car.getTransactionFeeAgreementValue());// Pendiente
		servicesPaymentRequest.setCommissiontaxAmount(car.getTaxComissionAgreementVaue());// Pendiente
		servicesPaymentRequest.setCommissionAmount("0.00");// Pendiente new
															// BigDecimal(car.getTaxComissionAgreementVaue())
		servicesPaymentRequest.setCustomerAmount("0.00");// Pendiente new BigDecimal(car.getPaymentClient())
		servicesPaymentRequest.setCustomerTaxAmount(car.getTransactionFeeClientValue());
		servicesPaymentRequest.setCodeResponseBus(responseBus);
		servicesPaymentRequest.setInvoiceBranch(request.getInvoiceBranch());
		servicesPaymentRequest.setTransCommission(car.getTransactionBranchCharge()); // numero transaccion para aplicar
																						// el importe de comision
		servicesPaymentRequest.setTransTaxcommission(car.getCashBranchTransaction()); // numero transaccion para aplicar
																						// el IVA de comision
		servicesPaymentRequest.setAgreementTax(car.getVatClient()); // el importe de la comision
		servicesPaymentRequest.setAgreementValueAddedTax(car.getVatAgreement()); // el IVA de la comision
		servicesPaymentRequest.setClientTax(car.getVatClient()); // el importe de la comision
		servicesPaymentRequest.setClientValueAddedTax(car.getVatAgreement()); // el IVA de la comision

		return servicesPaymentRequest;
		
	}
	
	public ServicesPaymentResponse getConfirmation(HttpHeaders headers, AntadStatusCheckRequest request, CatalogAgreementResponse car, CheckCheckingAccountResponse numberCardDestination, CheckCheckingAccountResponse numberCardOrigin, String responseBus) {
		
		ResponseEntity<ServicesPaymentResponse> sendConfirmation = confirmationPaymentFeign.sendConfirmationPaymentRequest(
				headers.getFirst(ApiConstants.AUTHORIZATION),
				headers.getFirst(ApiConstants.UUID), 
				headers.getFirst(ApiConstants.ACCEPT),
				headers.getFirst(ApiConstants.DEVICE_ID), 
				headers.getFirst(ApiConstants.CHANNEL_ID),
				transformConfirmationPayment(request, car, numberCardDestination, numberCardOrigin, responseBus));

		return sendConfirmation.getBody();
	
	}
	
	private IdAgreementRequest transformCatalogAgreement(AntadStatusCheckRequest request) {

		IdAgreementRequest agreementRequest = new IdAgreementRequest();
		agreementRequest.setCategoryNumber(apiValues.getCategoria());
		agreementRequest.setIdEmisor(request.getEmisor());
		agreementRequest.setStatus(apiValues.getStatusEmisor());

		return agreementRequest;
	}

	public CatalogAgreementResponse getAgreementId(HttpHeaders headers, AntadStatusCheckRequest request) {

		ResponseEntity<CatalogAgreementResponse> agreementResponse = catalogAgreementFeign.getAgreementId(

				headers.getFirst(ApiConstants.AUTHORIZATION), headers.getFirst(ApiConstants.UUID),
				headers.getFirst(ApiConstants.ACCEPT), headers.getFirst(ApiConstants.DEVICE_ID),
				headers.getFirst(ApiConstants.CHANNEL_ID), transformCatalogAgreement(request));

		return agreementResponse.getBody();

	}
	
	private CheckCheckingAccountRequest transformAccountDetail(String accountNumber) {

		CheckCheckingAccountRequest accountRequest = new CheckCheckingAccountRequest();
		accountRequest.setCuenta(accountNumber);
		return accountRequest;

	}

	public CheckCheckingAccountResponse getAccountDetail(HttpHeaders headers, String accountNumber) {

		ResponseEntity<CheckCheckingAccountResponse> accountDetailResponse = depositAccountDetailFeign.getAccountDetail(
				headers.getFirst(ApiConstants.AUTHORIZATION), headers.getFirst(ApiConstants.UUID),
				headers.getFirst(ApiConstants.ACCEPT), headers.getFirst(ApiConstants.DEVICE_ID),
				headers.getFirst(ApiConstants.CHANNEL_ID), transformAccountDetail(accountNumber));

		return accountDetailResponse.getBody();
	}
	
	private MessagingNotificationsRequest transformMessaginNotification(AntadStatusCheckRequest request, CatalogAgreementResponse car, CheckCheckingAccountResponse numberCardResponse, String idPlantilla, String idMensaje) {
		
		MessagingNotificationsRequest notification = new MessagingNotificationsRequest();

		notification.setIdPlantilla(idPlantilla);
		notification.setTipoMensaje(SpecialCharacterConstants.ONE_VALUE_STRING);
		notification.setIdMensaje(idMensaje);
		notification.setCliente(numberCardResponse.getNum_cte());
		notification.setTransactionId(request.getInvoiceBranch());
		notification.setEstatus(SpecialCharacterConstants.INT_ZERO_VALUE);
		notification.setFechaHoraRegistro(localDate);
		notification.setFechaHoraRecuperado(SpecialCharacterConstants.EMPTY_STRING);
		notification.setCuenta(numberCardResponse.getCuenta());
		notification.setMessage2(car.getAgreementName()); // mensaje 2
		notification.setMessage3(request.getInvoiceBranch()); // mensaje 3
		notification.setMessage4(request.getNumAuth()); // mensaje 4
		notification.setMessage5(request.getMensajeTicket()); // mensaje 5
		notification.setMessage6("");
		notification.setMessage7("");
		notification.setMessage8("");
		notification.setMessage9(request.getFolioTransaccion()); // mensaje 9
		notification.setMessage10(request.getReferencia()); // mensaje 10
		notification.setCorreoAlterno("");
		notification.setCelularAlterno("");
		notification.setImporte1(null);
		notification.setImporte2(null);
		notification.setImporte4(null);
		notification.setImporte5(null);
		notification.setFecha1(localDate);
		notification.setFecha2(localDate);
		notification.setImporte3(new BigDecimal(request.getMonto())); // importe 3
		notification.setCuenta(maskAccount(request.getOriginAccountNumber()));
		notification.setTarjeta(maskAccount(numberCardResponse.getNum_tarjeta()));
		notification.setMessage1(maskAccount(request.getOriginAccountNumber())); // mensaje 1

		return notification;
		
	} 
	
	private MswResponseRequest tranformMswResponse(AntadStatusCheckRequest request, CatalogAgreementResponse car, AntadResponse response, String invoiceBranch) {
		
		MswResponseRequest respuesta = new MswResponseRequest();
		
		respuesta.setNumCategoria(apiValues.getCategoria());
		respuesta.setNumConvenio(car.getAgreementNumber());
		respuesta.setIdSucursal(apiValues.getSucursal());
		respuesta.setFolioSuc(invoiceBranch);
		respuesta.setTransSuc(car.getTransactionBranchCharge());
		respuesta.setFechaPago(date);
		respuesta.setNumTrama(apiValues.getNumTrama());
		respuesta.setCampo1(response.getUserName());
		respuesta.setCampo2(response.getPassword());
		respuesta.setCampo3(response.getToken());
		respuesta.setCampo4(response.getMacAddress());
		respuesta.setCampo5(response.getComercio());
		respuesta.setCampo6(response.getRespCode());
		respuesta.setCampo7(response.getNumAuth());
		respuesta.setCampo8(response.getMensajeTicket());
		respuesta.setCampo9(response.getMensajeCajero());
		respuesta.setCampo10(response.getFolioTransaccion());
		respuesta.setCampo11(response.getFolioComercio());
		respuesta.setCampo12(response.getComision());
		respuesta.setCampo13(response.getDatosAdicionales());
		respuesta.setCampo14(response.getClaveAcceso());
		respuesta.setCampo15(apiValues.getComercio());
		respuesta.setCampo16(apiValues.getCaja());
		respuesta.setCampo17(apiValues.getCajero());
		respuesta.setCampo18(apiValues.getOperacionConsul());
		respuesta.setCadenaReq(request.toString());
		respuesta.setCadenaRply(response.toString());
		respuesta.setUserInsert(apiValues.getUsuario());
		respuesta.setFechaInsert(localDate);
		
		return respuesta;
	}
	
	public MswResponseResponse sendMswResponse(HttpHeaders httpHeaders, AntadStatusCheckRequest request, CatalogAgreementResponse car, AntadResponse response, String invoiceBranch) {
		
		return antadOperationFeign.sendMswResponse(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), tranformMswResponse(request, car, response,invoiceBranch)).getBody();
	}
	
	public MessagingNotificationsResponse sendMessagingNotification (HttpHeaders httpHeaders, AntadStatusCheckRequest request, CatalogAgreementResponse car, CheckCheckingAccountResponse numberCardResponse, String idPlantilla, String idMensaje) {
		
		ResponseEntity<MessagingNotificationsResponse> sendNotification = messagingNotificationFeign.sendMessagingNotification(
				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
				httpHeaders.getFirst(ApiConstants.UUID), 
				httpHeaders.getFirst(ApiConstants.ACCEPT),
				httpHeaders.getFirst(ApiConstants.CHANNEL_ID),
				httpHeaders.getFirst(ApiConstants.DEVICE_ID), 
				transformMessaginNotification(request, car, numberCardResponse,idPlantilla, idMensaje));

		return sendNotification.getBody();	
	}
	
	/**
	 * Método que enmascara las cuentas para que tengan un formato en donde solo los
	 * últimos cuatro dígitos sean visibles.
	 *
	 * @param accountNumber El número de cuenta a enmascarar.
	 * @return Número de cuenta enmascarado.
	 */
	protected String maskAccount(String accountNumber) {
		if (accountNumber.length() > 4) {
			return new StringBuilder(accountNumber).replace(0, accountNumber.length() - 4,
					new String(new char[accountNumber.length() - 4]).replace(SpecialCharacterConstants.SLASH_ZERO,
							SpecialCharacterConstants.MASKED_ACCOUNT_NUMBER_CHARACTER))
					.toString();
		}
		return accountNumber;
	}
	
}

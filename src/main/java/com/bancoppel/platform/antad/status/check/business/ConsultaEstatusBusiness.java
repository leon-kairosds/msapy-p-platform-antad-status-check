//package com.bancoppel.platform.antad.status.check.business;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//
//import com.bancoppel.platform.antad.status.check.constant.ApiConstants;
//import com.bancoppel.platform.antad.status.check.model.AntadResponse;
//import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
//import com.bancoppel.platform.antad.status.check.model.ConsultaEstatusRequest;
//import com.bancoppel.platform.antad.status.check.service.IConsultaEstatusService;
//import com.bancoppel.platform.antad.status.check.service.feign.IPaymentValidateFeign;
//
//public class ConsultaEstatusBusiness implements IConsultaEstatusService{
//	
//	@Autowired
//	IPaymentValidateFeign paymentValidateFeign;
//
//	@Override
//	public AntadResponse getConsultaEstatus(AntadStatusCheckRequest request, HttpHeaders httpHeaders) {
//		
//		return paymentValidateFeign.consultaEstatusRequest(
//				httpHeaders.getFirst(ApiConstants.AUTHORIZATION),
//				httpHeaders.getFirst(ApiConstants.UUID), 
//				httpHeaders.getFirst(ApiConstants.ACCEPT),
//				httpHeaders.getFirst(ApiConstants.DEVICE_ID),
//				httpHeaders.getFirst(ApiConstants.CHANNEL_ID), request).getBody();	
//		
//		
//	}
//}

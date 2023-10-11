/*
 * Copyright (c) 2023 Kairos DS
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

package com.bancoppel.platform.antad.status.check.business;

import com.bancoppel.platform.antad.status.check.constant.ApiValues;
import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.platform.antad.status.check.constant.AntadStatusCheckConstants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DatabaseTimeoutException;
import com.bancoppel.platform.antad.status.check.model.AntadResponse;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckResponse;
import com.bancoppel.platform.antad.status.check.model.CatalogAgreementResponse;
import com.bancoppel.platform.antad.status.check.model.CheckCheckingAccountResponse;
import com.bancoppel.platform.antad.status.check.model.MessagingNotificationsResponse;
import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;
import com.bancoppel.platform.antad.status.check.service.IAntadStatusCheckService;
import com.bancoppel.platform.antad.status.check.service.feign.ICatalogAgreementFeign;
import com.bancoppel.platform.antad.status.check.service.feign.IDepositAccountDetailFeign;
import com.bancoppel.platform.antad.status.check.util.TransformFeigns;

import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @description: Implementa la logica del servicio
 *               {@link IAntadStatusCheckService}.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: May 4, 2023
 * @Empresa: Kairos DS
 */
@Slf4j
@Service
public class AntadStatusCheckBusiness implements IAntadStatusCheckService {

	ScheduledExecutorService executor = null;

	@Autowired
	TransformFeigns feign;
	
	@Autowired
	IDepositAccountDetailFeign depositAccountDetailFeign;
	
	@Autowired
	ICatalogAgreementFeign catalogAgreementFeign;
	
	@Autowired
	ApiValues apiValues;

	int count = 0;

	int aux = 0;

	Boolean bandera = false;

	/**
	 * {@inheritDoc}.
	 */
	@Override
	@HandledProcedure(name = AntadStatusCheckConstants.ACCOUNT_BUSINESS_TIME, value = AntadStatusCheckConstants.ACCOUNT_BUSINESS_TIME, ignoreExceptions = {
			DatabaseTimeoutException.class })
	public AntadStatusCheckResponse getAntadStatusCheckService(AntadStatusCheckRequest request, HttpHeaders headers) {
		log.debug(" ** Request: {}", request);

		executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(tiempoEjecucion(request, headers), 1 /* Retardo inicial */, 1, TimeUnit.SECONDS);

		AntadStatusCheckResponse statusResponse = new AntadStatusCheckResponse();

		log.debug(" ** Response: {}", statusResponse.toString());

		return statusResponse;
	}

	private TimerTask tiempoEjecucion(AntadStatusCheckRequest request, HttpHeaders headers) {
		
		CatalogAgreementResponse getAgreementId = feign.getAgreementId(headers, request);
		CheckCheckingAccountResponse getAccountDetailOrigin = feign.getAccountDetail(headers, request.getOriginAccountNumber());
		CheckCheckingAccountResponse getAccountDetailDestination = feign.getAccountDetail(headers, apiValues.getDestinationAccountNumber());
		
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {

				if (count <= 60) {
					System.out.println("Han transcurrido " + count + " segundos.");
					log.info("Entra a if del maxCount");

					if (count % 5 == 0) { // Validar esl estatus diferente de OK de validate consulta eststus

						AntadResponse consultaEstatus = feign.getConsultaEstatus(request, headers);
						if (consultaEstatus != null) {
							switch (consultaEstatus.getRespCode()) {
							
							case ApiValues.SUCESS:{
								
								//confirmacion?
								ServicesPaymentResponse getConfirmation = 
										feign.getConfirmation(headers, request, getAgreementId, getAccountDetailDestination, getAccountDetailOrigin, apiValues.getConfirmationBus());
								
								//push 
								MessagingNotificationsResponse sendPushNotification = 
										feign.sendMessagingNotification(headers, request, getAgreementId, getAccountDetailDestination, "Pendiente por crear", Constants.ID_MESSAGE_BPI_PGOTCO);
								
								//correo
								MessagingNotificationsResponse getMessagingNotification = 
										feign.sendMessagingNotification(headers, request, getAgreementId, getAccountDetailDestination, apiValues.getEmailTemplateAntad(), Constants.ID_MESSAGE_PORTAL_BPI);
								
								break;
							}
							
							case ApiValues.AUTORIZATED_WITH_NEGATIVE:
							case ApiValues.NOT_FOUND:{
								
								//reverso
								ServicesPaymentResponse getConfirmation = 
										feign.getConfirmation(headers, request, getAgreementId, getAccountDetailDestination, getAccountDetailOrigin, apiValues.getReverseBus());
								//Push negativo
								MessagingNotificationsResponse sendPushNotification = 
										feign.sendMessagingNotification(headers, request, getAgreementId, getAccountDetailDestination, "Pendiente por crear", Constants.ID_MESSAGE_BPI_PGOTCO);
								break;
							}
							
							case ApiValues.AUTORIZATED_WITHOUT_NOTIFICATION:{

								//Notificacion Positiva
								AntadResponse getNotificacionPositiva =
										feign.getNotificacionPositiva(request, headers);
								
								//confirmacion
								ServicesPaymentResponse getConfirmation = 
										feign.getConfirmation(headers, request, getAgreementId, getAccountDetailDestination, getAccountDetailOrigin, apiValues.getConfirmationBus());
								//correo
								MessagingNotificationsResponse getMessagingNotification = 
										feign.sendMessagingNotification(headers, request, getAgreementId, getAccountDetailDestination, apiValues.getEmailTemplateAntad(), Constants.ID_MESSAGE_PORTAL_BPI);
								//push
								MessagingNotificationsResponse sendPushNotification = 
										feign.sendMessagingNotification(headers, request, getAgreementId, getAccountDetailDestination,"Pendiente por crear", Constants.ID_MESSAGE_BPI_PGOTCO);
								break;
							}
								
							}
						}
						System.out.println(
								"Ejecutando consulta estatus con validacion de aux en " + count + " segundos.");
					}

				} else {

					System.out.println("Matar proceso en " + count + " segundos.");

					// if() si el objeto es diferente de nulo en la consulta status del validate o
					// saber si ya regreso la peticion
					resetParametros();
					stopProceso();
				}

				count++;
				executor = null;
			}
		};

		return timerTask;
	}

	private void resetParametros() {
		count = 0;
		executor = null;
		this.aux = 0;
	}

	private void stopProceso() {
		executor.shutdown();
	}
}

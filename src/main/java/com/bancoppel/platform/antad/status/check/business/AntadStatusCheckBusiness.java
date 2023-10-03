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

import com.bancoppel.commons.annotation.HandledProcedure;
import com.bancoppel.platform.antad.status.check.constant.AntadStatusCheckConstants;
import com.bancoppel.platform.antad.status.check.exceptions.custom.DatabaseTimeoutException;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckResponse;
import com.bancoppel.platform.antad.status.check.service.IAntadStatusCheckService;

import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
	
	int count = 0;
	
	int aux = 0;
	
	Boolean bandera = false;
	
	/**
	 * {@inheritDoc}.
	 */
	@Override
	@HandledProcedure(name = AntadStatusCheckConstants.ACCOUNT_BUSINESS_TIME, value = AntadStatusCheckConstants.ACCOUNT_BUSINESS_TIME, ignoreExceptions = {
			DatabaseTimeoutException.class })
	public AntadStatusCheckResponse getAntadStatusCheckService(AntadStatusCheckRequest request) {
		log.debug(" ** Request: {}", request);
		
			    executor = Executors.newScheduledThreadPool(1);
			    executor.scheduleAtFixedRate(tiempoEjecucion(request), 1 /*Retardo inicial*/, 1, TimeUnit.SECONDS);
			    
		AntadStatusCheckResponse statusResponse = new AntadStatusCheckResponse();

		log.debug(" ** Response: {}", statusResponse.toString());

		return statusResponse;
	}
	
	private TimerTask tiempoEjecucion(AntadStatusCheckRequest request) {
		TimerTask timerTask = new TimerTask() {
			
			@Override
			public void run() {
				
				
				if(count <= 60) {
					
					System.out.println("Han transcurrido " + count + " segundos.");
					
					log.info("Entra a if del maxCount");
					
					if(count % 5 == 0) { //Validar esl estatus diferente de OK de validate consulta eststus
						System.out.println("Ejecutando consulta estatus con validacion de aux en " + count + " segundos.");
						
						
					}
					
				} else {
					
					System.out.println("Matar proceso en " + count + " segundos.");
					
					//if() si el objeto es diferente de nulo en la consulta status del validate o saber si ya regreso la peticion
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

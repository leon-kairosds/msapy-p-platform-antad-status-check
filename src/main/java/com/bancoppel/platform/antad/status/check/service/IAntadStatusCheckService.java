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

package com.bancoppel.platform.antad.status.check.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckRequest;
//import com.bancoppel.platform.antad.status.check.model.AntadStatusCheckResponse;
//import com.bancoppel.platform.antad.status.check.model.ServicesPaymentRequest;
//import com.bancoppel.platform.antad.status.check.model.ServicesPaymentResponse;

/**
 * 
 * @Descripción: Define metodo para obtener la cuenta del cliente.
 * @Autor: Kairos DS - Leon Fernando.
 * @Fecha: May 4, 2023
 * @Empresa: Kairos DS
 */
public interface IAntadStatusCheckService {
	
	ResponseEntity<HttpStatus> getAntadStatusCheckService(AntadStatusCheckRequest request, HttpHeaders headers);
}

/*
 * Copyright (c) 2019 Bancoppel
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

package com.bancoppel.platform.antad.status.check.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Configuracion para crear un executor.
 *
 * @author Dario Rodriguez, nova.
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

  /**
   * Tamaño del pool de threads.
   */
  @Value("${executor.threads.core-pool-size}")
  private int corePoolSize;

  /**
   * Maximo tamaño del pool de threads.
   */
  @Value("${executor.threads.max-pool-size}")
  private int maxPoolSize;

  /**
   * Numero de hilos activos.
   */
  @Value("${executor.threads.keep-alive}")
  private int keepAlive;

  /**
   * Cantidad de hilos pendientes de ejecucion.
   */
  @Value("${executor.threads.queue-capacity}")
  private int queueCapacity;

  /**
   * Method to task executor.
   *
   * @return Executor.
   */
  @Bean(name = "taskExecutor")
  public Executor taskExecutor() {

    final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setKeepAliveSeconds(keepAlive);
    executor.setQueueCapacity(queueCapacity);
    executor.setThreadNamePrefix("Close Session -");
    executor.initialize();

    return executor;

  }

}

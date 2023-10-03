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

package com.bancoppel.platform.antad.status.check.exceptions.custom;

/**
 * Exception class to be used when a client is not authorized to perform an
 * operation.
 */
public class UnauthorizedException extends RuntimeException {

	/**
	 * Generated serial unique ID.
	 */
	private static final long serialVersionUID = -2122252302133789399L;

	/**
	 * Constructor by default.
	 */
	public UnauthorizedException() {
		super();
	}

	/**
	 * Constructor that receives the error message.
	 * 
	 * @param message mensaje de la excepción.
	 */
	public UnauthorizedException(String message) {
		super(message);
	}

	/**
	 * Constructor that receives the throwable.
	 * 
	 * @param throwable de la excepción.
	 */
	public UnauthorizedException(Throwable throwable) {
		super(throwable);
	}

}

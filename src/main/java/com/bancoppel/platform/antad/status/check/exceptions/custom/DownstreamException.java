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

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.bancoppel.platform.antad.status.check.constant.ErrorResolverConstants;
import com.bancoppel.platform.antad.status.check.constant.SpecialCharacterConstants;
import com.bancoppel.platform.antad.status.check.exceptions.ErrorResponse;
import com.netflix.hystrix.exception.ExceptionNotWrappedByHystrix;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Class of Exception type that extends of RuntimeException and implements
 * ExceptionNotWrappedByHystrix.
 */
@Getter
public class DownstreamException extends RuntimeException implements ExceptionNotWrappedByHystrix {

	/**
	 * Generated serial unique ID.
	 */
	private static final long serialVersionUID = 3404054956828772740L;

	/**
	 * Status of the error.
	 */
	private final int status;

	/**
	 * Type of the error.
	 */
	private final String type;

	/**
	 * Code of the error.
	 */
	private final String code;

	/**
	 * Details of the error.
	 */
	private final String details;

	/**
	 * Location of the error.
	 */
	private final String location;

	/**
	 * Additional information of the error.
	 */
	private final String moreInfo;

	/**
	 * uuid of the error.
	 */
	private final String uuid;

	/**
	 * Time stamp of the error.
	 */
	private final ZonedDateTime timestamp;

	/**
	 * Initializer of values by default.
	 */
	public DownstreamException() {
		super();

		this.status = Constants.DEFAULT_STATUS_HTTP;
		this.type = SpecialCharacterConstants.EMPTY_STRING;
		this.code = SpecialCharacterConstants.EMPTY_STRING;
		this.details = SpecialCharacterConstants.EMPTY_STRING;
		this.location = SpecialCharacterConstants.EMPTY_STRING;
		this.moreInfo = SpecialCharacterConstants.EMPTY_STRING;
		this.uuid = SpecialCharacterConstants.EMPTY_STRING;
		this.timestamp = ZonedDateTime.now();

	}

	/**
	 * 
	 * @param status        of the response.
	 * @param errorResponse response of the error from the ms feign.
	 */
	public DownstreamException(int status, Map<String, String> errorResponse) {
		super(Constants.DOWN_STREAM_EXCEPTION_NAME + SpecialCharacterConstants.SPACE_STRING + status
				+ SpecialCharacterConstants.COLON + SpecialCharacterConstants.SPACE_STRING
				+ errorResponse.get(Constants.ERROR_RESPONSE_DETAILS_FIELD_NAME));
		this.status = status;
		this.type = errorResponse.get(ErrorResolverConstants.ERROR_RESPONSE_TYPE);
		this.code = errorResponse.get(ErrorResolverConstants.ERROR_RESPONSE_CODE);
		this.details = errorResponse.get(ErrorResolverConstants.ERROR_RESPONSE_DETAILS);
		this.location = errorResponse.get(ErrorResolverConstants.ERROR_RESPONSE_LOCATION);
		this.moreInfo = errorResponse.get(ErrorResolverConstants.ERROR_RESPONSE_MORE_INFORMATION);
		this.uuid = errorResponse.get(Constants.ERROR_RESPONSE_UUID_FIELD_NAME);
		String timeStamp = errorResponse.get(Constants.ERROR_RESPONSE_TIMESTAMP_FIELD_NAME);
		timeStamp = timeStamp.substring(SpecialCharacterConstants.INT_ZERO_VALUE,
				timeStamp.length() - SpecialCharacterConstants.INT_TWO_VALUE) + SpecialCharacterConstants.COLON
				+ timeStamp.substring(timeStamp.length() - SpecialCharacterConstants.INT_TWO_VALUE);
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(timeStamp);
		this.timestamp = zonedDateTime;

	}

	/**
	 * 
	 * @param status        of the response.
	 * @param errorResponse response of the error from the ms feign.
	 */
	public DownstreamException(int status, ErrorResponse errorResponse) {
		super(Constants.DOWN_STREAM_EXCEPTION_NAME + SpecialCharacterConstants.SPACE_STRING + status
				+ SpecialCharacterConstants.COLON + SpecialCharacterConstants.SPACE_STRING
				+ errorResponse.getDetails());
		this.status = status;
		this.type = errorResponse.getType();
		this.code = errorResponse.getCode();
		this.details = errorResponse.getDetails();
		this.location = errorResponse.getLocation();
		this.moreInfo = errorResponse.getMoreInfo();
		this.uuid = errorResponse.getUuid();
		this.timestamp = errorResponse.getTimestamp();
	}

}

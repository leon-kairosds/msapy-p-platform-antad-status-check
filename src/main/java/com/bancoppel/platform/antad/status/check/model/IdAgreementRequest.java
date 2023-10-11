package com.bancoppel.platform.antad.status.check.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class IdAgreementRequest {

	/**
	 * Propiedad para el numero de categoria del servicio.
	 */
	@ApiModelProperty(notes = "ID de emisor", example = "017")
	@NotNull
	@NotEmpty
	@NotBlank
	@JsonProperty("idEmisor")
	private String idEmisor;

	/**
	 * Propiedad para el numero de categoria del servicio.
	 */
	@ApiModelProperty(notes = "Numero de categoria", example = "08")
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 1, max = 2, message = Constants.LOG_BADREQUEST_CATEGORYNUMBER)
	@JsonProperty("categoryNumber")
	private String categoryNumber;
	/**
	 * Propiedad para el estatus de la categoria del servicio.
	 */
	@ApiModelProperty(notes = "Estatus", example = "A")
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 1, max = 1, message = Constants.LOG_BADREQUEST_STATUS)
	@JsonProperty("status")
	private String status;

}

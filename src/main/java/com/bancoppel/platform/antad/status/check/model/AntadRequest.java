package com.bancoppel.platform.antad.status.check.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.bancoppel.platform.antad.status.check.constant.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel(description = "Body del request modelo para llamar el servicio de autorizacion")
@Getter
@Setter
@ToString
public class AntadRequest {

	@ApiModelProperty(notes = "Nombre del usuario del servicio de antad", example = "1201usu0001")
	@NotNull
	@NotEmpty
	@NotBlank
	@JsonProperty("userName")
	private String userName;

	@ApiModelProperty(notes = "Paswword para el usuario del servicio de antad", example = "****")
	@JsonProperty("password")
	private String password;

	@ApiModelProperty(notes = "Token que se pedira en el metodo de autorizacion a antad", example = "****")
	@JsonProperty("token")
	private String token;

	@ApiModelProperty(notes = "Numero de direccion macAddress del equipo que conectara al servicio de antad", example = "88AEDD53929B")
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 12, max = 16, message = Constants.LOG_BADREQUEST_MACADDRESS)
	@JsonProperty("macAddress")
	private String macAddress;

	@ApiModelProperty(notes = "Numero de comercio", example = "1201")
	@NotNull
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "^[0-9][0-9]*$", message = Constants.LOG_BADREQUEST_NUMERIC)
	@Size(min = 0, max = 10, message = Constants.LOG_BADREQUEST_10DIG)
	@JsonProperty("comercio")
	private String comercio;

	@ApiModelProperty(notes = "Numero de sucursal", example = "01")
	@Size(min = 1, max = 4, message = Constants.LOG_BADREQUEST_SUCURSAL)
	@JsonProperty("sucursal")
	private String sucursal;

	@ApiModelProperty(notes = "Numero de caja", example = "01")
	@Size(min = 0, max = 10, message = Constants.LOG_BADREQUEST_10DIG)
	@JsonProperty("caja")
	private String caja;

	@ApiModelProperty(notes = "Numero de cajero", example = "01")
	@Size(min = 0, max = 12, message = Constants.LOG_BADREQUEST_CAJERO)
	@JsonProperty("cajero")
	private String cajero;

	@ApiModelProperty(notes = "Horario", example = "1")
	@Size(min = 0, max = 2, message = Constants.LOG_BADREQUEST_HORARIO)
	@JsonProperty("horario")
	private String horario;

	@ApiModelProperty(notes = "Tiket", example = "asd4554")
	@Size(min = 0, max = 9, message = Constants.LOG_BADREQUEST_TIKET)
	@JsonProperty("ticket")
	private String ticket;

	@ApiModelProperty(notes = "Folio del comercio", example = "123456")
	@Pattern(regexp = "^[0-9][0-9]*$", message = Constants.LOG_BADREQUEST_NUMERIC)
	@Size(min = 0, max = 12, message = Constants.LOG_BADREQUEST_FC)
	@JsonProperty("folioComercio")
	private String folioComercio;

	@ApiModelProperty(notes = "operacion del comercio", example = "000030")
	@JsonProperty("operacion")
	private String operacion;

	@ApiModelProperty(notes = "linea de captura", example = "AKLEOS547E8S7E")
	@JsonProperty("referencia")
	private String referencia;

	@ApiModelProperty(notes = "Monto del comercio", example = "0")
	@DecimalMin(value = "-1", inclusive = false, message = Constants.LOG_BADREQUEST_DECIMAL)
	@JsonProperty("monto")
	private String monto;

	@ApiModelProperty(notes = "emisor del comercio", example = "017")
	@JsonProperty("emisor")
	private String emisor;

	@ApiModelProperty(notes = "ModoIngreso del comercio (manual o codigo de barras)", example = "010")
	@JsonProperty("modoIngreso")
	private String modoIngreso;

	@ApiModelProperty(notes = "Comision en centavos", example = "0")
	@DecimalMin(value = "-1", inclusive = false, message = Constants.LOG_BADREQUEST_DECIMAL)
	@JsonProperty("comision")
	private String comision;

	// agregar valid de numeros
	@ApiModelProperty(notes = "Referencia2 para uso futuro del comercio", example = "??")
	@JsonProperty("referencia2")
	private String referencia2;

	@ApiModelProperty(notes = "Referencia3 para uso futuro del comercio", example = "??")
	@JsonProperty("referencia3")
	private String referencia3;

	@ApiModelProperty(notes = "Reintento del comercio (primera transaccion : 0 o reintento : 1)", example = "0")
	// validar numeros
	@JsonProperty("reintento")
	private String reintento;

	@ApiModelProperty(notes = "Fac fecha de aplicación contable formato : AAAAMMDD", example = "19921012")
	@JsonProperty("fac")
	private String fac;

	@ApiModelProperty(notes = "parametro que incluye consultaEstatus", example = "")
	@JsonProperty("sku")
	private String sku;

	@ApiModelProperty(notes = "parametro que incluye reverso", example = "")
	@JsonProperty("fechaContab")
	private String fechaContab;
}
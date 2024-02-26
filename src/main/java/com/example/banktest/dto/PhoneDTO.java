package com.example.banktest.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class PhoneDTO implements Serializable {

	private static final long serialVersionUID = 3221106626919993440L;

	@ApiModelProperty(name = "number", value = "Numero de telefono del usuario")
//	@NotNull(message = "number no puede ser nulo")
//	@NotEmpty(message = "number es requerido.")
	private String number;

	@ApiModelProperty(name = "citycode", value = "codigo de ciudad")
//	@NotNull(message = "citycode no puede ser nulo")
//	@NotEmpty(message = "citycode es requerido.")
	private String citycode;

	@ApiModelProperty(name = "contrycode", value = "Codigo de pais")
//	@NotNull(message = "contrycode no puede ser nulo")
//	@NotEmpty(message = "contrycode es requerido.")
	private String contrycode;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getContrycode() {
		return contrycode;
	}

	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
}

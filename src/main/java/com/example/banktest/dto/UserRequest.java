package com.example.banktest.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.banktest.validate.ValidEmailPattern;
import com.example.banktest.validate.ValidPassPattern;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author despinoza
 *
 */
public class UserRequest implements Serializable {

	private static final long serialVersionUID = 3221106626919993440L;

	@ApiModelProperty(name = "nombre", value = "Nombre del usuario")
	@NotNull(message = "nombre no puede ser nulo")
	@NotEmpty(message = "nombre es requerido.")
	private String name;

	@ApiModelProperty(name = "Email", value = "Email del usuario")
	@NotNull(message = "Email no puede ser nulo")
	@NotEmpty(message = "Email es requerido.")
	@ValidEmailPattern
	private String email;

	@ApiModelProperty(name = "Password", value = "password del usuario")
	@NotNull(message = "Password no puede ser nulo")
	@NotEmpty(message = "Password es requerido.")
	@ValidPassPattern
	private String password;

	private List<PhoneDTO> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

}

package com.example.banktest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author despinoza
 *
 */
@Component
@ConfigurationProperties(prefix = "regex")
public class RegexProperties {

	private String email;
	private String password;

	// Getters y setters para las propiedades email y password

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
}
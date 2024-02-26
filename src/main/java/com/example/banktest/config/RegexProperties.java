package com.example.banktest.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RegexProperties {

	@Value("${regex.email}")
	private String regexEmail;

	@Value("${regex.password}")
	private String regexPassword;

	@PostConstruct
	public void postConstruct() {
		System.out.println("Regex Email: " + regexEmail);
		System.out.println("Regex Password: " + regexPassword);

		validateProperties();
	}

	private void validateProperties() {
		if (regexEmail == null || regexEmail.isEmpty()) {
			throw new IllegalStateException("La propiedad 'regex.email' no está configurada correctamente.");
		}

		if (regexPassword == null || regexPassword.isEmpty()) {
			throw new IllegalStateException("La propiedad 'regex.password' no está configurada correctamente.");
		}
	}

	public String getRegexEmail() {
		return regexEmail;
	}

	public String getRegexPassword() {
		return regexPassword;
	}
}
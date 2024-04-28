package com.example.banktest.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author despinoza
 */

@Component
public class EmailPatternValidator implements ConstraintValidator<ValidEmailPattern, String> {

	@Value("${regex.email}")
	private String emailRegex;

	public EmailPatternValidator(@Value("${regex.email}") String emailRegex) {
		this.emailRegex = emailRegex;
	}

	@Override
	public void initialize(ValidEmailPattern constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Aquí aplicas la lógica de validación utilizando el patrón leído desde el
		// archivo de propiedades
		return value != null && value.matches(emailRegex);
	}
}
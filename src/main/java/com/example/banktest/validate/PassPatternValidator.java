package com.example.banktest.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author despinoza
 */

@Component
public class PassPatternValidator implements ConstraintValidator<ValidPassPattern, String> {

	@Value("${regex.password}")
	private String regexPassword;

	@Override
	public void initialize(ValidPassPattern constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// Aquí aplicas la lógica de validación utilizando el patrón leído desde el
		// archivo de propiedades
		return value != null && value.matches(regexPassword);
	}
}
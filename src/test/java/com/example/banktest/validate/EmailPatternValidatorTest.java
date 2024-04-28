package com.example.banktest.validate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailPatternValidatorTest {

	
	private final EmailPatternValidator emailPatternValidator = new EmailPatternValidator(
			"[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");

	@Test
	void testValidEmail() {
		assertTrue(emailPatternValidator.isValid("test@example.com", null));
	}
}
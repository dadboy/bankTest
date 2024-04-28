package com.example.banktest.exception;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author despinoza
 *
 */

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

	/**
	 * Método que recoge exceptions de las anotaciones de hibernate
	 *
	 * @param ex
	 * @return ResponseEntity
	 */
	@Override
	@NonNull
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			@NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
		final var errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			final var fieldName = ((FieldError) error).getField();
			final var message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		HttpHeaders headersResponse = setStandarHeaders();

		return new ResponseEntity<>(errors, headersResponse, HttpStatus.BAD_REQUEST);
	}

	private HttpHeaders setStandarHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Credentials", "true");
		headers.add("Access-Control-Allow-Methods", "*");
		headers.add("Access-Control-Max-Age", "3600");
		headers.add("Access-Control-Allow-Headers", "*");
		headers.add("Access-Control-Expose-Headers", "*");
		headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
		return headers;
	}
}

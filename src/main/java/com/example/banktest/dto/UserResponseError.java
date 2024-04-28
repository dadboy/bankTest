package com.example.banktest.dto;

/**
 *
 * @author despinoza
 *
 */
public class UserResponseError {

	private String errorMessage;

	public UserResponseError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}

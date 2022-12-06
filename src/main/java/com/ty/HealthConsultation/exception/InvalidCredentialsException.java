package com.ty.HealthConsultation.exception;

public class InvalidCredentialsException extends RuntimeException{
	String message="Given Credentials are invalid";

	@Override
	public String getMessage() {
		return message;
	}

	public InvalidCredentialsException(String message) {
		this.message = message;
	}

}

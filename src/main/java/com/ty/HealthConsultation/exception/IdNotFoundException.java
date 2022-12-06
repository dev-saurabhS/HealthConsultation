package com.ty.HealthConsultation.exception;

public class IdNotFoundException extends RuntimeException {
	private String message = "Id Not Found";

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {

		return message;
	}
}

package com.hexaware.exception;

public class AppointmentIdException {
private static final long serialVersionUID = 1L;
	
	private String message;

	public AppointmentIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	

}
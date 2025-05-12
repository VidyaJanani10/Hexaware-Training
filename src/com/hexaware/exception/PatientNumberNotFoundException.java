package com.hexaware.exception;

@SuppressWarnings("serial")
public class PatientNumberNotFoundException extends RuntimeException {
    public PatientNumberNotFoundException(String message) {
        super(message);
    }
}

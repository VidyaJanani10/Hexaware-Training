package com.hexaware.exception;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L; // Serializable ID

    public UserNotFoundException(String message) {
        super(message);
    }
}
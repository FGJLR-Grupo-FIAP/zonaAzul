package com.tech.challenge.zonaAzul.util.exception;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(String message, Exception e) {
        super(message + e.getMessage());
    }
}

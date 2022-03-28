package com.epam.conference.exception;

public class DatabaseConnectorException extends Exception {

    public DatabaseConnectorException(String message, Exception exception) {
        super(message, exception);
    }
}

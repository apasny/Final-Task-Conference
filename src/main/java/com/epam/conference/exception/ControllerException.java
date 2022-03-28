package com.epam.conference.exception;

public class ControllerException extends Exception {

    public ControllerException(String message, Exception exception) {
        super(message, exception);
    }
}

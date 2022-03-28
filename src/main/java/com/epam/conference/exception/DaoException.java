package com.epam.conference.exception;


public class DaoException extends Exception {

    public DaoException(String message, Exception exception) {
        super(message, exception);
    }
}

package com.epam.conference.exception;


public class CommandException extends Exception {

    public CommandException(String message, Exception exception) {
        super(message, exception);
    }



}

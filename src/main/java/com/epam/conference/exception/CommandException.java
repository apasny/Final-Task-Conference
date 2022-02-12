package com.epam.conference.exception;


public class CommandException extends Exception {

    public CommandException(Exception exception) {
        super(exception);
    }



}

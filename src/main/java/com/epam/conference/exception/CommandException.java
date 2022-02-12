package com.epam.conference.exception;

import java.sql.SQLException;

public class CommandException extends SQLException {

    public CommandException(SQLException exception) {
        super(exception);
    }

}

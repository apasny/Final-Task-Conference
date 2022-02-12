package com.epam.conference.exception;

import java.sql.SQLException;

public class ServiceException extends SQLException {

    public ServiceException(SQLException exception) {
    }
}

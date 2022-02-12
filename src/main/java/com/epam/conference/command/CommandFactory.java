package com.epam.conference.command;

import com.epam.conference.connection.DatabaseConnector;
import com.epam.conference.dao.UserDao;
import com.epam.conference.dao.UserDaoImpl;
import com.epam.conference.exception.CommandException;
import com.epam.conference.service.UserService;
import com.epam.conference.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class CommandFactory {

    public Command createCommand(String command) throws CommandException {

        UserDao userDao;
        UserService userService;
        Connection connection;

        try {
            connection = DatabaseConnector.getConnection();
        } catch (SQLException e) {
            throw new CommandException(e);
        }

        userDao = new UserDaoImpl(connection);
        userService = new UserServiceImpl(userDao);

        switch (command) {
            case "login":
                return new LoginCommand(userService);
            case "apply":
                return new ApplyCommand();
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}

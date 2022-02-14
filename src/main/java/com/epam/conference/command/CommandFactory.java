package com.epam.conference.command;

import com.epam.conference.dao.DaoHelper;
import com.epam.conference.dao.DaoHelperFactory;
import com.epam.conference.dao.UserDao;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.service.UserService;
import com.epam.conference.service.UserServiceImpl;

import java.sql.SQLException;

public class CommandFactory {

    public Command createCommand(String command) throws CommandException {

        DaoHelperFactory daoHelperFactory;
        DaoHelper daoHelper;

        try {
            daoHelperFactory = new DaoHelperFactory();
            daoHelper = daoHelperFactory.create();
        } catch (DatabaseConnectorException | SQLException e) {
            throw new CommandException("Unable to create command " + e.getMessage(),e);
        }

        UserDao userDao = daoHelper.createUserDao();
        UserService userService = new UserServiceImpl(userDao);

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

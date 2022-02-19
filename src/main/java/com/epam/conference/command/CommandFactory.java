package com.epam.conference.command;

import com.epam.conference.dao.ConferenceDao;
import com.epam.conference.dao.DaoHelper;
import com.epam.conference.dao.DaoHelperFactory;
import com.epam.conference.dao.UserDao;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.service.ConferenceService;
import com.epam.conference.service.ConferenceServiceImpl;
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

        switch (command) {
            case "login":
                UserDao userDao = daoHelper.createUserDao();
                UserService userService = new UserServiceImpl(userDao);
                return new LoginCommand(userService);
            case "apply":
                return new ApplyCommand();
            case "cancel":
                return new CancelCommand();
            case "decline":
                return new DeclineCommand();
            case "create":
                ConferenceDao conferenceDao = daoHelper.createConferenceDao();
                ConferenceService conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new CreateCommand(conferenceService);
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}

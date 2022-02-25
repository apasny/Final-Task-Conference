package com.epam.conference.command;

import com.epam.conference.dao.*;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ControllerException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class CommandFactory {

    public Command createCommand(String command) throws CommandException {

        DaoHelperFactory daoHelperFactory;
        DaoHelper daoHelper;
        UserDao userDao;
        UserService userService;
        ConferenceDao conferenceDao;
        ConferenceService conferenceService;
        RequestDao requestDao;
        RequestService requestService;


        try {
            daoHelperFactory = new DaoHelperFactory();
            daoHelper = daoHelperFactory.create();
        } catch (DatabaseConnectorException | SQLException e) {
            throw new CommandException("Unable to create command " + e.getMessage(), e);
        }

        switch (command) {
            case "login":
                userDao = daoHelper.createUserDao();
                userService = new UserServiceImpl(userDao);
                return new LoginCommand(userService);
            case "apply":
                return new ApplyCommand();
            case "cancel":
                return new CancelCommand();
            case "decline":
                return new DeclineCommand();
            case "create":
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new CreateCommand(conferenceService);
            case "/conferences":
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new ConferencesCommand(conferenceService);
            case "/requests":
                requestDao = daoHelper.createRequestDao();
                requestService = new RequestServiceImpl(requestDao);
                return new RequestsCommand(requestService);
            case "/logout":
                return new LogoutCommand();
//            case "/create-conference":
////                userPath = "/create-conference";
//                break;
//            case "/create-section":
////                userPath = "/create-section";
//                break;
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}

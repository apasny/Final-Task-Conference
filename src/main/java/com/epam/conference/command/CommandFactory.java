package com.epam.conference.command;

import com.epam.conference.dao.*;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.service.*;

import java.sql.SQLException;

public class CommandFactory {

    private static final String LOGIN = "login";
    private static final String APPLY = "apply";
    private static final String CANCEL = "cancel";
    private static final String DECLINE = "decline";
    private static final String CREATE_CONFERENCE = "create-conference";
    private static final String DELETE = "delete";

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
            case LOGIN:
                userDao = daoHelper.createUserDao();
                userService = new UserServiceImpl(userDao);
                return new LoginCommand(userService);
            case APPLY:
                return new ApplyCommand();
            case CANCEL:
                return new CancelCommand();
            case DECLINE:
                return new DeclineCommand();
            case CREATE_CONFERENCE:
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new CreateConferenceCommand(conferenceService);
            case DELETE:
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new DeleteCommand(conferenceService);
            case "conferences":
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new ConferencesCommand(conferenceService);
            case "requests":
                requestDao = daoHelper.createRequestDao();
                requestService = new RequestServiceImpl(requestDao);
                return new RequestsCommand(requestService);
            case "logout":
                return new LogoutCommand();
            case "conference-creation":
                return new CreateConferencePage();
            case "section-creation":
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new CreateSectionPage(conferenceService);
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}

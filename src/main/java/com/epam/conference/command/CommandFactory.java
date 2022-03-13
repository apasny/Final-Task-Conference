package com.epam.conference.command;

import com.epam.conference.dao.*;
import com.epam.conference.entity.Section;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.service.*;

import java.sql.SQLException;

public class CommandFactory {

    private static final String LOGIN = "login";
    private static final String APPLY = "apply";
    private static final String CANCEL = "cancel";
    private static final String DECLINE = "decline";
    private static final String CREATE_CONFERENCE = "create-conference";
    private static final String CREATE_SECTION = "create-section";
    private static final String DELETE = "delete";
    private static final String CONFERENCES = "conferences";
    private static final String SECTIONS = "sections";
    private static final String REQUESTS = "requests";
    private static final String LOGOUT = "logout";
    private static final String CONFERENCE_CREATION = "conference-creation";
    private static final String SECTION_CREATION = "section-creation";

    public Command createCommand(String command) throws CommandException {

        DaoHelperFactory daoHelperFactory;
        DaoHelper daoHelper;
        UserDao userDao;
        UserService userService;
        ConferenceDao conferenceDao;
        ConferenceService conferenceService;
        RequestDao requestDao;
        RequestService requestService;
        SectionDao sectionDao;
        SectionService sectionService;

        try {
            daoHelperFactory = new DaoHelperFactory();
            daoHelper = daoHelperFactory.create();
        } catch (DatabaseConnectorException | SQLException | DaoException e) {
            throw new CommandException("Unable to create command " + e.getMessage(), e);
        }

        switch (command) {
            case LOGIN:
                userDao = daoHelper.createUserDao();
                userService = new UserServiceImpl(userDao);
                return new LoginCommand(userService);
            case APPLY:
                requestDao = daoHelper.createRequestDao();
                requestService = new RequestServiceImpl(requestDao);
                return new ApplyCommand(requestService);
            case CANCEL:
                return new CancelCommand();
            case DECLINE:
                return new DeclineCommand();
            case CREATE_CONFERENCE:
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new CreateConferenceCommand(conferenceService);
            case CREATE_SECTION:
                sectionDao = daoHelper.createSectionDao();
                sectionService = new SectionServiceImpl(sectionDao);
                return new CreateSectionCommand(sectionService);
            case DELETE:
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new DeleteCommand(conferenceService);
            case CONFERENCES:
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new ConferencesCommand(conferenceService);
            case SECTIONS:
                sectionDao = daoHelper.createSectionDao();
                sectionService = new SectionServiceImpl(sectionDao);
                return new SectionsCommand(sectionService);
            case REQUESTS:
                requestDao = daoHelper.createRequestDao();
                requestService = new RequestServiceImpl(requestDao);
                return new RequestsCommand(requestService);
            case LOGOUT:
                return new LogoutCommand();
            case CONFERENCE_CREATION:
                return new CreateConferencePage();
            case SECTION_CREATION:
                conferenceDao = daoHelper.createConferenceDao();
                conferenceService = new ConferenceServiceImpl(conferenceDao);
                return new CreateSectionPage(conferenceService);
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}

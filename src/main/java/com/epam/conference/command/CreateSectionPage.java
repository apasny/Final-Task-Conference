package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class CreateSectionPage implements Command {

    private final ConferenceService conferenceService;

    public CreateSectionPage(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        ArrayList<Conference> conferences;

        try {
            conferences = (ArrayList<Conference>) conferenceService.conferences();
        } catch (ServiceException e) {
            throw new CommandException("Unable to execute create section command" + e.getMessage(), e);
        }

        try {
            conferenceService.close();
        } catch (ServiceException e) {
            throw new CommandException("Unable to close conference service connection", e);
        }

        for (Conference conference : conferences) {
            Long id = conference.getId();
            String topic = conference.getTopic();
            req.setAttribute("conferenceId", id);
            req.setAttribute("topic", topic);
        }
        req.setAttribute("conferences", conferences);

        return "WEB-INF/view/create-section.jsp";
    }
}

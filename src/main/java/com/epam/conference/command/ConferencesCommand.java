package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class ConferencesCommand implements Command {

    private final ConferenceService conferenceService;

    public ConferencesCommand(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        ArrayList<Conference> conferences;

        try {
            conferences = (ArrayList<Conference>) conferenceService.conferences();
        } catch (ServiceException e) {
            throw new CommandException("Unable to execute requests command" + e.getMessage(), e);
        }
        for (Conference conference : conferences) {
            Long id = conference.getId();
            String topic = conference.getTopic();
            Date date = conference.getStartDate();
            String place = conference.getPlace();
            req.setAttribute("conferenceId", id);
            req.setAttribute("topic", topic);
            req.setAttribute("startDate", date);
            req.setAttribute("place", place);
        }
        req.setAttribute("conferences", conferences);

        return "/conferences";
    }
}

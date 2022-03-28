package com.epam.conference.command;

import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command {

    private final ConferenceService conferenceService;

    public DeleteCommand(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        Long id = Long.parseLong(req.getParameter("id"));

        try {
            conferenceService.delete(id);
        } catch (ServiceException e) {
            throw new CommandException("Unable to execute delete command",e);
        }

        return "conferences";
    }
}

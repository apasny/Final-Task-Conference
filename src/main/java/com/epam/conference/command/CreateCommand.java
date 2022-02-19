package com.epam.conference.command;

import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DaoException;
import com.epam.conference.service.ConferenceService;
import com.epam.conference.service.ConferenceServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CreateCommand implements Command {

    private final ConferenceService conferenceService;

    public CreateCommand(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        String topic = req.getParameter("topic");
        String startDate = req.getParameter("start-date");
        String endDate = req.getParameter("end-date");
        String place = req.getParameter("place");


        try {
            conferenceService.create(topic,startDate,endDate,place);
        } catch (DaoException e) {
            throw new CommandException("Unable to create ",e);
        }

        return "WEB-INF/view/404.jsp";
    }
}

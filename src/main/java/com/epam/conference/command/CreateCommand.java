package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DaoException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class CreateCommand implements Command {

    private final ConferenceService conferenceService;

    public CreateCommand(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        Long id = Long.parseLong(req.getParameter("id"));
        String topic = req.getParameter("topic");
        Date startDate = Date.valueOf(req.getParameter("start-date"));
        Date endDate = Date.valueOf(req.getParameter("end-date"));
        String place = req.getParameter("place");

        try {
            conferenceService.create(new Conference(id,topic,startDate,endDate,place,true));
        } catch (DaoException e) {
            throw new CommandException("Unable to create ",e);
        }

        return "WEB-INF/view/404.jsp";
    }
}

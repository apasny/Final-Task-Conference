package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DaoException;
import com.epam.conference.service.ConferenceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class CreateConferenceCommand implements Command {

    private final ConferenceService conferenceService;

    public CreateConferenceCommand(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        String topic = req.getParameter("topic");
        Date startDate = Date.valueOf(req.getParameter("start-date"));
        Date endDate = Date.valueOf(req.getParameter("end-date"));
        String place = req.getParameter("place");

        try {
            conferenceService.create(new Conference(null,topic,startDate,endDate,place,true,false));
        } catch (DaoException e) {
            throw new CommandException("Unable to create ",e);
        }

        return "WEB-INF/view/404.jsp";
    }
}

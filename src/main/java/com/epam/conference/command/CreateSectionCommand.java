package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DaoException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class CreateSectionCommand implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        Long id = Long.parseLong(req.getParameter("id"));
        String topic = req.getParameter("topic");
        Date startTime = Date.valueOf(req.getParameter("start-time"));
        Date endTime = Date.valueOf(req.getParameter("end-time"));
        int maxAttendees = Integer.parseInt(req.getParameter("max-attendees"));

//        try {
//            sectionService.create(new Conference(null,topic,startDate,endDate,place,true,false));
//        } catch (DaoException e) {
//            throw new CommandException("Unable to create ",e);
//        }

        return "WEB-INF/view/404.jsp";
    }
}

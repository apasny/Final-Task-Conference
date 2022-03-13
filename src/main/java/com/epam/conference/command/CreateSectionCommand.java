package com.epam.conference.command;

import com.epam.conference.entity.Section;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;

public class CreateSectionCommand implements Command{

    private final SectionService sectionService;

    public CreateSectionCommand(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        Long conferenceId = Long.parseLong(req.getParameter("conference-id"));
        String topic = req.getParameter("topic");
        String st = req.getParameter("start-time");
        Time startTime = Time.valueOf(st.concat(":00"));
        String et = req.getParameter("end-time");
        Time endTime = Time.valueOf(et.concat(":00"));
        int maxAttendees = Integer.parseInt(req.getParameter("max-attendees"));

        try {
            sectionService.create(new Section(null,topic,startTime,endTime,maxAttendees,true,false, conferenceId));
        } catch (ServiceException e) {
            throw new CommandException("Unable to create ",e);
        }

        try {
            sectionService.close();
        } catch (ServiceException e) {
            throw new CommandException("Unable to close conference service", e);
        }

        return "WEB-INF/view/create-section.jsp";
    }
}

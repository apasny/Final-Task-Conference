package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.entity.Section;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

public class SectionsCommand implements Command {

    private final SectionService sectionService;

    public SectionsCommand(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        ArrayList<Section> sections;
        String conferenceId = req.getParameter("id");

        try {
            sections = (ArrayList<Section>) sectionService.sections(conferenceId);
        } catch (ServiceException e) {
            throw new CommandException("Unable to execute requests command" + e.getMessage(), e);
        }

        try {
            sectionService.close();
        } catch (ServiceException e) {
            throw new CommandException("Unable to close section service connection", e);
        }

        for (Section section : sections) {
            Long id = section.getId();
            String topic = section.getTopic();
            req.setAttribute("sectionId", id);
            req.setAttribute("topic", topic);
        }
        req.setAttribute("sections", sections);

        return "WEB-INF/view/sections.jsp";
    }
}

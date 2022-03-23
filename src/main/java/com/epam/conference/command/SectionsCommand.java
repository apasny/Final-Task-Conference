package com.epam.conference.command;

import com.epam.conference.entity.Section;
import com.epam.conference.entity.User;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.SectionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SectionsCommand implements Command {

    private final SectionService sectionService;

    public SectionsCommand(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        ArrayList<Section> sections;
        String conferenceId = req.getParameter("id");
        User user = (User) req.getSession().getAttribute("user");
        String userId = user.getId().toString();

        if(user.getIsAdmin()){
            try {
                sections = (ArrayList<Section>) sectionService.allSections(conferenceId);
            } catch (ServiceException e) {
                throw new CommandException("Unable to execute requests command" + e.getMessage(), e);
            }
        } else {
            try {
                sections = (ArrayList<Section>) sectionService.notAppliedSections(userId,conferenceId);
            } catch (ServiceException e) {
                throw new CommandException("Unable to execute requests command" + e.getMessage(), e);
            }
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

        return "sections";
    }
}

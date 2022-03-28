package com.epam.conference.command;

import com.epam.conference.entity.Conference;
import com.epam.conference.entity.Request;
import com.epam.conference.entity.User;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplyCommand implements Command {

    private final RequestService requestService;

    public ApplyCommand(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {


        Long sectionId = Long.parseLong(req.getParameter("section-id"));
        User user = (User)req.getSession().getAttribute("user");
        Long userId = user.getId();

        try {
            requestService.apply(new Request(null, userId,sectionId,"pending"));
        } catch (ServiceException e) {
            throw new CommandException("Unable to create ",e);
        }

        try {
            requestService.close();
        } catch (ServiceException e) {
            throw new CommandException("Unable to close conference service connection", e);
        }

        return "WEB-INF/view/requests.jsp";

    }
}

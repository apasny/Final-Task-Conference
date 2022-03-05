package com.epam.conference.command;

import com.epam.conference.entity.Request;
import com.epam.conference.entity.User;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RequestsCommand implements Command{

    private final RequestService requestService;

    public RequestsCommand(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        ArrayList<Request> usersRequests;

        User user = (User)req.getSession().getAttribute("user");
        String userId = user.getId().toString();
        boolean role = user.getIsAdmin();

        if (role){
            try {
                usersRequests = (ArrayList<Request>) requestService.allRequests();
            } catch (ServiceException e) {
                throw new CommandException("Unable to execute requests command" + e.getMessage(), e);
            }
        } else {
            try {
                usersRequests = (ArrayList<Request>) requestService.userRequests(userId);
            } catch (ServiceException e) {
                throw new CommandException("Unable to execute User requests command" + e.getMessage(), e);
            }
        }

        for (Request request : usersRequests) {
            Long id = request.getId();
            String topic=request.getTopic();
            req.setAttribute("conferenceId",id);
            req.setAttribute("topic",topic);
        }
        req.setAttribute("usersRequests", usersRequests);

        return "/requests";
    }
}

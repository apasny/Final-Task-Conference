package com.epam.conference.command;

import com.epam.conference.entity.*;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.DtoService;
import com.epam.conference.service.RequestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RequestsCommand implements Command{

    private final DtoService dtoService;

    public RequestsCommand(DtoService dtoService) {
        this.dtoService = dtoService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        ArrayList<Dto> dtos;

        User user = (User)req.getSession().getAttribute("user");
        String userId = user.getId().toString();
        boolean role = user.getIsAdmin();

        if (role){
            try {
                dtos = (ArrayList<Dto>) dtoService.allRequests();
            } catch (ServiceException e) {
                throw new CommandException("Unable to execute requests command" + e.getMessage(), e);
            }
        } else {
            try {
                dtos = (ArrayList<Dto>) dtoService.userRequests(userId);
            } catch (ServiceException e) {
                throw new CommandException("Unable to execute User requests command" + e.getMessage(), e);
            }
        }

        try {
            dtoService.close();
        } catch (ServiceException e) {
            throw new CommandException("Unable to close request service connection", e);
        }

        for (Dto dto : dtos) {
            User userDto = dto.getUser();
            Request requestDto = dto.getRequest();
            Section sectionDto = dto.getSection();
            Conference conferenceDto = dto.getConference();
            req.setAttribute("userDto",userDto);
            req.setAttribute("requestDto",requestDto);
            req.setAttribute("sectionDto",sectionDto);
            req.setAttribute("conferenceDto",conferenceDto);
        }
        req.setAttribute("dtos", dtos);

        return "requests";
    }
}

package com.epam.conference.command;

import com.epam.conference.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateConferencePage implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        return "WEB-INF/view/create-conference.jsp";
    }
}

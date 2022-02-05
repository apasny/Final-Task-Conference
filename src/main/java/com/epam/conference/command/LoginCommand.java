package com.epam.conference.command;

import com.epam.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userService.login(login, password)){
            return "WEB-INF/view/main.jsp";
        } else {
            return "index.jsp";
        }
    }
}

package com.epam.conference.command;

import com.epam.conference.entity.User;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> user;
        try {
            user = userService.login(login, password);
        } catch (ServiceException e) {
            throw new CommandException("Unable to execute login command" + e.getMessage(), e);
        }

        try {
            userService.close();
        } catch (ServiceException e) {
            throw new CommandException("Unable to close user service connection", e);
        }

        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            req.getSession().setAttribute("language", req.getLocale().getLanguage());
            if (user.get().getIsAdmin()) {
                return "requests";
            } else {
                return "conferences";
            }
        } else {
            return "index.jsp";
        }
    }
}

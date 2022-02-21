package com.epam.conference.command;

import com.epam.conference.connection.ConnectionPool;
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
        if (user.isPresent()) {
            req.getSession().setAttribute("user_id", user.get().getId());
            req.getSession().setAttribute("role", user.get().isAdmin());
            if (user.get().isAdmin()) {
                return "WEB-INF/view/requests.jsp";
            } else {
                return "WEB-INF/view/conferences.jsp";
            }
        } else {
            return "index.jsp";
        }
    }
}

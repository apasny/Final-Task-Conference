package com.epam.conference.command;

import com.epam.conference.entity.User;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command{

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
            throw new CommandException("Unable to execute login command" + e.getMessage(),e);
        }
        if (user.isPresent()){
            req.getSession().setAttribute("id",user.get().getId());
            req.getSession().setAttribute("isAdmin",user.get().isAdmin());
            return "WEB-INF/view/main.jsp";
        } else {
            return "index.jsp";
        }
    }
}

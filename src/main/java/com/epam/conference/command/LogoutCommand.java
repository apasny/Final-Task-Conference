package com.epam.conference.command;

import com.epam.conference.dao.DaoHelper;
import com.epam.conference.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class LogoutCommand implements Command {

    private final DaoHelper daoHelper;

    public LogoutCommand(DaoHelper daoHelper) {
        this.daoHelper=daoHelper;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        try {
            daoHelper.close();
        } catch (SQLException e) {
            throw new CommandException("Unable to close logout connection" + e.getMessage(), e);
        }
        return "index.jsp";
    }
}

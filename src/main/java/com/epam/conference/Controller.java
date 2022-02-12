package com.epam.conference;

import com.epam.conference.command.Command;
import com.epam.conference.command.CommandFactory;
import com.epam.conference.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, CommandException {

        String commandLine = req.getParameter("command");

        CommandFactory commandFactory = new CommandFactory();

        String page;

        Command command = commandFactory.createCommand(commandLine);

        if (command != null) {
            page = command.execute(req, resp);
        } else {
            throw new NullPointerException("No command created");
        }

        req.getRequestDispatcher(page).forward(req, resp);
    }
}

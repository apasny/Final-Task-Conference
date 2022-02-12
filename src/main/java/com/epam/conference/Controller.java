package com.epam.conference;

import com.epam.conference.command.Command;
import com.epam.conference.command.CommandFactory;
import com.epam.conference.exception.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandLine = req.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();

        Command command = null;
        try {
            command = commandFactory.createCommand(commandLine);
        } catch (CommandException e) {
            e.printStackTrace();
        }

        String page = null;
        try {
            if (command != null) {
                page = command.execute(req, resp);
            }
        } catch (CommandException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher(page).forward(req, resp);
    }
}

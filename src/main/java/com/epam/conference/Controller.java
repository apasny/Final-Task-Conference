package com.epam.conference;

import com.epam.conference.command.Command;
import com.epam.conference.command.CommandFactory;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ControllerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            process(req, resp);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ControllerException {

        String commandLine = req.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();

        Command command;
        try {
            command = commandFactory.createCommand(commandLine);
        } catch (CommandException e) {
            throw new ControllerException("Unable to execute " + this.getClass() + ".process() " + e.getMessage(), e);
        }

        String page;
        try {
            page = command.execute(req, resp);
        } catch (CommandException e) {
            throw new ControllerException("Unable to execute " + this.getClass() + ".process() " + e.getMessage(), e);
        }

        req.getRequestDispatcher(page).forward(req, resp);
    }

}





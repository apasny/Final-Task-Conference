package com.epam.conference;

import com.epam.conference.command.Command;
import com.epam.conference.command.CommandFactory;
import com.epam.conference.dao.DaoHelper;
import com.epam.conference.dao.DaoHelperFactory;
import com.epam.conference.dao.RequestDao;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.CommandException;
import com.epam.conference.exception.ControllerException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.exception.ServiceException;
import com.epam.conference.service.RequestService;
import com.epam.conference.service.RequestServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processGetRequest(req, resp);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processPostRequest(req, resp);
        } catch (ControllerException e) {
            e.printStackTrace();
        }
    }

    private void processPostRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ControllerException {

        String commandLine = req.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();

        Command command;
        try {
            command = commandFactory.createCommand(commandLine);
        } catch (CommandException e) {
            throw new ControllerException("Unable to execute " + this.getClass() + ".processPostRequest() " + e.getMessage(), e);
        }

        String page;
        try {
            page = command.execute(req, resp);
        } catch (CommandException e) {
            throw new ControllerException("Unable to execute " + this.getClass() + ".processPostRequest() " + e.getMessage(), e);
        }

        req.getRequestDispatcher(page).forward(req, resp);
    }


    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ControllerException {

        String userPath = req.getServletPath();
        CommandFactory commandFactory = new CommandFactory();

        Command command;
        try {
            command = commandFactory.createCommand(userPath);
        } catch (CommandException e) {
            throw new ControllerException("Unable to execute " + this.getClass() + ".processGetRequest() " + e.getMessage(), e);
        }

        String responsePath;
        try {
            responsePath = command.execute(req, resp);
        } catch (CommandException e) {
            throw new ControllerException("Unable to execute " + this.getClass() + ".processGetRequest() " + e.getMessage(), e);
        }

        String url = "/WEB-INF/view" + responsePath + ".jsp";

        req.getRequestDispatcher(url).forward(req, resp);
    }

}





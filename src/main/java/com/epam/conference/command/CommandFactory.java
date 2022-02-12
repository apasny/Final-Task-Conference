package com.epam.conference.command;

import com.epam.conference.connection.DatabaseConnector;
import com.epam.conference.dao.UserDao;
import com.epam.conference.dao.UserDaoImpl;
import com.epam.conference.service.UserService;
import com.epam.conference.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class CommandFactory {


    public Command createCommand(String command) {

        UserDao userDao;
        UserService userService;
        Connection connection;

//        try {
            connection = DatabaseConnector.getConnection();
//        } catch (SQLException e) {
//            throw new NullPointerException("connection error");
//        }

        if (connection == null) throw new NullPointerException("connection is null");

        try{
            userDao = new UserDaoImpl(connection);
        } catch (Exception e) {
            throw new NullPointerException("UserDaoImpl error");
        }

        try{
            userService = new UserServiceImpl(userDao);
        } catch (Exception e) {
            throw new NullPointerException("UserServiceImpl error");
        }

        switch (command) {
            case "login":
                try{
                    return new LoginCommand(userService);
                } catch (Exception e) {
                    throw new NullPointerException("LoginCommand error");
                }
            case "apply":
                return new ApplyCommand();
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}

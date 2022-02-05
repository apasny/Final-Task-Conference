package com.epam.conference.command;

import com.epam.conference.service.UserServiceImpl;

public class CommandFactory {

    public Command createCommand(String command) {
        switch (command){
            case "login":
                return new LoginCommand(new UserServiceImpl());
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }

}

package com.epam.conference.command;

import com.epam.conference.exception.CommandException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class CommandFactoryTest {

    @Test
    public void createCommand() {

        CommandFactory commandFactory = new CommandFactory();
        Command command;

        command = commandFactory.createCommand("login");

        if (command != null) {
            Assert.assertEquals(command.getClass(), LoginCommand.class);
        } else {
            throw new NullPointerException("Command is not created");
        }
    }
}
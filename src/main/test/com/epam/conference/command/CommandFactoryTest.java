package com.epam.conference.command;

import com.epam.conference.exception.CommandException;
import org.junit.Assert;
import org.junit.Test;

public class CommandFactoryTest {

    @Test
    public void createCommand() throws CommandException {

        CommandFactory commandFactory = new CommandFactory();

        Command command = commandFactory.createCommand("login");

        Assert.assertEquals(command.getClass(), LoginCommand.class);

    }
}
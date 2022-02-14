package com.epam.conference.dao;

import com.epam.conference.entity.User;
import com.epam.conference.exception.DaoException;

import java.util.Optional;

public interface UserDao {

    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

}

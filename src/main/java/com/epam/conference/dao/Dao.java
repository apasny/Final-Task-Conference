package com.epam.conference.dao;

import com.epam.conference.exception.DaoException;

public interface Dao<T> {

    boolean create(T item) throws DaoException;
    void update() throws DaoException;
    void delete() throws DaoException;
    void closeConnection() throws DaoException;

}

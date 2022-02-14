package com.epam.conference.dao;

import com.epam.conference.exception.DaoException;

public interface Dao {

    void create() throws DaoException;
    void update() throws DaoException;
    void delete() throws DaoException;

}

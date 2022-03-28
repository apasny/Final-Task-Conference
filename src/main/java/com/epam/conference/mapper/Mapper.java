package com.epam.conference.mapper;

import com.epam.conference.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

    T map(ResultSet resultSet) throws SQLException;

}

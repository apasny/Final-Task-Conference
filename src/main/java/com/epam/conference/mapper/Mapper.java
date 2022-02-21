package com.epam.conference.mapper;

import com.epam.conference.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

    T map(ResultSet resultSet) throws SQLException;

    static Mapper<? extends Identifiable> createTable(String table) {
        switch (table) {
            case User.TABLE:
                return new UserMapper();
            case Section.TABLE:
                return new SectionMapper();
            case Conference.TABLE:
                return new ConferenceMapper();
            case Request.TABLE:
                return new RequestMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }

}

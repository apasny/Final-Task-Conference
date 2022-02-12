package com.epam.conference.mapper;

import com.epam.conference.entity.Section;
import com.epam.conference.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {

    T map(ResultSet resultSet) throws SQLException;

    static Mapper<?> createTable(String table) {
        switch (table) {
            case User.TABLE:
                return new UserMapper();
            case Section.TABLE:
                return new SectionMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }

}

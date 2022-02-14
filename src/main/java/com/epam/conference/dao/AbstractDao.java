package com.epam.conference.dao;

import com.epam.conference.entity.Identifiable;
import com.epam.conference.exception.DaoException;
import com.epam.conference.mapper.Mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identifiable> implements Dao {

    private final Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    protected List<T> executeQuery(String query, Mapper<T> mapper, Object... params) throws DaoException {
        try (PreparedStatement preparedStatement = createStatement(query, params);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<T> entities = new ArrayList<>();
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
            return entities;
        } catch (SQLException e) {
            throw new DaoException("Unable to execute query where SQLState: " +
                    e.getSQLState() + "; Error code: " +
                    e.getErrorCode(), e);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                preparedStatement.setObject(i, params[i - 1]);
            }
        } catch (SQLException e) {
            throw new DaoException("Unable to prepare statement " +
                    e.getSQLState() +
                    e.getErrorCode(), e);
        }
        return preparedStatement;
    }

    public List<T> getAll() throws DaoException {
        String table = getTableName();
        Mapper<T> mapper = (Mapper<T>) Mapper.createTable(table);
        return executeQuery("select * from " + table, mapper);
    }

    protected Optional<T> executeForSingleResult(String query, Mapper<T> mapper, Object... params) throws DaoException {
        List<T> items = executeQuery(query, mapper, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one item found");
        } else {
            return Optional.empty();
        }

    }

    protected abstract String getTableName();

}

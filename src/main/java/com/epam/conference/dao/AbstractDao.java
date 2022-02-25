package com.epam.conference.dao;

import com.epam.conference.connection.ConnectionPool;
import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Identifiable;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.mapper.Mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class AbstractDao<T extends Identifiable> implements Dao<T> {

    private final ProxyConnection proxyConnection;
    private final Mapper<T> mapper;

    public AbstractDao(ProxyConnection proxyConnection, Mapper<T> mapper) {
        this.proxyConnection = proxyConnection;
        this.mapper = mapper;
    }

    @Override
    public boolean create(T item) throws DaoException {
        Map<String, Object> fields = getFields(item);
        String query = item.getId() == null ? generateInsertQuery(fields) : generateUpdateQuery(fields);
        return executeUpdate(query);
    }

    @Override
    public void update() throws DaoException {

    }

    @Override
    public void delete() throws DaoException {

    }

    protected List<T> getAll() throws DaoException, DatabaseConnectorException {
        String table = getTableName();
        return executeQuery("select * from " + table);
    }

    protected List<T> executeQuery(String query, Object... params) throws DaoException {
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
        } finally {

            try {
                ConnectionPool.getInstance().returnConnection(proxyConnection);
            } catch (DatabaseConnectorException e) {
                e.printStackTrace();
            }

        }
    }

    protected Optional<T> executeForSingleResult(String query, Object... params) throws DaoException {
        List<T> items = executeQuery(query, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new IllegalArgumentException("More than one item found");
        } else {
            return Optional.empty();
        }

    }

    protected List<T> executeForColumnResult(String columnName, String columnValue) throws DaoException {
        String table = getTableName();
        return executeQuery("select * from " + table + " where " + columnName + "='" + columnValue + "'");
    }

    protected boolean executeUpdate(String query) throws DaoException {
        try (PreparedStatement preparedStatement = createStatement(query)) {
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new DaoException("Unable to execute update query", exception);
        }
    }

    private PreparedStatement createStatement(String query, Object... params) throws DaoException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = proxyConnection.prepareStatement(query);
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

    String generateInsertQuery(Map<String, Object> map) {

        String table = getTableName();

        StringBuilder query = new StringBuilder();

        map.remove("id");

        query.append("INSERT ");
        query.append(table);
        query.append("(");

        Set<String> keys = map.keySet();
        StringJoiner keysJoiner = new StringJoiner(", ");
        for (String k : keys) {
            keysJoiner.add(k);
        }

        query.append(keysJoiner);
        query.append(")");
        query.append(" VALUES (");

        Collection<Object> values = map.values();
        StringJoiner valuesJoiner = new StringJoiner(", ");
        for (Object v : values) {
            if (v.getClass() == Boolean.class | v.getClass() == Long.class) {
                valuesJoiner.add(v.toString());
            } else {
                valuesJoiner.add(quote(v.toString()));
            }
        }

        query.append(valuesJoiner);
        query.append(")");

        return query.toString();
    }

    private String quote(String s) {
        return '\'' +
                s +
                '\'';
    }

    String generateUpdateQuery(Map<String, Object> map) {
        String table = getTableName();

        StringBuilder query = new StringBuilder();

        Long id = (Long) map.get("id");

        map.remove("id");

        query.append("UPDATE ");
        query.append(table);
        query.append(" SET ");

        StringJoiner joiner = new StringJoiner(", ");
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String unit;
            if (entry.getValue().getClass() == Boolean.class) {
                unit = entry.getKey() + "=" + entry.getValue();
            } else {
                unit = entry.getKey() + "=" + quote(entry.getValue().toString());
            }
            joiner.add(unit);
        }

        query.append(joiner);
        query.append(" WHERE id=");
        query.append(id);

        return query.toString();
    }

    protected abstract String getTableName();

    protected abstract Map<String, Object> getFields(T item);
}

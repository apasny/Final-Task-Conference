package com.epam.conference.dao;

import com.epam.conference.connection.ConnectionPool;
import com.epam.conference.connection.ProxyConnection;
import com.epam.conference.entity.Conference;
import com.epam.conference.exception.DaoException;
import com.epam.conference.exception.DatabaseConnectorException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class ConferenceDaoImplTest {

    @Test
    public void generateInsertQuery() throws DatabaseConnectorException, SQLException, DaoException {

        Conference conference = new Conference(null,"React", Date.valueOf("2022-12-22"), Date.valueOf("2022-12-24"),"Minsk",true,false);

        ConferenceDaoImpl conferenceDao = new ConferenceDaoImpl(new ProxyConnection(ConnectionPool.getInstance().getConnection(),ConnectionPool.getInstance()));

        Map<String, Object> map = conferenceDao.getFields(conference);

        String query = conferenceDao.generateInsertQuery(map);

        Assert.assertEquals("INSERT conference(topic, start_date, end_date, place, is_available, is_deleted) VALUES ('React', '2022-12-22', '2022-12-24', 'Minsk', true, false)",query);
    }

    @Test
    public void generateUpdateQuery() throws DatabaseConnectorException, SQLException, DaoException {

        Conference conference = new Conference(62L,"React2", Date.valueOf("2022-12-22"), Date.valueOf("2022-12-24"),"Minsk",true, false);

        ConferenceDaoImpl conferenceDao = new ConferenceDaoImpl(new ProxyConnection(ConnectionPool.getInstance().getConnection(),ConnectionPool.getInstance()));

        Map<String, Object> map = conferenceDao.getFields(conference);

        String query = conferenceDao.generateUpdateQuery(map);

        Assert.assertEquals("UPDATE conference SET topic='React2', start_date='2022-12-22', end_date='2022-12-24', place='Minsk', is_available=true, is_deleted=false WHERE id=62",query);
    }

//    @Test
//    public void executeForColumnResult() throws DatabaseConnectorException, SQLException, DaoException {
//        ConferenceDaoImpl conferenceDao = new ConferenceDaoImpl(new ProxyConnection(ConnectionPool.getInstance().getConnection(),ConnectionPool.getInstance()));
//        List<Conference> resultSet = conferenceDao.executeForColumnResult(Conference.ID, "62");
//        Assert.assertEquals(resultSet.size(),1);
//    }

//    @Test
//    public void getAll() throws DatabaseConnectorException, SQLException, DaoException {
//        ConferenceDaoImpl conferenceDao = new ConferenceDaoImpl(new ProxyConnection(ConnectionPool.getInstance().getConnection(),ConnectionPool.getInstance()));
//        List<Conference> resultSet = conferenceDao.getAll();
//        Assert.assertEquals(resultSet.size(),4);
//    }

}
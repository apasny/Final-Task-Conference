package com.epam.conference.service;

import com.epam.conference.dao.DaoHelper;
import com.epam.conference.dao.DaoHelperFactory;
import com.epam.conference.dao.RequestDao;
import com.epam.conference.entity.Request;
import com.epam.conference.exception.DatabaseConnectorException;
import com.epam.conference.exception.ServiceException;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class RequestServiceImplTest {
    @Test
    public void name() throws DatabaseConnectorException, SQLException, ServiceException {
        DaoHelperFactory daoHelperFactory = new DaoHelperFactory();

            DaoHelper daoHelper = daoHelperFactory.create();
            RequestDao requestDao = daoHelper.createRequestDao();
            RequestService requestService = new RequestServiceImpl(requestDao);
            List<Request> requests = requestService.allRequests();

        Assert.assertEquals(requests.size(),6);

    }
}
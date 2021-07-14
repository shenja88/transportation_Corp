package by.voluevich.transportation_corp.service.utils;

import by.voluevich.transportation_corp.controller.*;
import by.voluevich.transportation_corp.dao.*;

public class Dependencies {
    private static final TransportController TRANSPORT_CONTROLLER = new TransportControllerImpl();
    private static final TransportDAO TRANSPORT_DAO = new TransportDAOImpl();
    private static final UserController USER_CONTROLLER = new UserControllerImpl();
    private static final UserDAO USER_DAO = new UserDAOImpl();
    private static final LogQueriesController LOG_QUERIES_CONTROLLER = new LogQueriesControllerImpl();
    private static final LogQueriesDAO LOG_QUERIES_DAO = new LogQueriesDAOImpl();
    private static final CityController CITY_CONTROLLER = new CityControllerImpl();
    private static final CityDAO CITY_DAO = new CityDAOImpl();

    public static TransportController getTransportController() {
        return TRANSPORT_CONTROLLER;
    }

    public static TransportDAO getTransportDao() {
        return TRANSPORT_DAO;
    }

    public static UserController getUserController() {
        return USER_CONTROLLER;
    }

    public static UserDAO getUserDao() {
        return USER_DAO;
    }

    public static LogQueriesController getLogQueriesController() {
        return LOG_QUERIES_CONTROLLER;
    }

    public static LogQueriesDAO getLogQueriesDao() {
        return LOG_QUERIES_DAO;
    }

    public static CityController getCityController() {
        return CITY_CONTROLLER;
    }

    public static CityDAO getCityDao() {
        return CITY_DAO;
    }
}

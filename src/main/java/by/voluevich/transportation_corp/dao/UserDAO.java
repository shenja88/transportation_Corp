package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.entity.User;
import by.voluevich.transportation_corp.service.exception.LogInException;

import java.util.List;

public interface UserDAO {

    void getRegistration(User user);

    User logIn(User user) throws LogInException;
}


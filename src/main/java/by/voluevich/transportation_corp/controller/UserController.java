package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.entity.User;
import by.voluevich.transportation_corp.service.exception.LogInException;


public interface UserController {

    void getRegistration(User user);

    User logIn(User user) throws LogInException;
}

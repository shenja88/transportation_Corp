package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.service.exception.LogInException;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.entity.User;


public class UserControllerImpl implements UserController {

    @Override
    public void getRegistration(User user) {
        Dependencies.getUserDao().getRegistration(user);
    }

    @Override
    public User logIn(User user) throws LogInException {
        return Dependencies.getUserDao().logIn(user);
    }
}

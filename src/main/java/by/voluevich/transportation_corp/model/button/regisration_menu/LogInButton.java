package by.voluevich.transportation_corp.model.button.regisration_menu;

import by.voluevich.transportation_corp.Application;
import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.model.menu.TransportingMenu;
import by.voluevich.transportation_corp.service.exception.LogInException;
import by.voluevich.transportation_corp.service.exception.MenuItemNotFoundException;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.User;

public class LogInButton implements ActionButton {

    @Override
    public String name() {
        return "Log in.";
    }

    @Override
    public void tap() {
        User user = null;
        while (user == null) {
            try {
                user = Dependencies.getUserController().logIn(new User(
                        Input.getString("Enter name."),
                        Input.getString("Enter password.")));
            } catch (LogInException e) {
                System.out.println(e.getMessage());
            }
        }
        while (Application.started) {
            try {
                TransportingMenu menuUsers = new TransportingMenu(user);
                menuUsers.selectButton();
            } catch (MenuItemNotFoundException e) {
                e.getMessage();
            }
        }
    }
}

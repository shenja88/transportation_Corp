package by.voluevich.transportation_corp.model.button.regisration_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.User;
import by.voluevich.transportation_corp.entity.types.TypeUser;

public class GetRegistrationButton implements ActionButton {

    @Override
    public String name() {
        return "Registration (new user)";
    }

    @Override
    public void tap() {
        Dependencies.getUserController().getRegistration(new User(
                Input.getString("Enter name."),
                Input.getString("Enter password."),
                new TypeUser(1, "user")));
    }
}

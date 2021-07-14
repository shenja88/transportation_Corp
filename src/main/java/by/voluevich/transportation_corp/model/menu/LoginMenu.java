package by.voluevich.transportation_corp.model.menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.MenuItemNotFoundException;
import by.voluevich.transportation_corp.model.button.ExitButton;
import by.voluevich.transportation_corp.model.button.regisration_menu.GetRegistrationButton;
import by.voluevich.transportation_corp.model.button.regisration_menu.LogInButton;
import by.voluevich.transportation_corp.service.utils.Input;

import java.util.Arrays;
import java.util.List;

public class LoginMenu implements Menu {

    @Override
    public void getName() {
        System.out.println("========LogIn menu=======");
    }

    @Override
    public List<ActionButton> getMenu() {
        getName();
        return Arrays.asList(
                new ExitButton(),
                new GetRegistrationButton(),
                new LogInButton()
        );
    }

    @Override
    public void selectButton() throws MenuItemNotFoundException {
        List<ActionButton> menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + " - " + menu.get(i).name());
        }
        int select = Input.getInt("Select menu item.");
        if (select > menu.size() - 1 || select < 0) {
            throw new MenuItemNotFoundException();
        } else {
            menu.get(select).tap();
        }
    }
}


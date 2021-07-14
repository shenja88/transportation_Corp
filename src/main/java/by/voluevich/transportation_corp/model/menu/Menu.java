package by.voluevich.transportation_corp.model.menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.MenuItemNotFoundException;

import java.util.List;

public interface Menu {

    void getName();

    List<ActionButton> getMenu();

    void selectButton() throws MenuItemNotFoundException;
}

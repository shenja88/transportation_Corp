package by.voluevich.transportation_corp.model.button;

import by.voluevich.transportation_corp.service.exception.MenuItemNotFoundException;
import by.voluevich.transportation_corp.model.menu.Menu;

public class BackButton implements ActionButton {
    private Menu menu;

    public BackButton(Menu menu) {
        this.menu = menu;
    }

    public BackButton() {
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public String name() {
        return "Back";
    }

    @Override
    public void tap() {
        try {
            menu.selectButton();
        } catch (MenuItemNotFoundException e) {
            e.getMessage();
        }
    }
}

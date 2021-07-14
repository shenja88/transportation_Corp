package by.voluevich.transportation_corp.model.menu;

import by.voluevich.transportation_corp.entity.User;
import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.model.button.BackButton;
import by.voluevich.transportation_corp.model.button.transporting_menu.*;
import by.voluevich.transportation_corp.service.exception.MenuItemNotFoundException;
import by.voluevich.transportation_corp.service.utils.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransportingMenu implements Menu {
    private User user;

    public TransportingMenu(User user) {
        this.user = user;
    }

    public TransportingMenu() {
    }

    public User getUser() {
        return user;
    }

    @Override
    public void getName() {
        System.out.println("\n=========Transporting menu========");
    }

    @Override
    public List<ActionButton> getMenu() {
        getName();
        if (user.getTypeUser().getName().equals("user")) {
            return Arrays.asList(
                    new BackButton(new LoginMenu()),
                    new GetCityButton(),
                    new GetTransportButton(),
                    new GetTripCalculationButton());
        } else if (user.getTypeUser().getName().equals("admin")) {
            return Arrays.asList(
                    new BackButton(new LoginMenu()),
                    new GetCityButton(),
                    new GetTransportButton(),
                    new GetTripCalculationButton(),
                    new AddCityButton(),
                    new AddTransportButton(),
                    new UpdateCityButton(),
                    new UpdateTransportButton(),
                    new RemoveCityButton(),
                    new RemoveTransportButton(),
                    new ExportReportButton(),
                    new GetReportButton());
        }
        return new ArrayList<>();
    }

    @Override
    public void selectButton() throws MenuItemNotFoundException {
        List<ActionButton> menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + " - " + menu.get(i).name());
        }
        int select = Input.getInt("Select operation.");
        if (select >= menu.size() || select < 0) {
            throw new MenuItemNotFoundException();
        } else {
            menu.get(select).tap();
        }
    }
}

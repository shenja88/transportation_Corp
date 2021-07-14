package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;

import java.util.List;

public class AddCityButton implements ActionButton {

    @Override
    public String name() {
        return "Add city.";
    }

    @Override
    public void tap() {
        List<ContinentsIsland> list = Dependencies.getCityController().getContinentsIsland();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + " - " + list.get(i).getName());
        }
        int select = Input.getInt("Select continents or island.");
        while (true) {
            if (select > list.size() || select < 1) {
                select = Input.getInt("Repeat entry.");
            } else {
                Dependencies.getCityController().addCity(new City(
                        Input.getString("Enter name."),
                        Input.getDouble("Enter longitude."),
                        Input.getDouble("Enter latitude."),
                        Input.getBoolean("There is an airport?(true or false)"),
                        Input.getBoolean("There is an seaport?(true or false)"),
                        new ContinentsIsland(
                                list.get(select - 1).getId(),
                                list.get(select - 1).getName()
                        )));
                break;
            }
        }
    }
}

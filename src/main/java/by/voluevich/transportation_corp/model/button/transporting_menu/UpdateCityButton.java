package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;

import java.util.List;

public class UpdateCityButton implements ActionButton {

    @Override
    public String name() {
        return "Update city.";
    }

    @Override
    public void tap() {
        List<City> cityList = Dependencies.getCityController().getCities();
        for (City c : cityList) {
            System.out.println(c.getId() + " - " + c.getName());
        }
        int idC = Input.getInt("Enter id of city to update.");
        List<ContinentsIsland> listContinents = Dependencies.getCityController().getContinentsIsland();
        for (ContinentsIsland cI : listContinents) {
            System.out.println(cI.getId() + " - " + cI.getName());
        }
        int select = Input.getInt("Select continents or island.");
        while (true) {
            if ((select > listContinents.size()) || select < 1) {
                select = Input.getInt("Repeat entry.");
            } else {
                try {
                    Dependencies.getCityController().updateCity(new City(
                            idC,
                            Input.getString("Enter name."),
                            Input.getDouble("Enter longitude."),
                            Input.getDouble("Enter latitude."),
                            Input.getBoolean("There is an airport?(true or false)"),
                            Input.getBoolean("There is an seaport?(true or false)"),
                            new ContinentsIsland(
                                    listContinents.get(select - 1).getId(),
                                    listContinents.get(select - 1).getName()
                            )
                    ));
                } catch (IdNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }
}



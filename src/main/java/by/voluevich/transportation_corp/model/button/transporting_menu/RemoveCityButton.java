package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.City;

import java.util.List;

public class RemoveCityButton implements ActionButton {

    @Override
    public String name() {
        return "Remove city";
    }

    @Override
    public void tap() {
        List<City> cityList = Dependencies.getCityController().getCities();
        for (City c : cityList) {
            System.out.println(c.getId() + " - " + c.getName());
        }
        int idC = Input.getInt("Enter id of city to remove.");
        try {
            Dependencies.getCityController().removeCity(idC);

        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


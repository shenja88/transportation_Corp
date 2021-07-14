package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.entity.City;

import java.util.Comparator;

public class GetCityButton implements ActionButton {

    @Override
    public String name() {
        return "Show list of available cities.";
    }

    @Override
    public void tap() {
        Dependencies.getCityController().getCities()
                .stream()
                .sorted(Comparator.comparing(City::getName))
                .forEach(System.out::println);
    }
}

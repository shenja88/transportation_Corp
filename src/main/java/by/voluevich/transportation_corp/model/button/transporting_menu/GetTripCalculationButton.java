package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.TransportNotFoundException;
import by.voluevich.transportation_corp.service.log.TypeQuery;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;

import java.util.List;


public class GetTripCalculationButton implements ActionButton {

    @Override
    public String name() {
        return "Choose the best route for transportation.";
    }

    @Override
    public void tap() {
        List<City> cityList = Dependencies.getCityController().getCities();
        for (int i = 0; i < cityList.size(); i++) {
            System.out.println((i + 1) + " - " + cityList.get(i).getName() + "(" +
                    cityList.get(i).getContinentsIsland().getName() + ").");
        }
        City city1 = cityList.get(Input.getInt("Select a departure city.") - 1);
        City city2 = cityList.get(Input.getInt("Select a city of arrival.") - 1);
        double distance = city1.getDistance(city2);
        TypeQuery typeQuery = getTypeQr();
        int numPass = Input.getInt("Enter the number of passengers.");
        int cargoW = Input.getInt("Enter the cargo weight in tons.");
        try {
            Dependencies.getTransportController().getTrip(city1, city2, distance, numPass, cargoW, typeQuery);
        } catch (TransportNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private TypeQuery getTypeQr() {
        List<TypeQuery> type = Dependencies.getLogQueriesController().getTypeQueries();
        System.out.println("Select type operation.");
        while (true) {
            for (int i = 0; i < type.size(); i++) {
                System.out.println((i + 1) + " - " + type.get(i).getName());
            }
            int x = Input.getInt();
            if (x > type.size() || x < 1) {
                System.out.println("Repeat entry!");
            } else {
                return type.get(x - 1);
            }
        }
    }
}




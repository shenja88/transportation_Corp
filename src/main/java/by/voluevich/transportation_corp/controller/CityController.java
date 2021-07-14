package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;

import java.util.List;

public interface CityController {
    List<City> getCities();

    List<ContinentsIsland> getContinentsIsland();

    void addCity(City city);

    void updateCity(City city) throws IdNotFoundException;

    void removeCity(int id) throws IdNotFoundException;
}

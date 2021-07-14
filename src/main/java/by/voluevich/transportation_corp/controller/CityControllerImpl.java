package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.utils.Dependencies;

import java.util.List;

public class CityControllerImpl implements CityController {

    @Override
    public List<City> getCities() {
        return Dependencies.getCityDao().getCities();
    }

    @Override
    public List<ContinentsIsland> getContinentsIsland() {
        return Dependencies.getCityDao().getContinentsIsland();
    }

    @Override
    public void addCity(City city) {
        Dependencies.getCityDao().addCity(city);
    }

    @Override
    public void updateCity(City city) throws IdNotFoundException {
        Dependencies.getCityDao().updateCity(city);
    }

    @Override
    public void removeCity(int id) throws IdNotFoundException {
        Dependencies.getCityDao().removeCity(id);
    }
}

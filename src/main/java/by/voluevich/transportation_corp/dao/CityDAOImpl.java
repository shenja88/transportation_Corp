package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public List<City> getCities() {
        List<City> cityList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM transportation_corp.getcitylist";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                cityList.add(new City(
                        resultSet.getInt("city_id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("longitude"),
                        resultSet.getDouble("latitude"),
                        resultSet.getBoolean("check_airport"),
                        resultSet.getBoolean("check_seaport"),
                        new ContinentsIsland(
                                resultSet.getInt("continents_island_id"),
                                resultSet.getString("nameCont")
                        )));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<ContinentsIsland> getContinentsIsland() {
        List<ContinentsIsland> list = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM continents_island ORDER BY continents_island_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                list.add(
                        new ContinentsIsland(
                                resultSet.getInt("continents_island_id"),
                                resultSet.getString("name")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return list;
    }

    @Override
    public void addCity(City city) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "INSERT INTO city (name, longitude, latitude, check_airport, check_seaport, continents_island_id)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, city.getName());
            statement.setDouble(2, city.getLongitude());
            statement.setDouble(3, city.getLatitude());
            statement.setBoolean(4, city.isCheckAirport());
            statement.setBoolean(5, city.isCheckSeaport());
            statement.setInt(6, city.getContinentsIsland().getId());
            statement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateCity(City city) throws IdNotFoundException {
        if (isExistsCity(city.getId())) {
            try (Connection connection = ConnectionManager.getConnection()) {
                String query = "UPDATE city SET name = ?, longitude = ?, latitude = ?, check_airport = ?, " +
                        "check_seaport = ?, continents_island_id = ? WHERE city_id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, city.getName());
                statement.setDouble(2, city.getLongitude());
                statement.setDouble(3, city.getLatitude());
                statement.setBoolean(4, city.isCheckAirport());
                statement.setBoolean(5, city.isCheckSeaport());
                statement.setInt(6, city.getContinentsIsland().getId());
                statement.setInt(7, city.getId());
                statement.execute();
            } catch (SQLException troubles) {
                troubles.printStackTrace();
            }
        } else {
            throw new IdNotFoundException(city.getId());
        }
    }

    @Override
    public void removeCity(int id) throws IdNotFoundException {
        if (isExistsCity(id)) {
            try (Connection connection = ConnectionManager.getConnection()) {
                String query = "DELETE FROM city WHERE city_id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, id);
                statement.execute();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } else {
            throw new IdNotFoundException(id);
        }
    }

    private boolean isExistsCity(int id) {
        boolean isExist = false;
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM transportation_corp.city WHERE city_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isExist = true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return isExist;
    }
}

package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;
import by.voluevich.transportation_corp.entity.Transport;
import by.voluevich.transportation_corp.entity.types.TypeTransport;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.exception.TransportNotFoundException;
import by.voluevich.transportation_corp.service.log.QueryWrapper;
import by.voluevich.transportation_corp.service.log.TypeQuery;


import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransportDAOImpl implements TransportDAO {

    @Override
    public List<TypeTransport> getTypeTransport() {
        List<TypeTransport> transportList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM type_transport ORDER BY type_transport_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                transportList.add(new TypeTransport(
                        resultSet.getInt("type_transport_id"),
                        resultSet.getString("type_name")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return transportList;
    }

    @Override
    public List<Transport> getTransports() {
        List<Transport> transportList = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM transportation_corp.gettransport";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                transportList.add(new Transport(
                        resultSet.getInt("transport_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("speed"),
                        resultSet.getInt("passenger_num"),
                        resultSet.getInt("cargo_weight"),
                        new TypeTransport(
                                resultSet.getInt("type_transport_id"),
                                resultSet.getString("type_name")),
                        resultSet.getInt("price_per_km")));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return transportList;
    }

    @Override
    public void addTransport(Transport transport) {
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "INSERT INTO transport (name, speed, passenger_num, cargo_weight, type_transport, price_per_km)" +
                    " VALUES (?, ?, ?, ?, ?, ?) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, transport.getName());
            statement.setInt(2, transport.getSpeed());
            statement.setInt(3, transport.getPassenger_num());
            statement.setInt(4, transport.getCargo_weight());
            statement.setInt(5, transport.getTypeTransport().getId());
            statement.setInt(6, transport.getPrice_per_km());
            statement.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateTransport(Transport transport) throws IdNotFoundException {
        if (isExistsTransport(transport.getId())) {
            try (Connection connection = ConnectionManager.getConnection()) {
                String query = "UPDATE transport SET name = ?, speed = ?, passenger_num = ?, cargo_weight = ?," +
                        " type_transport = ?, price_per_km = ? WHERE transport_id = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, transport.getName());
                statement.setInt(2, transport.getSpeed());
                statement.setInt(3, transport.getPassenger_num());
                statement.setInt(4, transport.getCargo_weight());
                statement.setInt(5, transport.getTypeTransport().getId());
                statement.setInt(6, transport.getPrice_per_km());
                statement.setInt(7, transport.getId());
                statement.execute();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        } else {
            throw new IdNotFoundException(transport.getId());
        }
    }

    @Override
    public void removeTransport(int id) throws IdNotFoundException {
        if (isExistsTransport(id)) {
            try (Connection connection = ConnectionManager.getConnection()) {
                String query = "DELETE FROM transport WHERE transport_id = ?";
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

    private boolean isExistsTransport(int id) {
        boolean isExist = false;
        try (Connection connection = ConnectionManager.getConnection()) {
            String query = "SELECT * FROM transportation_corp.transport WHERE transport_id = ?";
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

    public void getTrip(City city1, City city2, double distance, int numPass, int cargoW, TypeQuery typeQuery) throws TransportNotFoundException {
        List<TypeTransport> listType = getTypeTr(city1, city2);
        List<Transport> transportListByType = getTransportByType(listType);
        Transport transportForTrip = new Transport();
        if (typeQuery.getName().equals("fastest")) {
            transportForTrip = getFastTransport(transportListByType, numPass, cargoW);
        } else if (typeQuery.getName().equals("cheapest")) {
            transportForTrip = getCheapestTransport(transportListByType, numPass, cargoW);
        }
        if (transportForTrip == null) {
            throw new TransportNotFoundException(numPass, cargoW);
        } else {
            System.out.printf("The %s transport to deliver %s people and %s tons" +
                            " of cargo from %s to %s is a %s. " +
                            "Travel time is %.1f hours. The cost is %.1f $. Distance %.1f km.\n",
                    typeQuery.getName(), numPass, cargoW, city1.getName(), city2.getName(), transportForTrip.getName(),
                    (distance / transportForTrip.getSpeed()),
                    (transportForTrip.getPrice_per_km() * distance), distance);
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.toLog(city1, city2, transportForTrip, numPass, cargoW, typeQuery);
        }
    }

    private Transport getCheapestTransport(List<Transport> list, int numPass, int cargoW) {


        return list
                .stream()
                .filter(x -> x.getPassenger_num() >= numPass && x.getCargo_weight() >= cargoW)
                .min(Comparator.comparing(Transport::getPrice_per_km))
                .orElse(null);
    }

    private Transport getFastTransport(List<Transport> list, int numPass, int cargoW) {
        return list
                .stream()
                .filter(x -> x.getPassenger_num() >= numPass && x.getCargo_weight() >= cargoW)
                .max(Comparator.comparing(Transport::getSpeed))
                .orElse(null);
    }

    private List<Transport> getTransportByType(List<TypeTransport> type) {
        List<Transport> listByType = new ArrayList<>();
        List<Transport> transportList = getTransports();
        for (TypeTransport typeTransport : type) {
            for (Transport tr : transportList) {
                if (tr.getTypeTransport().equals(typeTransport)) {
                    listByType.add(tr);
                }
            }
        }
        return listByType;
    }

    private List<TypeTransport> getTypeTr(City one, City two) {
        List<TypeTransport> typeTransportList = new ArrayList<>();
        if (isUsingGroundTransport(one, two)) {
            typeTransportList.add(new TypeTransport(3, "ground"));
        }
        if (one.isCheckAirport() && two.isCheckAirport()) {
            typeTransportList.add(new TypeTransport(1, "airborne"));
        }
        if (one.isCheckSeaport() && two.isCheckSeaport()) {
            typeTransportList.add(new TypeTransport(2, "maritime"));
        }
        return typeTransportList;
    }

    private boolean isUsingGroundTransport(City city1, City city2) {
        return city1.getContinentsIsland().equals(city2.getContinentsIsland())
                && !city1.getContinentsIsland().equals(new ContinentsIsland(7, "Island"))
                && !city2.getContinentsIsland().equals(new ContinentsIsland(7, "Island"));
    }
}
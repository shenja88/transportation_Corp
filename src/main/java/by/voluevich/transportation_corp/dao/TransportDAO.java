package by.voluevich.transportation_corp.dao;

import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;
import by.voluevich.transportation_corp.entity.Transport;
import by.voluevich.transportation_corp.entity.types.TypeTransport;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.exception.TransportNotFoundException;
import by.voluevich.transportation_corp.service.log.TypeQuery;

import java.util.List;

public interface TransportDAO {

    List<Transport> getTransports();

    List<TypeTransport> getTypeTransport();

    void addTransport(Transport transport);

    void updateTransport(Transport transport) throws IdNotFoundException;

    void removeTransport(int id) throws IdNotFoundException;

    void getTrip(City city1, City city2, double distance, int numPass, int cargoW, TypeQuery typeQuery) throws TransportNotFoundException;

}

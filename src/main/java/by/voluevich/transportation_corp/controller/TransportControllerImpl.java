package by.voluevich.transportation_corp.controller;

import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.exception.TransportNotFoundException;
import by.voluevich.transportation_corp.service.log.TypeQuery;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.entity.City;
import by.voluevich.transportation_corp.entity.Transport;
import by.voluevich.transportation_corp.entity.types.ContinentsIsland;
import by.voluevich.transportation_corp.entity.types.TypeTransport;

import java.util.List;

public class TransportControllerImpl implements TransportController {

    @Override
    public List<Transport> getTransports() {
        return Dependencies.getTransportDao().getTransports();
    }

    @Override
    public List<TypeTransport> getTypeTransport() {
        return Dependencies.getTransportDao().getTypeTransport();
    }

    @Override
    public void addTransport(Transport transport) {
        Dependencies.getTransportDao().addTransport(transport);
    }

    @Override
    public void updateTransport(Transport transport) throws IdNotFoundException {
        Dependencies.getTransportDao().updateTransport(transport);
    }

    @Override
    public void removeTransport(int id) throws IdNotFoundException {
        Dependencies.getTransportDao().removeTransport(id);
    }

    @Override
    public void getTrip(City city1, City city2, double distance, int numPass, int cargoW, TypeQuery typeQuery) throws TransportNotFoundException {
        Dependencies.getTransportDao().getTrip(city1, city2, distance, numPass, cargoW, typeQuery);
    }

}

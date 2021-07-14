package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.entity.Transport;

import java.util.Comparator;

public class GetTransportButton implements ActionButton {

    @Override
    public String name() {
        return "Show list of available transports.";
    }

    @Override
    public void tap() {
        Dependencies.getTransportController().getTransports()
                .stream()
                .sorted(Comparator.comparing(Transport::getName))
                .forEach(System.out::println);
    }
}

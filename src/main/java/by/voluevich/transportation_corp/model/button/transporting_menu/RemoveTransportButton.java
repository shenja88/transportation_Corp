package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.Transport;

import java.util.List;

public class RemoveTransportButton implements ActionButton {

    @Override
    public String name() {
        return "Remove transport.";
    }

    @Override
    public void tap() {
        List<Transport> transportList = Dependencies.getTransportController().getTransports();
        for (Transport tr : transportList) {
            System.out.println(tr.getId() + " - " + tr.getName());
        }
        int idTr = Input.getInt("Enter id of transport to remove.");
        try {
            Dependencies.getTransportController().removeTransport(idTr);
        } catch (IdNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}


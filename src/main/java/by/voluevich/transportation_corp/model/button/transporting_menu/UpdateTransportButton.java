package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.exception.IdNotFoundException;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.Transport;
import by.voluevich.transportation_corp.entity.types.TypeTransport;

import java.util.List;

public class UpdateTransportButton implements ActionButton {

    @Override
    public String name() {
        return "Update transport.";
    }

    @Override
    public void tap() {
        List<Transport> transportList = Dependencies.getTransportController().getTransports();
        for (Transport tr : transportList) {
            System.out.println(tr.getId() + " - " + tr.getName());
        }
        int idTr = Input.getInt("Enter id of transport to update.");
        List<TypeTransport> typeTransportList = Dependencies.getTransportController().getTypeTransport();
        for (TypeTransport tt : typeTransportList) {
            System.out.println(tt.getId() + " - " + tt.getName());
        }
        int select = Input.getInt("Select type of transport.");
        while (true) {
            if ((select > typeTransportList.size()) || select < 1) {
                select = Input.getInt("Repeat entry type of transport.");
            } else {
                try {
                    Dependencies.getTransportController().updateTransport(new Transport(
                            idTr,
                            Input.getString("Enter name."),
                            Input.getInt("Enter speed."),
                            Input.getInt("Enter maximum number of passengers"),
                            Input.getInt("Enter the maximum carrying capacity in tons."),
                            new TypeTransport(
                                    typeTransportList.get(select - 1).getId(),
                                    typeTransportList.get(select - 1).getName()
                            ),
                            Input.getInt("Enter the price per kilometer.")));
                } catch (IdNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
        }
    }
}


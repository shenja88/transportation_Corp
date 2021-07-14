package by.voluevich.transportation_corp.model.button.transporting_menu;

import by.voluevich.transportation_corp.model.button.ActionButton;
import by.voluevich.transportation_corp.service.utils.Dependencies;
import by.voluevich.transportation_corp.service.utils.Input;
import by.voluevich.transportation_corp.entity.Transport;
import by.voluevich.transportation_corp.entity.types.TypeTransport;

import java.util.List;

public class AddTransportButton implements ActionButton {

    @Override
    public String name() {
        return "Add transport.";
    }

    @Override
    public void tap() {
        List<TypeTransport> typeTransportList = Dependencies.getTransportController().getTypeTransport();
        for (int i = 0; i < typeTransportList.size(); i++) {
            System.out.println((i + 1) + " - " + typeTransportList.get(i).getName());
        }
        int select = Input.getInt("Select type of transport.");
        while (true) {
            if ((select > typeTransportList.size()) || select < 1) {
                select = Input.getInt("Repeat entry.");
            } else {
                Dependencies.getTransportController().addTransport(new Transport(
                        Input.getString("Enter name."),
                        Input.getInt("Enter speed."),
                        Input.getInt("Enter maximum number of passengers"),
                        Input.getInt("Enter the maximum carrying capacity in tons."),
                        new TypeTransport(
                                typeTransportList.get(select - 1).getId(),
                                typeTransportList.get(select - 1).getName()
                        ),
                        Input.getInt("Enter the price per kilometer.")));
                break;
            }
        }
    }
}

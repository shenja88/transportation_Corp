package by.voluevich.transportation_corp.service.exception;

public class MenuItemNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "The selected menu item does not exist. Repeat entry.";
    }
}

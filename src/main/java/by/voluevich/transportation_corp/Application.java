package by.voluevich.transportation_corp;

import by.voluevich.transportation_corp.model.menu.LoginMenu;
import by.voluevich.transportation_corp.service.exception.MenuItemNotFoundException;

public class Application {
    public static boolean started = true;

    public Application() {
    }

    public void start() {
        while (started) {
            try {
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.selectButton();
            } catch (MenuItemNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

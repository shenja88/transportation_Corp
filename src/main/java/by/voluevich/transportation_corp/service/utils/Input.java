package by.voluevich.transportation_corp.service.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInt() {
        if (SCANNER.hasNextInt()) {
            int x = SCANNER.nextInt();
            SCANNER.nextLine();
            return x;
        }
        System.out.println("Enter a integer!");
        SCANNER.nextLine();
        return getInt();
    }

    public static int getInt(String message) {
        System.out.println(message);
        return getInt();
    }

    public static String getString() {
        if (SCANNER.hasNextLine()) {
            return SCANNER.nextLine();
        } else {
            System.out.println("Enter a string!");
            SCANNER.nextLine();
            return getString();
        }
    }

    public static String getString(String message) {
        System.out.println(message);
        return getString();
    }

    public static double getDouble() {
        if (SCANNER.hasNextDouble()) {
            double x = SCANNER.nextDouble();
            SCANNER.nextLine();
            return x;
        }
        System.out.println("Enter a double!");
        SCANNER.nextLine();
        return getDouble();
    }

    public static double getDouble(String message) {
        System.out.println(message);
        return getDouble();
    }

    public static boolean getBoolean() {
        if (SCANNER.hasNextBoolean()) {
            boolean x = SCANNER.nextBoolean();
            SCANNER.nextLine();
            return x;
        }
        System.out.println("Enter true or false!");
        SCANNER.nextLine();
        return getBoolean();
    }

    public static boolean getBoolean(String message) {
        System.out.println(message);
        return getBoolean();
    }
}

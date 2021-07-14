package by.voluevich.transportation_corp.entity;

import by.voluevich.transportation_corp.entity.types.TypeTransport;

public class Transport {
    private int id;
    private String name;
    private int speed;
    private int passenger_num;
    private int cargo_weight;
    private TypeTransport typeTransport;
    private int price_per_km;

    public Transport(int id, String name, int speed, int passenger_num, int cargo_weight, TypeTransport typeTransport,
                     int price_per_km) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.passenger_num = passenger_num;
        this.cargo_weight = cargo_weight;
        this.typeTransport = typeTransport;
        this.price_per_km = price_per_km;
    }

    public Transport(String name, int speed, int passenger_num, int cargo_weight, TypeTransport typeTransport,
                     int price_per_km) {
        this.name = name;
        this.speed = speed;
        this.passenger_num = passenger_num;
        this.cargo_weight = cargo_weight;
        this.typeTransport = typeTransport;
        this.price_per_km = price_per_km;
    }
    public Transport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPassenger_num() {
        return passenger_num;
    }

    public void setPassenger_num(int passenger_num) {
        this.passenger_num = passenger_num;
    }

    public int getCargo_weight() {
        return cargo_weight;
    }

    public void setCargo_weight(int cargo_weight) {
        this.cargo_weight = cargo_weight;
    }

    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    public int getPrice_per_km() {
        return price_per_km;
    }

    public void setPrice_per_km(int price_per_km) {
        this.price_per_km = price_per_km;
    }

    @Override
    public String toString() {
        return "Transport: " + name + " (" + typeTransport.getName() + ")" + ", speed " + speed +
                ", max passenger capacity " + passenger_num + ", max cargo weight " + cargo_weight +
                ", price per km " + price_per_km + ".";
    }
}

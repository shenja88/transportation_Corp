package by.voluevich.transportation_corp.entity;

import by.voluevich.transportation_corp.entity.types.ContinentsIsland;

public class City {
    private int id;
    private String name;
    private double longitude;
    private double latitude;
    private boolean checkAirport;
    private boolean checkSeaport;
    private ContinentsIsland continentsIsland;

    public City(int id, String name, double longitude, double latitude,
                boolean checkAirport, boolean checkSeaport, ContinentsIsland continentsIsland) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.checkAirport = checkAirport;
        this.checkSeaport = checkSeaport;
        this.continentsIsland = continentsIsland;
    }

    public City(String name, double longitude, double latitude,
                boolean checkAirport, boolean checkSeaport, ContinentsIsland continentsIsland) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.checkAirport = checkAirport;
        this.checkSeaport = checkSeaport;
        this.continentsIsland = continentsIsland;
    }

    public City() {
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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isCheckAirport() {
        return checkAirport;
    }

    public void setCheckAirport(boolean checkAirport) {
        this.checkAirport = checkAirport;
    }

    public boolean isCheckSeaport() {
        return checkSeaport;
    }

    public void setCheckSeaport(boolean checkSeaport) {
        this.checkSeaport = checkSeaport;
    }

    public ContinentsIsland getContinentsIsland() {
        return continentsIsland;
    }

    public void setContinentsIsland(ContinentsIsland continentsIsland) {
        this.continentsIsland = continentsIsland;
    }

    @Override
    public String toString() {
        return "City: " + name + "(" + continentsIsland + "). Airport: " + checkAirport + ". Seaport: " + checkSeaport;
    }

    public double getDistance(City city) {
        double earthRadius = 6371.0;
        double diffBetweenLatitudeRadians = Math.toRadians(city.getLatitude() - this.getLatitude());
        double diffBetweenLongitudeRadians = Math.toRadians(city.getLongitude() - this.getLongitude());
        double latitudeOneInRadians = Math.toRadians(this.getLatitude());
        double latitudeTwoInRadians = Math.toRadians(city.getLatitude());
        double a = Math.sin(diffBetweenLatitudeRadians / 2) * Math.sin(diffBetweenLatitudeRadians / 2) +
                Math.cos(latitudeOneInRadians) * Math.cos(latitudeTwoInRadians) * Math.sin(diffBetweenLongitudeRadians / 2)
                        * Math.sin(diffBetweenLongitudeRadians / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (earthRadius * c);
    }
}

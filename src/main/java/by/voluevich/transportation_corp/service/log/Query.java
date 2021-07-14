package by.voluevich.transportation_corp.service.log;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"date", "cityFromWhere", "cityWhereTo", "transport", "numPass", "cargoW", "typeQuery"})
public class Query {
    private String date;
    private String cityFromWhere;
    private String cityWhereTo;
    private String transport;
    private int numPass;
    private int cargoW;
    private TypeQuery typeQuery;

    public Query(String date, String cityFromWhere, String cityWhereTo, String transport, int numPass,
                 int cargoW, TypeQuery typeQuery) {
        this.date = date;
        this.cityFromWhere = cityFromWhere;
        this.cityWhereTo = cityWhereTo;
        this.transport = transport;
        this.numPass = numPass;
        this.cargoW = cargoW;
        this.typeQuery = typeQuery;
    }

    public Query() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCityFromWhere() {
        return cityFromWhere;
    }

    public void setCityFromWhere(String cityFromWhere) {
        this.cityFromWhere = cityFromWhere;
    }

    public String getCityWhereTo() {
        return cityWhereTo;
    }

    public void setCityWhereTo(String cityWhereTo) {
        this.cityWhereTo = cityWhereTo;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public int getNumPass() {
        return numPass;
    }

    public void setNumPass(int numPass) {
        this.numPass = numPass;
    }

    public int getCargoW() {
        return cargoW;
    }

    public void setCargoW(int cargoW) {
        this.cargoW = cargoW;
    }

    @XmlElement(name = "type")
    public TypeQuery getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(TypeQuery typeQuery) {
        this.typeQuery = typeQuery;
    }

    @Override
    public String toString() {
        return "Query (" + typeQuery + "): " + date + " register trip: " + cityFromWhere + " -> " +
                cityWhereTo + ". Cargo " + cargoW + " tons and " + numPass + " passengers. Transport " +
                transport + ".";
    }
}

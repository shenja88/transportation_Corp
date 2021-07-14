package by.voluevich.transportation_corp.service.exception;

public class TransportNotFoundException extends Exception {
    private int numPass;
    private int cargoW;

    public TransportNotFoundException(int numPass, int cargoW) {
        this.numPass = numPass;
        this.cargoW = cargoW;
    }

    public TransportNotFoundException() {
    }

    @Override
    public String getMessage() {
        return "The transport you need for " + numPass + " people and " + cargoW + " tons of cargo was not found.";
    }
}

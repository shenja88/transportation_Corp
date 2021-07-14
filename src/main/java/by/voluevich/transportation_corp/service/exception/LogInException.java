package by.voluevich.transportation_corp.service.exception;

public class LogInException extends Exception {
    @Override
    public String getMessage() {
        return "Login error!\n";
    }
}

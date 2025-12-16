package bank;

public class BankSystemException extends Exception{

    private String message;

    public BankSystemException(String message) {
        super(message);
    }
}

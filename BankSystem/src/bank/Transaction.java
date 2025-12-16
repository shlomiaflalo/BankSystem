package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final String date;
    private final int amount;
    private final int balance;

    public Transaction(int amount, int balance) {
        this.date = transactionTime();
        this.amount = amount;
        this.balance = balance;
    }

    private String transactionTime() {
        return LocalDate.now().format(PATTERN);
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return this.date + " || " +
                this.amount+ "   || " +
                this.balance;
    }
}



package bank;

import java.time.LocalDate;
import java.util.Objects;

public class Client extends Person {


    private final LocalDate accountOpeningDate;

    public Client(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.accountOpeningDate = LocalDate.now();
    }

    public LocalDate getAccountOpeningDate() {
        return accountOpeningDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Client client = (Client) o;
        return Objects.equals(accountOpeningDate, client.accountOpeningDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accountOpeningDate);
    }


    @Override
    public String toString() {
        return "Client: " +
                super.toString() +
                ", accountOpeningDate: " + accountOpeningDate;
    }
}

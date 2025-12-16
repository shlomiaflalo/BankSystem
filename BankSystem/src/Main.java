import bank.Account;
import bank.Client;


public class Main {

    public static void main(String[] args) {

        Client client = new Client("John",
                "Jackson",30);

        Account account = new Account(client);

        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();

        account.showMyProfile();

    }
}

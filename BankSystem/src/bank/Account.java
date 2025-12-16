package bank;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Account implements AccountService {

    private final List<Transaction> transactions;
    private int balance;
    private final Client client;

    public Account(Client client) {
        this.client = client;
        this.balance = 0;
        this.transactions = new CopyOnWriteArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public int getBalance() {
        return balance;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public void deposit(int amount) {
        try {
            validateAmount(amount); //Validating first before deposit
            balance += amount;
            transactions.add(new Transaction(amount, balance));
        } catch (BankSystemException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void withdraw(int amount) {
        try{
            validateAmount(amount);
            insufficientCheck(amount);

            balance -= amount;
            transactions.add(new Transaction(-amount, balance));
        } catch (BankSystemException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void printStatement() {
        System.out.println("DATE       || AMOUNT || BALANCE");

        int lastTransaction = transactions.size() - 1;
        for (int i = lastTransaction; i >= 0; i--) {
            System.out.println(transactions.get(i));
        }

        System.out.println("Shukran for choosing Skypay\n");
    }

    private void validateAmount(int amount) throws BankSystemException {
            if(amount <= 0) {
                throw new BankSystemException("Amount must be bigger than zero");
            }
    }

    private void insufficientCheck (int amount) throws BankSystemException {
        if(amount > balance) {
            throw new BankSystemException("Insufficient funds");
        }
    }

    public void showMyProfile() {
        System.out.println("My Profile: "+client.toString()+
                "\nDate:" + LocalDate.now() +", Amount:"
                + balance +"\nMy transaction:\n");
        printStatement();
    }
}

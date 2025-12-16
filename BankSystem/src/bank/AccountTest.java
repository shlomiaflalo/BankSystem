package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        Client client = new Client("John", "Doe", 30);
        account = new Account(client);
    }

    @Test
    void deposit_shouldIncreaseBalanceAndAddTransaction() {
        account.deposit(100);

        assertEquals(100, account.getBalance());
        assertEquals(1, account.getTransactions().size());

        Transaction transaction = account.getTransactions().get(0);
        assertEquals(100, transaction.getAmount());
        assertEquals(100, transaction.getBalance());
    }

    @Test
    void deposit_shouldNotChangeBalanceForInvalidAmount() {
        account.deposit(0);

        assertEquals(0, account.getBalance());
        assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    void withdraw_shouldDecreaseBalanceAndAddTransaction() {
        account.deposit(200);
        account.withdraw(50);

        assertEquals(150, account.getBalance());
        assertEquals(2, account.getTransactions().size());

        Transaction transaction = account.getTransactions().get(1);
        assertEquals(-50, transaction.getAmount());
        assertEquals(150, transaction.getBalance());
    }

    @Test
    void withdraw_shouldFailIfInsufficientFunds() {
        account.withdraw(100);

        assertEquals(0, account.getBalance());
        assertTrue(account.getTransactions().isEmpty());
    }

    @Test
    void withdraw_shouldNotChangeBalanceForInvalidAmount() {
        account.deposit(100);
        account.withdraw(0);

        assertEquals(100, account.getBalance());
        assertEquals(1, account.getTransactions().size());
    }


    @Test
    void transactions_shouldBeStoredInCorrectOrder() {
        account.deposit(100);
        account.deposit(50);
        account.withdraw(30);

        assertEquals(3, account.getTransactions().size());

        assertEquals(100, account.getTransactions().get(0).getAmount());
        assertEquals(50, account.getTransactions().get(1).getAmount());
        assertEquals(-30, account.getTransactions().get(2).getAmount());
    }
}

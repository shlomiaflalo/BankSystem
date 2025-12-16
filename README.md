# 🏦 SkyPay Banking System

A clean and minimal **Java banking system** that demonstrates **object-oriented design**, **exception handling**, and **unit testing with JUnit 5**.

This project models a simple bank account with support for deposits, withdrawals, transaction history, and client profiles — built with **best practices in mind**.

---

## ✨ Features

✔ Client profile management  
✔ Account creation and balance tracking  
✔ Deposit & withdrawal operations  
✔ Transaction history with running balance  
✔ Input validation & custom exceptions  
✔ Thread-safe transaction storage  
✔ Fully unit-tested with JUnit 5  

---

## 🧠 Design Overview

### 🔹 Person (Abstract Class)
- Base class for people in the system
- Stores shared attributes:
  - `firstName`
  - `lastName`
  - `age`
- Implements `equals()` and `hashCode()` correctly for inheritance

### 🔹 Client
- Extends `Person`
- Represents a bank customer
- Automatically records account opening date

### 🔹 Account
- Final class that implements `AccountService`
- Manages:
  - Balance
  - Transactions
  - Client ownership
- Uses `CopyOnWriteArrayList` for thread-safe transaction storage

### 🔹 Transaction
- Immutable record of a single account operation
- Stores:
  - Transaction date
  - Amount
  - Resulting balance

---

## 🛡 Validation & Error Handling

The system protects against invalid operations:

- ❌ Depositing zero or negative amounts
- ❌ Withdrawing more than available balance

These rules are enforced using a custom exception:

## 🧪 Testing

The project includes **JUnit 5 unit tests** that:

✔ Verify balance updates  
✔ Ensure transactions are recorded correctly  
✔ Prevent invalid operations  
✔ Validate transaction ordering  

### Example Test

```java
@Test
void deposit_shouldIncreaseBalanceAndAddTransaction() {
    account.deposit(100);

    assertEquals(100, account.getBalance());
    assertEquals(1, account.getTransactions().size());
}
```

Built with passion and attention to detail.
Shukran for choosing SkyPay ☁️💳

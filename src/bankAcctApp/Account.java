/* Phase III */

package bankAcctApp;

import java.util.ArrayList;

// Abstract class defining the structure for account types
public abstract class Account implements AccountInterface {
    private String accountNumber;  // Account number for each account
    private String accountType;    // Type of account (CHK or SAV)
    private double svcFee;         // Service fee for transactions
    private double interestRate;   // Interest rate for the account
    private double overDraftFee;   // Overdraft fee for checking accounts
    private double balance = 0.00; // Initial balance of the account

    // Transaction history stored as strings
    private ArrayList<String> transactionHistory = new ArrayList<>();

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter for account number
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter for account type
    public String getAccountType() {
        return accountType;
    }

    // Setter for account type
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    // Getter for service fee
    public double getSvcFee() {
        return svcFee;
    }

    // Setter for service fee
    public void setSvcFee(double svcFee) {
        this.svcFee = svcFee;
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Setter for interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Getter for overdraft fee
    public double getOverDraftFee() {
        return overDraftFee;
    }

    // Setter for overdraft fee
    public void setOverDraftFee(double overDraftFee) {
        this.overDraftFee = overDraftFee;
    }

    // Getter for account balance
    public double getBalance() {
        return balance;
    }

    // Setter for account balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter for transaction history
    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Method to log a transaction and store it in the transaction history
    public String logTransaction(String date, String type, double amount) {
        String transaction = String.format(
            "Date: %s | Type: %s | Amount: $%.2f | Balance: $%.2f",
            date, type, amount, this.balance
        );
        transactionHistory.add(transaction); // Add transaction to history
        return transaction; // Return the formatted transaction string
    }

    // Abstract method for withdrawals, to be implemented in subclasses
    public abstract void withdrawal(double amount);

    // Abstract method for deposits, to be implemented in subclasses
    public abstract void deposit(double amount);

    // Abstract method for applying accrued interest
    public abstract double applyAccruedInterest(String transactionDate);
}
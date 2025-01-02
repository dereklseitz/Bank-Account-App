/* Phase III */

package bankAcctApp;

// Class representing savings accounts
public class SavingsAccount extends Account {

    // Overridden method for withdrawals in savings accounts
    @Override
    public void withdrawal(double amount) {
        if (getBalance() >= amount + getSvcFee()) { // Ensure sufficient balance
            setBalance(getBalance() - amount - getSvcFee()); // Deduct amount and service fee
        } else {
            throw new IllegalArgumentException("Insufficient funds for withdrawal. Savings accounts cannot overdraft.");
        }
    }

    // Overridden method for deposits in savings accounts
    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount - getSvcFee()); // Add amount and deduct service fee
    }

    // Overridden method for applying accrued interest in savings accounts
    @Override
    public double applyAccruedInterest(String transactionDate) {
        if (getBalance() <= 0) { // Ensure balance is positive for interest accrual
            throw new IllegalArgumentException("The account has an insufficient balance for interest to apply.");
        }
        double interest = getBalance() * (getInterestRate() / 100); // Calculate interest
        setBalance(getBalance() + interest); // Add interest to the balance
        logTransaction(transactionDate, "INT", interest); // Log the interest transaction
        return interest;
    }

    // Implementation of balance() method from AccountInterface
    @Override
    public double balance() {
        return getBalance(); // Return the current balance
    }
}
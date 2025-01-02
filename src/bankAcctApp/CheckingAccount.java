/* Phase IV */

package bankAcctApp;

//Class representing checking accounts
public class CheckingAccount extends Account {

    // Overridden method for withdrawals in checking accounts
    @Override
    public void withdrawal(double amount) {
        double newBalance = getBalance() - amount - getSvcFee(); // Deduct amount and service fee
        if (newBalance < 0) { // Check for overdraft
            newBalance -= getOverDraftFee(); // Apply overdraft fee if balance is negative
        }
        setBalance(newBalance); // Update balance
    }
   
    // Overridden method for deposits in checking accounts
    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount - getSvcFee()); // Add amount and deduct service fee
    }
   
    // Overridden method for applying accrued interest in checking accounts
    @Override
    public double applyAccruedInterest(String transactionDate) {
        double interest = 0.0;
        if (getBalance() <= 0.0) { // Ensure balance is positive for interest accrual
            System.out.println("This account has an insufficient balance for interest to apply.");
        } else {
               interest = getBalance() * (getInterestRate() / 100); // Calculate interest
               setBalance(getBalance() + interest); // Add interest to the balance
               logTransaction(transactionDate, "INT", interest); // Log the interest transaction
        }
        return interest;
    }
    // Implementation of balance() method from AccountInterface
    @Override
    public double balance() {
        return getBalance(); // Return the current balance
    }
   }
   
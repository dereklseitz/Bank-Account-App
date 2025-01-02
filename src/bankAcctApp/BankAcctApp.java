/* Phase III */

package bankAcctApp;

import java.util.ArrayList;

public class BankAcctApp {
	
    public static void main(String[] args) {
        
    	ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        boolean moreCustomers = true;

        // Add customers and accounts
        while (moreCustomers) {
            Customer customer = new Customer();
            Account account = null;
            int inputCount = 0;

            System.out.println("Enter details for new customer:\n");

            // Collect and validate customer ID
            while (inputCount == 0) {
                try {
                    customer.setID(DataEntry.inputStringWithLimit("Customer ID (max 5 chars): ", 5));
                } catch (IllegalArgumentException e) {
                    System.out.println("Customer ID must be 5 alphanumeric characters only. Try again.");
                    continue; // retry input if invalid
                }
                inputCount++;
            }

            // Collect and validate SSN
            while (inputCount == 1) {
                try {
                    customer.setSSN(DataEntry.inputNumericString("SSN (9 numeric chars): ", 9));
                } catch (IllegalArgumentException e) {
                    System.out.println("SSN must be exactly 9 digits. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Last Name
            while (inputCount == 2) {
                try {
                    customer.setLastName(DataEntry.inputStringWithLimit("Last Name (max 20 chars): ", 20));
                } catch (IllegalArgumentException e) {
                    System.out.println("Last Name must not contain numbers or special characters. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate First Name
            while (inputCount == 3) {
                try {
                    customer.setFirstName(DataEntry.inputStringWithLimit("First Name (max 15 chars): ", 15));
                } catch (IllegalArgumentException e) {
                    System.out.println("First Name must not contain numbers or special characters. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Street Address
            while (inputCount == 4) {
                try {
                    customer.setStreet(DataEntry.inputStringWithLimit("Street (max 20 chars): ", 20));
                } catch (IllegalArgumentException e) {
                    System.out.println("Street must be no more than 20 valid characters. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate City
            while (inputCount == 5) {
                try {
                    customer.setCity(DataEntry.inputStringWithLimit("City (max 20 chars): ", 20));
                } catch (IllegalArgumentException e) {
                    System.out.println("City must not contain numbers or special characters. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate State
            while (inputCount == 6) {
                try {
                    customer.setState(DataEntry.inputStringWithLimit("State (2 chars): ", 2));
                } catch (IllegalArgumentException e) {
                    System.out.println("State must be 2 letters only. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate ZIP code
            while (inputCount == 7) {
                try {
                    customer.setZip(DataEntry.inputNumericString("Zip (5 numeric chars): ", 5));
                } catch (IllegalArgumentException e) {
                    System.out.println("Zip must be exactly 5 digits. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Phone Number
            while (inputCount == 8) {
                try {
                    customer.setPhone(DataEntry.inputNumericString("Phone (10 numeric chars): ", 10));
                } catch (IllegalArgumentException e) {
                    System.out.println("Phone number must be 10 digits only. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Add customer instance to customers ArrayList
            customers.add(customer);

            // Collect and validate Account Type
            while (inputCount == 9) {
                try {
                    String accountType = DataEntry.inputStringWithLimit("Account type ('CHK' or 'SAV' only): ", 3).toUpperCase();
                    if (accountType.equals("CHK")) {
                        account = new CheckingAccount();
                        account.setAccountType("CHK");
                    } else if (accountType.equals("SAV")) {
                        account = new SavingsAccount();
                        account.setAccountType("SAV");
                    } else {
                        throw new IllegalArgumentException("Account type must be 'CHK' or 'SAV'.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Account Number
            while (inputCount == 10) {
                try {
                    account.setAccountNumber(DataEntry.inputNumericString("Account Number (5 numeric chars): ", 5));
                } catch (IllegalArgumentException e) {
                    System.out.println("Account number must be exactly 5 digits. Try again.");
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Service Fee Amount
            while (inputCount == 11) {
                try {
                    account.setSvcFee(DataEntry.inputDecimalInRange("Service Fee (0.00 to 10.00): $", 0.00, 10.00));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Interest Rate Amount
            while (inputCount == 12) {
                try {
                    account.setInterestRate(DataEntry.inputDecimalInRange("Interest Rate (0.0% to 10.0%): ", 0.0, 10.0));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Overdraft Fee Amount
            while (inputCount == 13) {
                try {
                    account.setOverDraftFee(DataEntry.inputDecimal("Overdraft Fee (dollars and cents): $"));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                inputCount++;
            }

            // Collect and validate Starting Balance
            while (inputCount == 14) {
                try {
                    account.setBalance(DataEntry.inputDecimal("Starting Balance (dollars and cents): $"));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                inputCount++;
            }

            // Add account instance to accounts ArrayList
            accounts.add(account);

            // Ask if more customers should be added
            String more = DataEntry.inputStringWithLimit("\nAdd another customer? (y/n): ", 1);
            moreCustomers = more.equalsIgnoreCase("y");
            System.out.println();
        }

    // Handle transactions
        boolean addTransactionDetails = true;
    // Start do-while loop add transaction details to any accounts
        do {
            String promptAddTransactions = DataEntry.inputStringWithLimit("Would you like to enter transaction details for an account? (y/n): ", 1).toUpperCase();
            if (!promptAddTransactions.equals("Y") && !promptAddTransactions.equals("N")) {
                System.out.println("Please enter 'Y' or 'N' only.");
                continue;  // Prompt again if invalid input
            } else if (promptAddTransactions.equalsIgnoreCase("N")) {
                addTransactionDetails = false;  // Exit the loop and proceed to report generation
            } else if (promptAddTransactions.equalsIgnoreCase("Y")) {
                boolean addTransactionsToAcct = true;
            // Start do-while loop to add transaction entries to a specified account
                do {
                    // Prompt for account number
                    String accountNumber = DataEntry.inputNumericString("Enter Account Number (5 digits): ", 5);

                    // Find account and corresponding customer
                    Account selectedAccount = null;
                    Customer selectedCustomer = null;

                    for (int i = 0; i < accounts.size(); i++) {
                        if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                            selectedAccount = accounts.get(i);
                            selectedCustomer = customers.get(i);
                            break;
                        }
                    }

                    if (selectedAccount == null) {
                        System.out.println("Account not found. Please try again.\n");
                        continue;  // Prompt for account number again if not found
                    }

                    // Display customer details for verification
                    System.out.println("Customer Information:");
                    System.out.println(selectedCustomer);

                    // Add transactions for the selected account
                    boolean newTransaction = true;
                    // Start do-while loop for "newTransactions
                    do {
                        String transaction = null;
                        int transactionStep = 0;
                        String transactionType = "";
                        String transactionDate = "";

                        try {
                            while (transactionStep == 0) {
                                transactionType = DataEntry.inputStringWithLimit("\nTransaction Type ('DEP', 'WTH', or 'INT'): ", 3).toUpperCase();
                                if (!transactionType.equals("DEP") && !transactionType.equals("WTH") && !transactionType.equals("INT")) {
                                    System.out.println("Invalid transaction type. Please try again.");
                                } else {
                                    transactionStep++;
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Type must be 'DEP', 'WTH', or 'INT' only. Try again");
                        }

                        while (transactionStep == 1) {
                            transactionDate = DataEntry.inputDate("Enter the transaction date (MM/DD/YYYY): ");
                            transactionStep++;
                        }

                        while (transactionStep == 2) {
                            double amount = 0;
                            if (!transactionType.equals("INT")) {
                                amount = DataEntry.inputDecimal("Transaction Amount: $");
                            }

                            try {
                                if (transactionType.equals("DEP")) {
                                    selectedAccount.deposit(amount);
                                    transaction = selectedAccount.logTransaction(transactionDate, "DEP", amount);
                                } else if (transactionType.equals("WTH")) {
                                    selectedAccount.withdrawal(amount);
                                    transaction = selectedAccount.logTransaction(transactionDate, "WTH", amount);
                                } else if (transactionType.equals("INT")) {
                                    double interest = selectedAccount.applyAccruedInterest(transactionDate);
                                    transaction = selectedAccount.logTransaction(transactionDate, "INT", interest);
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                            System.out.println(transaction + "\n");
                        
                        // Ask if another transaction should be entered for this account
	                        String anotherNewTransaction = DataEntry.inputStringWithLimit("Add another transaction for this account? (y/n): ", 1);
	                            if (!anotherNewTransaction.equalsIgnoreCase("N") && !anotherNewTransaction.equalsIgnoreCase("Y")) {
	                            	System.out.println("Please enter 'Y' or 'N' only.");
	                            	continue;
	                            }else if (anotherNewTransaction.equalsIgnoreCase("N")) {
	                            	newTransaction = false;
	                            	break;
	                            }else if (anotherNewTransaction.equalsIgnoreCase("Y")) {
	                            	transactionStep = 0;
	                            }
                        }
                    }while (newTransaction);
                    
                    // Ask if another account's transactions should be entered
                    String otherAcctTransactions = DataEntry.inputStringWithLimit("Enter transactions for another account? (y/n): ", 1);
                    if (!otherAcctTransactions.equalsIgnoreCase("N") && !otherAcctTransactions.equalsIgnoreCase("y")) {
                    	System.out.println("Please enter 'Y' or 'N' only.");
                    	continue;
                    } else if (otherAcctTransactions.equalsIgnoreCase("N")) {
                    	addTransactionsToAcct = false;
                    	break;
                    }
                } while (addTransactionsToAcct); 
            }
        } while (addTransactionDetails);
            
        
    
        // Generate final report (this part should be in your existing code)
        System.out.println("\n------------------------------|Final Report|-------------------------------");
        for (int i = 0; i < accounts.size(); i++) {
            Customer customer = customers.get(i);
            Account account = accounts.get(i);

            System.out.println(customer); 

            System.out.println("Account Details:");
            System.out.println(account);

            System.out.println("Transactions:");
            for (String transaction : account.getTransactionHistory()) {
                System.out.println(transaction);
            }
            System.out.println("------------------------------|End Report|-------------------------------");
        }
    }
}
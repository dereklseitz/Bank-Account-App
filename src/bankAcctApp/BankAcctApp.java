/* Phase II */

package bankAcctApp;

import java.util.ArrayList;
import java.util.InputMismatchException;


public class BankAcctApp {

	public static void main(String[] args) {
	
	// Create ArrayLists for the Customer and Account classes. Each ArrayList will store the instances 
	// created of its respective class, appending each new instance to the end of the list.
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        boolean moreCustomers = true;
       
// Create the loop that keeps adding Customer and Account instances until
// the user chooses to quit.
        while (moreCustomers) {
        	
        // Create instances of the both the Customer and Account classes.
        // These will be stored in their respective class' ArrayList.
        	Customer customer = new Customer();
            Account account = new Account();
        	
// Customer Information:     
            System.out.println("Enter details for new customer:\n");
       
       // Collect and validate user input for Customer ID info.
            try {
            	customer.setID(DataEntry.inputStringWithLimit("Customer ID (max 5 chars): ", 5));
            } catch (IllegalArgumentException e){
            	System.out.println("Customer ID must be 5 alphanumeric characters only. Try again.");
            }
            
       // Collect and validate user input for Social Security Number (SSN).    
            try {
            	customer.setSSN(DataEntry.inputNumericString("SSN (9 numeric chars): ", 9));
            } catch (IllegalArgumentException e) {
            	System.out.println("SSN must be exactly 9 digits. Try again.");
            }
            
       // Collect and validate user input for Last Namee.
            try {
            	customer.setLastName(DataEntry.inputStringWithLimit("Last Name (max 20 chars): ", 20));
            } catch (IllegalArgumentException e) {
            	System.out.println("Last Name must not contain numbers (0-9) or special characters "
            		+ "(!@#$%^&*(){}[]|). Try again.");
            }
        
        // Collect and validate user input for First Name.
            try {
            	customer.setFirstName(DataEntry.inputStringWithLimit("First Name (max 15 chars): ", 15));
            } catch (IllegalArgumentException e) {
            	System.out.println("First Name must not contain numbers (0-9) " 
            			+ "or special characters (!@#$%^&*(){}[]|). Try again.");
            }
            
            
        // Collect and validate user input for Street Address.
            try {
            	customer.setStreet(DataEntry.inputStringWithLimit("Street (max 20 chars): ", 20));
            } catch (IllegalArgumentException e) {
            	System.out.println("Street must be no more than 20 characters consisting of "
            			+ "numbers, letters, spaces, and \" . , - ' \". Try again.");
            }
            
        // Collect and validate user input for City.
            try {
            	customer.setCity(DataEntry.inputStringWithLimit("City (max 20 chars): ", 20));
            } catch (IllegalArgumentException e) {
            	System.out.println("City must not contain numbers (0-9) or special characters "
                   		+ "(!@#$%^&*(){}[]|). Try again.");
            }
            	
        // Collect and validate user input for State.
            try {
            	customer.setState(DataEntry.inputStringWithLimit("State (2 chars): ", 2));
            } catch (InputMismatchException e) {
            	System.out.println("State must be 2 letters only. Try again.");
            }
            	
        // Collect and validate user input for Zip Code.
            try {	
            	customer.setZip(DataEntry.inputNumericString("Zip (5 numeric chars): ", 5));
            } catch (NumberFormatException e) {
            	System.out.println("Zip Code must only contain 5 digits. Try again.");
            }
            	
        // Collect and validate user input for Phone Number.
            try {	
            	customer.setPhone(DataEntry.inputNumericString("Phone (10 numeric chars): ", 10));
            } catch (NumberFormatException e) {
            	System.out.println("Phone Number must only contain 9 digits.");
            }
   	    
// Store Customer information to the Customer instance.
            customers.add(customer);
             
// Account Information:    
        // Collect and validate user input for Account Number.
            try {	
            	account.setAccountNumber(DataEntry.inputNumericString("Account Number (5 numeric chars): ", 5));
            } catch (NumberFormatException e) {
            	System.out.println("Account Number can only be 5 digits. Try again.");
            }
          
        // Collect and validate user input for Account Type.
            try {
                boolean validAcctType = false;
                while (!validAcctType) {
                    String input = DataEntry.inputStringWithLimit("Account type ('CHK' or 'SVG' only): ", 3);
                    
                    if (input.equalsIgnoreCase("CHK") || input.equalsIgnoreCase("SAV")) {
                        account.setAccountType(input.toUpperCase());
                        validAcctType = true;
                    } else {
                        System.out.println("Input for Account Type can only be 'CHK' or 'SVG'. Try again.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
            }
	            
        // Collect and validate user input for Service Fee.
            try {
            	account.setSvcFee(DataEntry.inputDecimalInRange("Service Fee Amount (in dollars and cents): $", 0.00, 10.00));
            } catch (InputMismatchException e) {
            	System.out.println("Input must be a dollar amount between $0.00 - $10.00. Try again.");
            }
	            
        // Collect and validate user input for Interest Rate.
            try {
            	account.setInterestRate(DataEntry.inputDecimalInRange("Interest Rate (percent between 0.0% and 10.0%: ", 0.0, 10.0));
            } catch (InputMismatchException e) {
            	System.out.println("Interest Rate must be entered as a decimial between 0.0% - 10.0%. Try again.");
            }
	            
        // Collect and validate user input for Overdraft Fee.
            try {
            	account.setOverDraftFee(DataEntry.inputDecimal("Overdraft Fee Amount (in dollars and cents): $"));
            } catch (InputMismatchException e) {
            	System.out.println("Input must be a dollar amount between $0.00 and $10.00");
            }
	            
        // Collect and validate user input for Current Balance.
            try {
            	account.setBalance(DataEntry.inputDecimal("Starting Balance (in dollars and cents): $"));
            } catch (InputMismatchException e) {
            	System.out.println("Current Balance must be in dollars and cents. Try again.");
            }
	            
// Add the Account class instance to the accounts ArrayList        
            accounts.add(account);
	            
// Prompt user to add additional customers or quit.
	        String more = DataEntry.inputStringWithLimit("\nAdd another customer? (y/n): ", 1);
            if (more.equalsIgnoreCase("n")) {
                moreCustomers = false;
            }
        }

// Print out the results so that each Customer instance and its corresponding Account instance are 
// printed together, and so the program iterates through all of the instance pairs in their respective ArrayLists.
        System.out.println("\n========================================\n");
        for (int i = 0; i < customers.size(); i++) {
        
        // Use [int i] for both ArrayLists to ensure the correct Accounts instance is 
        // printed with the corresponding Customer instance.
            Customer customer = customers.get(i);
            Account account = accounts.get(i);

            System.out.println(customer + "\n");
            System.out.println(account);
            System.out.println("---------------------------------------------------------" 
            		+ "----------------------------------------------------------------------------");
            
        }
    }
}

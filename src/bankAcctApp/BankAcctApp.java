package bankAcctApp;

import java.util.ArrayList;
import java.util.List;

public class BankAcctApp {

	public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        boolean moreCustomers = true;

        while (moreCustomers) {
            Customer customer = new Customer();
            System.out.println("Enter details for new customer:\n");

            customer.setID(DataEntry.inputStringWithLimit("Customer ID (max 5 chars): ", 5));
            customer.setSSN(DataEntry.inputNumericString("SSN (9 numeric chars): ", 9));
            customer.setLastName(DataEntry.inputStringWithLimit("Last Name (max 20 chars): ", 20));
            customer.setFirstName(DataEntry.inputStringWithLimit("First Name (max 15 chars): ", 15));
            customer.setStreet(DataEntry.inputStringWithLimit("Street (max 20 chars): ", 20));
            customer.setCity(DataEntry.inputStringWithLimit("City (max 20 chars): ", 20));
            customer.setState(DataEntry.inputStringWithLimit("State (2 chars): ", 2));
            customer.setZip(DataEntry.inputNumericString("Zip (5 numeric chars): ", 5));
            customer.setPhone(DataEntry.inputNumericString("Phone (10 numeric chars): ", 10));

            customers.add(customer);

            String more = DataEntry.inputStringWithLimit("\nAdd another customer? (y/n): ", 1);
            if (!more.equalsIgnoreCase("y")) {
                moreCustomers = false;
            }
        }

        System.out.println("\nCustomer Information:");
	    System.out.println("========================================");
        for (Customer c : customers) {
            System.out.println(c);
        }
    }
}
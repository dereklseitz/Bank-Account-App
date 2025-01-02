package bankAcctApp;

import java.util.Scanner;
import java.util.regex.*;

public class DataEntry {
	private static Scanner in = new Scanner(System.in);

// Static method to validate a string without a limit.
    public static String inputString(String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }
    
// Static method to validate a string with a limit.
	public static String inputStringWithLimit(String prompt, int maxLength) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine();
            if (input == "" || input.length() > maxLength) {
                System.out.println("Invalid input. Must be non-blank and up to " 
                		+ maxLength + " characters.");
            }
        } while (input == "" || input.length() > maxLength);
        return input;
    }

// Static method to validate a numeric-only string without a limit.
    public static String inputNumericString(String prompt, int length) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine();
            if (!input.matches("\\d+")) {
                System.out.println("Invalid input. Must only be numeric characters.");
            }
        } while (!input.matches("\\d+"));
        return input;
    }

// Static method to validate Integers.
    public static int inputInteger(String prompt) {
    	int input = 0;
    	boolean isValid = false;
    	System.out.print(prompt);
    	do {
    		if (in.hasNextInt()) {
    			input = in.nextInt();
    			isValid = true;
    		} else {
    			System.out.print("Invalid entry. Try again: ");
    			in.nextLine();
    		}
    	} while (!isValid);
    	return input;	
    }
    
// Static method to validate Integers within a range.
    public static int inputIntegerInRange(String prompt, int min, int max) {
    	int input = (min - 1);
    	do {
    		input = inputInteger(prompt);
    		if (input < min || input > max) {
    			System.out.print("Invalid input. Try again: ");
    		} 
    	} while (input < min || input > max);
    	return input;
    }
    
// Static method to validate decimals.
    public static double inputDecimal(String prompt) {
        boolean isValid = false;
        double decimalValue = 0.0;
        System.out.print(prompt);
        do {
        	if (in.hasNextDouble()) {
        		decimalValue = in.nextDouble();
        		isValid = true;
            } else{
                System.out.println("Invalid input. Please enter a valid decimal number.");
                in.next();
            }
        } while (!isValid);
        return decimalValue;
    }
   
// Static method to validate decimals within a range.    
    public static double inputDecimalInRange(String prompt, double min, double max) {
        double value;
        do {
            value = inputDecimal(prompt);
            if (value < min || value > max) {
                System.out.println("Invalid input. Must be between " 
                		+ min + " and " + max + ".");
            }
        } while (value < min || value > max);
        return value;
    }
    
// Static method to validate a date in MM/DD/YYYY format.
    public static String inputDate(String prompt) {
    	Pattern patternDate = Pattern.compile("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})$");
    	String date = "";
    	System.out.print(prompt);
    	do {
    		String input = in.nextLine();
    		if (patternDate.matcher(input).matches()) {
    			return input;
    		} else {
    			System.out.print("Invalid date. Please try again: ");
      		}
    	} while (date == "");
    	return date;
    }
}

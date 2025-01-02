/* Phase IV */

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
            if (input.isBlank() || input.length() > maxLength) {
                System.out.println("Invalid input. Must be non-blank and up to " 
                		+ maxLength + " characters.");
            }
        } while (input.isBlank() || input.length() > maxLength);
        return input;
    }

// Static method to validate a numeric-only string without a limit.
    public static String inputNumericString(String prompt, int length) {
        String input;
        do {
            System.out.print(prompt);
            input = in.nextLine();
            if (!input.matches("\\d{" + length + "}")) {
                System.out.println("Invalid input. Must be exactly " + length + " numbers.");
            }
        } while (!input.matches("\\d{" + length + "}"));
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
    			in.next();
    		}
    		in.nextLine();
    	} while (!isValid);
    	return input;	
    }
    
// Static method to validate Integers are within a range.
    public static int inputIntegerInRange(String prompt, int min, int max) {
    	int input = (min - 1);
    	do {
    		input = inputInteger(prompt);
    		if (input < min || input > max) {
    			System.out.print("Invalid input. Try again: ");
    			in.next();
    		} 
    		in.nextLine();
    	} while (input < min || input > max);
    	return input;
    }
    
// Static method to validate decimals (specific to the CLI)
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
        	in.nextLine();
        } while (!isValid);
        return decimalValue;
    }
   
// Static method to validate decimals are within a range (specific to the CLI)    
    public static double inputDecimalInRange(String prompt, double min, double max) {
        double value;
        do {
            value = inputDecimal(prompt);
            if (value < min || value > max) {
                System.out.println("Invalid input. Must be between " 
                		+ min + " and " + max + ".");
                in.next();
            }
        } while (value < min || value > max);
        return value;
    }
    
    
// Static method to validate a date in MM/DD/YYYY format.
    public static String inputDate(String prompt) {
    	Pattern patternDate = Pattern.compile("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/(\\d{4})$");
    	String date = "";
    	System.out.print(prompt);
    	while (date.isEmpty()) {
    		String input = in.nextLine();
    		if (patternDate.matcher(input).matches()) {
    			date = input;
    			return date;
    		} else {
    			System.out.print("Invalid date. Please try again: ");
    		}
    	}
    	return date;
    }


// Validation methods specific to the GUI
    // Reusable patterns for string v   // Reusable patterns for string validation (no prompt messages, just validation)
    private static final Pattern patternID = Pattern.compile("[A-Z0-9]{5}");
    private static final Pattern patternSSN = Pattern.compile("[0-9]{9}");
    private static final Pattern patternName = Pattern.compile("[A-Za-z\\s,\\.\\-']{1,20}");
    private static final Pattern patternStreet = Pattern.compile("[0-9]+[A-Za-z\\s,\\.\\-]{1,19}");
    private static final Pattern patternCity = Pattern.compile("[A-Za-z\\s]{1,20}");
    private static final Pattern patternState = Pattern.compile("[A-Z]{2}");
    private static final Pattern patternZip = Pattern.compile("[0-9]{5}");
    private static final Pattern patternPhone = Pattern.compile("[0-9]{10}");

    // Validate input for strings using regex (for GUI)
    private static void validateInput(Pattern pattern, String input) {
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException("Invalid input: " + input);
        }
    }

    // Validate and convert string input to double
    private static double validateAndConvertToDouble(String input) {
        try {
            return Double.parseDouble(input); // Convert to double
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid decimal input: " + input);
        }
    }

    // Validate and convert decimal numbers for account information within a range (for GUI)
    public static double inputDecimalInRangeGUI(String input, double min, double max) {
        double value = validateAndConvertToDouble(input);  // Validate as double
        if (value < min || value > max) {
            throw new IllegalArgumentException("Value out of range: " + value);
        }
        return value;
    }

    // Validate decimal input (no range validation)
    public static double inputDecimalGUI(String input) {
        return validateAndConvertToDouble(input); // Simply convert the valid decimal input
    }

    // Field-specific validation methods for GUI

    public static void inputIDGUI(String id) {
        validateInput(patternID, id); // Validate ID format
    }

    public static void inputSSNGUI(String ssn) {
        validateInput(patternSSN, ssn); // Validate SSN format
    }

    public static void inputLastNameGUI(String lastName) {
        validateInput(patternName, lastName); // Validate last name format
    }

    public static void inputFirstNameGUI(String firstName) {
        validateInput(patternName, firstName); // Validate first name format
    }

    public static void inputStreetGUI(String street) {
        validateInput(patternStreet, street); // Validate street format
    }

    public static void inputCityGUI(String city) {
        validateInput(patternCity, city); // Validate city format
    }

    public static void inputStateGUI(String state) {
        validateInput(patternState, state); // Validate state format
    }

    public static void inputZipGUI(String zip) {
        validateInput(patternZip, zip); // Validate zip format
    }

    public static void inputPhoneGUI(String phone) {
        validateInput(patternPhone, phone); // Validate phone format
    }

    // For numeric string validation (e.g., for account number)
    public static void inputNumericStringGUI(String input, int length) {
        if (input.length() != length || !input.matches("[0-9]+")) {
            throw new IllegalArgumentException("Invalid numeric input. Must be " + length + " digits.");
        }
    }
}
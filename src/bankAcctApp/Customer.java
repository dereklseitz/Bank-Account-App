/* Phase II */

package bankAcctApp;

public class Customer {
	
	private String id;			
	private String ssn;			
	private String lastName;	
	private String firstName;	
	private String street;		
	private String city; 		
	private String state;		
	private String zip;			
	private String phone;
	
	
// Getter and Setter for Customer ID info.	
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}

	
// Getter and Setter for Customer SSN info.
	public String getSSN() {
		return ssn;
	}
	public void setSSN(String ssn) {
		this.ssn = ssn; 
	}

	
// Getter and Setter for Customer Last Name.
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
// Getter and Setter for Customer First Name.
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
// Getter and Setter for Customer Street Address.	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
// Getter and Setter for Customer City.	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
// Getter and Setter for Customer State.	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
// Getter and Setter for Customer ZIP.	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
// Getter and Setter for Customer Phone Number.
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
// Override the toString() method that is inherited by default from Java's Object class.
// Then use the custom-written toString() method to return Customer Info
@Override
	public String toString() {
    	return String.format(
    		"Customer Information:\n" +
        		"---------------------\n" +
        	"ID:     Last Name:             First Name:       SSN:        Phone:      Street:                City:             ST:    ZIP:     \n" +
        	"---     ----------             -----------       ----        ------      -------                -----             ---    ----    \n" +
        	"%-7s %-22s %-17s %-11s %-11s %-22s %-17s %-6s %-7s",
        	id, lastName, firstName, ssn, phone, street, city, state, zip
    	);
	}
}

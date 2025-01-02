/* Phase II */

package bankAcctApp;

public class Account {
	
	private String accountNumber;
	private String accountType;
	private Double svcFee;
	private Double interestRate;
	private Double overDraftFee;
	private Double balance = 0.00;

	
// Getter and Setter for Account Number info.	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
// Getter and Setter for Customer ID info.	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
// Getter and Setter for Service Fee info.	
	public Double getSvcFee() {
		return svcFee;
	}
	public void setSvcFee(Double svcFee) {
		this.svcFee = svcFee;
	}
	
	
// Getter and Setter for Interest Rate info.
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	
	
// Getter and Setter for Overdraft Fee info.	
	public Double getOverDraftFee() {
		return overDraftFee;
	}
	public void setOverDraftFee(Double overDraftFee) {
		this.overDraftFee = overDraftFee;
	}

	
// Getter and Setter for Balance info.	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
// Override the toString() method that is inherited by default in Java.
// Then use the custom-written toString() method to return Account Info
@Override     
	public String toString() {
	    return String.format(
	        "Acct#:   Type:    Svc Fee:    Int Rate:    Ovdft Fee:    Balance:  \n" +
	        "------   -----    --------    ---------    ----------    --------  \n" +
	        "%-8s %-8s $%-10.2f %-12.1f $%-12.2f $%-9.2f",
	        accountNumber, accountType, svcFee, interestRate, overDraftFee, balance
	    );
	}
}
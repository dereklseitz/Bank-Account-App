/* Phase III */

package bankAcctApp;

public interface AccountInterface {
	void withdrawal(double amount);
	void deposit(double amount);
	double applyAccruedInterest(String date);
	double balance();
}
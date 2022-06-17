import java.util.ArrayList;
import java.util.Arrays;

public class BankTest
{
	
    public static void main(String[] args)
	{
    BankAccount account= new BankAccount(3.00, 5.00); //savings on the left and checking on the right
	BankAccount account2= new BankAccount(6.00, 2.00);
    // account.Deposit(1000.00, "checking");	
    // System.out.println(account.viewAccountTotals());
    // account2.Deposit(500.00, "savings");
    // System.out.println(account2.viewAccountTotals());

    //Testing Withdrawal method
    account.Withdraw(1.00, "checking");	
    System.out.println(account.viewAccountTotals());
    account2.Withdraw(2.00, "savings");
    System.out.println(account2.viewAccountTotals());

	}





};

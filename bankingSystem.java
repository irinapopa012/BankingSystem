package bank;

public class BankingSistem {

    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount("121312", "Adriana D.", 145.0, 5.5);
        CheckingAccount checkingAccount = new CheckingAccount("85892", "John W.", 270.0, 100.0);
        savingsAccount.displayAccountInfo();
        System.out.println();
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(60.0);
        System.out.println();
        savingsAccount.displayAccountInfo();
        System.out.println();
        checkingAccount.displayAccountInfo();
  System.out.println();
        checkingAccount.deposit(400.0);
        checkingAccount.withdraw(750.0);
  System.out.println();
        checkingAccount.displayAccountInfo();

    }

}
abstract class BankAccount {
	protected String accountNumber;

   protected String accountHolder;

   protected double balance;


public String getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}

public String getAccountHolder() {
	return accountHolder;
}

public void setAccountHolder(String accountHolder) {
	this.accountHolder = accountHolder;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
public abstract void deposit(double amount);
public abstract void withdraw(double amount);
public abstract void displayAccountInfo();
   
   
}


class SavingsAccount extends BankAccount
{   protected double interestRate;
	public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.interestRate=interestRate;
	}
	
 
	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	@Override
	public void deposit(double amount) {
	 balance=balance+amount;
	 System.out.println("The amount " + amount + " is now deposited in your Saving account");

	}

	public void withdraw(double amount) {
		
		if(balance>=amount) {
			balance=balance-amount;
		}

		else if(balance<amount)
			System.out.println("Tnsufficient balance");
	}
	

	@Override
	public void displayAccountInfo() {
		System.out.println("Account number " + accountNumber);
		System.out.println("Account Holder " + accountHolder);
		System.out.println("Balance account " + balance);
		System.out.println("Interest Rate Account " + interestRate);
		
	}
	
	
}

class CheckingAccount extends BankAccount{
	protected double overdraftLimit;
	
	public CheckingAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.overdraftLimit=overdraftLimit;
	}
	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public void deposit(double amount) {
		 balance=balance+amount;
		 System.out.println("The amount " + amount + " is now deposited in your Checking Account");
	}

	@Override
	public void withdraw(double amount) {
		
		if(balance+overdraftLimit>=amount)
		{
			if(balance>=amount)
			{
				balance=balance-amount;
				System.out.println("Withdrawn " + amount + " from Checking Account.");

			}
			else 
			{
				double amount1=amount-balance;
				overdraftLimit=overdraftLimit-amount;
				System.out.println("Withdrawn $" + amount + " from Checking Account and you overtake your overdraftLimit with" + amount1);
			}
				
		}
	}

	@Override
	public void displayAccountInfo() {
		System.out.println("Account number " + accountNumber);
		System.out.println("Account Holder " + accountHolder);
		System.out.println("Balance account " + balance);
		System.out.println("OverdraftLimit " + overdraftLimit);
	}
	
}

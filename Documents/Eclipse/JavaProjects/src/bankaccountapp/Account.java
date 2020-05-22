package bankaccountapp;

public abstract class Account implements IBaseRate {
	// list common properties for savings and checking accounts
	private String name, sSN;
	private double balance;
	private static int index = 10000;

	protected String accountNumber;
	protected double rate;
	
	// constructor to set base properties and initialize the account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name;
		this.sSN = sSN;
		this.balance = initDeposit;		
		// set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	// abstract method
	public abstract void setRate();
	
	// setters
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randNumber;
	}
	
	// list of common methods - transactions
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		printBalance();
	}
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		printBalance();
	}
	public void printBalance() {
		System.out.println("Your balance is now: $" + balance);
	}
	public void showInfo() {
		System.out.println("NAME: " + name +
							"\nACCOUNT NUMBER: " + accountNumber +
							"\nBALANCE: " + balance +
							"\nRATE: " + rate + "%");
	}
	
}

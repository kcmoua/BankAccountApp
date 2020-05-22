package bankaccountapp;

public class Savings extends Account {
	// list properties specific to savings account
	private int safetyDepositBoxID, safetyDepositBoxKey;
	
	// constructor to initialize savings account properties
	public Savings(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	// setters
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,  4));
	}
	
	// abstract methods
	@Override
	public void setRate() {
		rate = getBaseRate() - 0.25;
	}
	
	// list methods specific to savings account
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println(" Your Savings Account Features" +
							"\n Safety Deposit Box ID: " + safetyDepositBoxID +
							"\n Safety Deposit Box Key: " + safetyDepositBoxKey);
	}
	
}

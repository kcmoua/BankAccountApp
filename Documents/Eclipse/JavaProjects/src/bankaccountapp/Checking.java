package bankaccountapp;

public class Checking extends Account {
	// list properties specific to checking account
	private int debitCardNumber, debitCardPIN;
	
	// constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	// setters
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	// abstract methods
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	// list methods specific to checking account
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println(" Your Checking Account Features" +
							"\n Debit Card Number: " + debitCardNumber +
							"\n Debit Card PIN: " + debitCardPIN);
	}
	
}

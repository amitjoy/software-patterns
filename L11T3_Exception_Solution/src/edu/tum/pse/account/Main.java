package edu.tum.pse.account;


public class Main {

	public static void handleOverdrawn() {
		System.out.println("overdraw!");
	}
	
	public static void doTheUsualThing() {
		System.out.println("usual thing!");
	}
	
	// main
	public static void main(String[] args) {
	
		// caller
		Account account = new Account(100);
		int amount = 120;
		
		//for checked exception, put the calling statement in a try block
		try {
			//call without testing condition
			account.withdraw(amount); 
			doTheUsualThing();
		}
		//when withdraw fails, an exception will be thrown from inside withdraw()
		catch (BalanceException e) { 
			handleOverdrawn();
		}		

	}

}

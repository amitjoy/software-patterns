package edu.tum.pse.account;

class Account {

	public Account(int amount) {
		_balance = amount;
	}
	
	public Account() {
		_balance = 0;
	}

	public void deposit(int amount) {
		_balance += amount;
	}
	
	public boolean canWithdraw(int amount) {
		return _balance >= amount;
	}
	
	public void withdraw(int amount) 
			throws BalanceException {
		if (amount > _balance)
			throw new BalanceException();
		_balance -= amount;
	}
	
	private int _balance;
	
}



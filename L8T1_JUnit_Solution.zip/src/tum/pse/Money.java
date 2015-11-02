package tum.pse;
class Money {
	private int amount; 
	private String currency;

	public Money(int amount, String currency) {
		this.amount= amount;
		this.currency= currency;
	}

	public int amount() { 
		return amount; 
	}

	public String currency() { 
		return currency; 
	}

	public Money add(Money m) {
		if (this.currency().equals(m.currency)) {
			return new Money(amount() + m.amount(), currency());
		} else {
			throw new NullPointerException();
		}
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money aMoney = (Money)anObject;
			return aMoney.currency().equals(currency) && aMoney.amount() == amount;
		}
		return false;
	}
}
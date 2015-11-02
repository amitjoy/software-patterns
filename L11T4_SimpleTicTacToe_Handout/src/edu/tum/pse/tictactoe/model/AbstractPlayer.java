package edu.tum.pse.tictactoe.model;

public abstract class AbstractPlayer implements Player, Comparable<Object> {
	private String name;
	
	public AbstractPlayer() {
		
	}
	
	public AbstractPlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int hashCode() {
		return getName().hashCode();
	}

	public int compareTo(Object object) {
		if(object != null && AbstractPlayer.class.isAssignableFrom(object.getClass())) {
			final AbstractPlayer other = AbstractPlayer.class.cast(object);
			final String name = getName();
			final String second = other.getName();
			if(name != null) {
				return name.compareTo(second);
			}
		}
		return -1;
	}
	
	public boolean equals(Object o) {
		if(o != null && AbstractPlayer.class.isAssignableFrom(o.getClass())) {
			AbstractPlayer p = AbstractPlayer.class.cast(o);
			final String name = getName();
			final String second = p.getName();
			return name.equals(second);
		}
		return false;
	}
	
	
}

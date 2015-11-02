package edu.tum.cs.l1.pse;

//Example taken from Head First Design Patterns

public abstract class MenuComponent {

	protected String name;
	protected String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void print() {
		throw new UnsupportedOperationException();
	}
}

package edu.tum.cs.i1.pse;

public class Context {
	private SortStrategy sortAlgorithm;
	private int[] array;
	
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public void setSortAlgorithm(SortStrategy sa) {
		sortAlgorithm = sa;
	}
	
	public void sort() {
		sortAlgorithm.performSort(this.array);
	}
}

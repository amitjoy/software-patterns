package edu.tum.cs.i1.pse;

public class Policy {
	private boolean timeIsImportant;
	private boolean spaceIsImportant;
	private Context context;
	
	public Policy(Context context) {
		this.context = context;
	}
	
	public void setTimeIsImportant(boolean timeIsImportant) {
		this.timeIsImportant = timeIsImportant;
	}

	public void setSpaceIsImportant(boolean spaceIsImportant) {
		this.spaceIsImportant = spaceIsImportant;
	}
	
	public boolean isTimeImportant() {
		return timeIsImportant;
	}

	public boolean isSpaceImportant() {
		return spaceIsImportant;
	}
	
	public void configure(boolean timeIsImportant, boolean spaceIsImportant) {
		this.setSpaceIsImportant(spaceIsImportant);
		this.setTimeIsImportant(timeIsImportant);
		if (isTimeImportant() && !isSpaceImportant()) {
			this.context.setSortAlgorithm(new MergeSort());
		} else if (isTimeImportant() && isSpaceImportant()) {
			this.context.setSortAlgorithm(new QuickSort());
		}
	}
}

package edu.tum.cs.i1.L5T2;
public class LowerCCommand extends Command {
	
	public LowerCCommand(TemperatureModel model) {
		this.model = model;
	}

	public void execute() throws IllegalTemperatureException {
		model.setC(model.getC()-1);
	}

	public void redo() throws IllegalTemperatureException {
		model.setC(model.getC()-1);
	}

	public void undo() throws IllegalTemperatureException {
		model.setC(model.getC()+1);
	}
}

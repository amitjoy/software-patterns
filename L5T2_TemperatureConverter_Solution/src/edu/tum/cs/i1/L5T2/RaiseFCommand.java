package edu.tum.cs.i1.L5T2;

public class RaiseFCommand extends Command {
	
	public RaiseFCommand(TemperatureModel model) {
		this.model = model;
	}
	@Override
	public void execute() throws IllegalTemperatureException {
		model.setF(model.getF()+1);
	}

	@Override
	public void redo() throws IllegalTemperatureException {
		model.setF(model.getF()+1);
	}

	@Override
	public void undo() throws IllegalTemperatureException {
		model.setF(model.getF()-1);
	}

}

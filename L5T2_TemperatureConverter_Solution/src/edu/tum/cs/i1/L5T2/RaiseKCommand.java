package edu.tum.cs.i1.L5T2;

public class RaiseKCommand extends Command {
	
	public RaiseKCommand(TemperatureModel model) {
		this.model = model;
	}
	@Override
	public void execute() throws IllegalTemperatureException {
		model.setK(model.getK()+1);
	}

	@Override
	public void redo() throws IllegalTemperatureException {
		model.setK(model.getK()+1);
	}

	@Override
	public void undo() throws IllegalTemperatureException {
		model.setK(model.getK()-1);
	}

}

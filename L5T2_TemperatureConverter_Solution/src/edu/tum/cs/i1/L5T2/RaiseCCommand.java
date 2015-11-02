package edu.tum.cs.i1.L5T2;

public class RaiseCCommand extends Command {
	
	public RaiseCCommand(TemperatureModel model) {
		this.model = model;
	}
	@Override
	public void execute() throws IllegalTemperatureException {
		model.setC(model.getC()+1);
	}

	@Override
	public void redo() throws IllegalTemperatureException {
		model.setC(model.getC()+1);
	}

	@Override
	public void undo() throws IllegalTemperatureException {
		model.setC(model.getC()-1);
	}

}

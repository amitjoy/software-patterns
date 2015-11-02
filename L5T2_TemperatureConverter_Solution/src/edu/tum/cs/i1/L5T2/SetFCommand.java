package edu.tum.cs.i1.L5T2;
public class SetFCommand extends Command {
	private double oldValue;
	private double newValue = -9999;
	
	public SetFCommand(TemperatureModel model) {
		this.model = model;
		oldValue = model.getF();
	}
	@Override
	public void execute() throws IllegalTemperatureException {
		model.setF(newValue);
	}

	@Override
	public void redo() throws IllegalTemperatureException {
		model.setF(newValue);
	}

	@Override
	public void undo() throws IllegalTemperatureException {
		model.setF(oldValue);
	}
	
	public void setFTemperature(double fTemp) {
		newValue = fTemp;
	}
}
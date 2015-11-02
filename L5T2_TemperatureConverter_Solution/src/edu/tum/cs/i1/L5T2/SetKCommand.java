package edu.tum.cs.i1.L5T2;
public class SetKCommand extends Command {
	private double oldValue;
	private double newValue = -9999;
	
	public SetKCommand(TemperatureModel model) {
		this.model = model;
		oldValue = model.getK();
	}
	@Override
	public void execute() throws IllegalTemperatureException {
		model.setK(newValue);
	}

	@Override
	public void redo() throws IllegalTemperatureException {
		model.setK(newValue);
	}

	@Override
	public void undo() throws IllegalTemperatureException {
		model.setK(oldValue);
	}
	
	public void setKTemperature(double kTemp) {
		newValue = kTemp;
	}
}
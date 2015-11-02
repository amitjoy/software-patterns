package edu.tum.cs.lecture1.pse;
public class TemperatureModel extends java.util.Observable {
	public static double KELVIN_CONST = 273.15;

	private double temperatureK = 0.0;
	
	public double getF() {
		return ((temperatureK - KELVIN_CONST) * 9.0 / 5.0) + 32.0 ;
	}

	public double getC() {
		return temperatureK - KELVIN_CONST;
	}
	
	public double getK() {
		return temperatureK;
	}

	public void setF(double tempF) throws IllegalTemperatureException {
		setK((tempF - 32.0) * 5.0 / 9.0 + KELVIN_CONST);
	}

	public void setC(double tempC) throws IllegalTemperatureException {
		setK(tempC + KELVIN_CONST);
	}
	
	public void setK(double tempK) throws IllegalTemperatureException {
		if(tempK < 0) throw new IllegalTemperatureException("Temperature cannot be below absolute zero!");
		temperatureK = tempK;
		setChanged();
		notifyObservers();
	}
}

package edu.tum.cs.pse.meteostat.solution;

public interface IMeteorologicalSensorArray {

	public abstract int getTemperatureData();

	public abstract int getWindspeedData();

	public abstract int getHumidityData();

}
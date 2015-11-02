package edu.tum.cs.pse.meteostat.solution;

import java.io.IOException;

public interface IMeteorologicalStorage {

	public abstract void setTemperature(int temperature);
	public abstract void setWindspeed(int windspeed);
	public abstract void setHumidity(int humidity);
	public abstract void save() throws IOException;
}
package edu.tum.cs.pse.meteostat.exercise;

import java.util.Date;
import java.util.Random;

/**
 * MeteorologicalSensorArray provides us with meteorological data
 */
public class MeteorologicalSensorArray {

	private Random r;

	public MeteorologicalSensorArray() {
		r = new Random((new Date().getTime()));
	}

	public int getTemperatureData() {
		return r.nextInt(41);
	}

	public int getWindspeedData() {
		return r.nextInt(108);
	}

	public int getHumidityData() {
		return r.nextInt(101);
	}
}

package edu.tum.cs.pse.meteostat.solution;

import java.io.IOException;

import com.google.inject.Inject;

public class MeteorologicalStationController {

	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;
	@Inject
	private IMeteorologicalStorage storage;
	@Inject
	private IMeteorologicalSensorArray sensorArray;
	private IMeteorologicalStationGUI gui;

	@Inject
	public MeteorologicalStationController(
			IMeteorologicalStationGUI gui) {
		this.gui = gui;
	}

	public void measure() {
		currentTemperature = sensorArray.getTemperatureData();
		currentWindspeed = sensorArray.getWindspeedData();
		currentHumidity = sensorArray.getHumidityData();
		gui.displayTemperature(currentTemperature);
		gui.displayWindspeed(currentWindspeed);
		gui.displayHumidity(currentHumidity);
	}

	public void save() throws IOException {
		storage.setTemperature(currentTemperature);
		storage.setWindspeed(currentWindspeed);
		storage.setHumidity(currentHumidity);
		storage.save();
	}
}

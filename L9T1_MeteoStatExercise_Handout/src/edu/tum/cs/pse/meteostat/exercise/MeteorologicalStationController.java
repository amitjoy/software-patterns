package edu.tum.cs.pse.meteostat.exercise;

import java.io.IOException;

import com.google.inject.Inject;

/**
 * MeteorologicalStationController contains the application logic and mediates
 * between the model and the view
 */
public class MeteorologicalStationController {

	private IMeteorologicalStationGUI gui;
	private int currentTemperature;
	private int currentWindspeed;
	private int currentHumidity;
	private MeteorologicalFileStorage storage;
	private MeteorologicalSensorArray sensorArray;

	@Inject
	public MeteorologicalStationController(IMeteorologicalStationGUI gui,
			MeteorologicalFileStorage storage,
			MeteorologicalSensorArray sensorArray) {
		this.gui = gui;
		this.storage = storage;
		this.sensorArray = sensorArray;
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

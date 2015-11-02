package edu.tum.cs.pse.meteostat.guiced;

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
	
	// The following instance variables are injected.
	@Inject
	private MeteorologicalFileStorage storage;
	@Inject
	private MeteorologicalSensorArray sensorArray;

	// The constructor is injected.
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

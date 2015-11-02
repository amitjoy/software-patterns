package edu.tum.cs.pse.meteostat.exercise;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.tum.cs.pse.meteostat.module.ConfigurationModule;

/**
 * MeteorologicalStation contains the main method and starts up the application
 */
public class MeteorologicalStation {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ConfigurationModule());
		IMeteorologicalStationGUI msgui = injector.getInstance(MeteorologicalStationGUI.class);
	}
}

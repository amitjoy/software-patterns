package edu.tum.cs.pse.meteostat.guiced;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * MeteorologicalStation contains the main method and starts up the application
 */
public class MeteorologicalStation {
	public static void main(String[] args) {
		
		// Create the injector.
		Injector injector = Guice.createInjector(new ProductionModule());
		
		// Use the injector to get a new instance of the IMeteorologicalStationGUI class.
		@SuppressWarnings("unused")
		IMeteorologicalStationGUI msgui = injector.getInstance(IMeteorologicalStationGUI.class);
	}
}

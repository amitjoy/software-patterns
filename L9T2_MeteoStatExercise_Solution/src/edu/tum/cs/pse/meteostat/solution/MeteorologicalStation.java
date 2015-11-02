package edu.tum.cs.pse.meteostat.solution;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MeteorologicalStation {
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ProductionModule());
		@SuppressWarnings("unused")
		IMeteorologicalStationGUI msgui = injector.getInstance(IMeteorologicalStationGUI.class);
	}
}

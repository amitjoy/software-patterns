package edu.tum.cs.pse.meteostat.solution;

import com.google.inject.Binder;
import com.google.inject.Module;

public class ProductionModule implements Module {

	public void configure(Binder binder) {
		binder.bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
		binder.bind(IMeteorologicalSensorArray.class).to(MeteorologicalSensorArray.class);
		binder.bind(IMeteorologicalStorage.class).to(MeteorologicalFileStorage.class);
	}

}

package edu.tum.cs.pse.meteostat.module;

import com.google.inject.AbstractModule;
import edu.tum.cs.pse.meteostat.exercise.IMeteorologicalStationGUI;
import edu.tum.cs.pse.meteostat.exercise.MeteorologicalFileStorage;
import edu.tum.cs.pse.meteostat.exercise.MeteorologicalSensorArray;
import edu.tum.cs.pse.meteostat.exercise.MeteorologicalStationGUI;

public class ConfigurationModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MeteorologicalFileStorage.class).to(MeteorologicalFileStorage.class);
		bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
		bind(MeteorologicalSensorArray.class).to(MeteorologicalSensorArray.class);
	}

}

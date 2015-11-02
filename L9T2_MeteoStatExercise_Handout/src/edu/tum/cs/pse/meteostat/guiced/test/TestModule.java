package edu.tum.cs.pse.meteostat.guiced.test;

import com.google.inject.AbstractModule;

import edu.tum.cs.pse.meteostat.guiced.IMeteorologicalStationGUI;
import edu.tum.cs.pse.meteostat.guiced.MeteorologicalStationGUI;

public class TestModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
	}

}

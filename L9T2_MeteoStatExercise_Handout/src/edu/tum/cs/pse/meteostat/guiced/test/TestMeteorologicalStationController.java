package edu.tum.cs.pse.meteostat.guiced.test;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.tum.cs.pse.meteostat.guiced.IMeteorologicalStationGUI;
import edu.tum.cs.pse.meteostat.guiced.MeteorologicalFileStorage;
import edu.tum.cs.pse.meteostat.guiced.MeteorologicalSensorArray;
import edu.tum.cs.pse.meteostat.guiced.MeteorologicalStationController;

public class TestMeteorologicalStationController {
	
	private MeteorologicalSensorArray sensorArray;
	private MeteorologicalFileStorage fileStorage;
	private MeteorologicalStationController controller;
	private IMeteorologicalStationGUI gui;
	
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		sensorArray = EasyMock.createNiceMock(MeteorologicalSensorArray.class);
		fileStorage = EasyMock.createNiceMock(MeteorologicalFileStorage.class);
		
		controller = new MeteorologicalStationController(gui, fileStorage, sensorArray);
	}
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testMeasure() {
		
	}

}

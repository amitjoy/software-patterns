package edu.tum.cs.pse.meteostat.solution.test;

import java.io.IOException;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.tum.cs.pse.meteostat.solution.IMeteorologicalSensorArray;
import edu.tum.cs.pse.meteostat.solution.IMeteorologicalStorage;
import edu.tum.cs.pse.meteostat.solution.MeteorologicalStationController;

public class MeteorologicalStationTest {
	
	private static final int testHumidity = 42;
	private static final int testWindspeed = 0;
	private static final int testTemperature = 13;
	private Injector injector;
	private MeteorologicalStationController controller;

	@Before
	public void setUp() {
		injector = Guice.createInjector(new TestModule());
		controller = injector.getInstance(MeteorologicalStationController.class);
	}

	@Test
	public void testMeasure() {
		IMeteorologicalSensorArray sensorArray = injector.getInstance(IMeteorologicalSensorArray.class);
		EasyMock.expect(sensorArray.getTemperatureData()).andReturn(testTemperature);
		EasyMock.expect(sensorArray.getWindspeedData()).andReturn(testWindspeed);
		EasyMock.expect(sensorArray.getHumidityData()).andReturn(testHumidity);
		EasyMock.replay(sensorArray);
		controller.measure();
		EasyMock.verify(sensorArray);
	}

	@Test
	public void testSave() throws IOException {
		IMeteorologicalSensorArray sensorArray = injector.getInstance(IMeteorologicalSensorArray.class);
		EasyMock.expect(sensorArray.getTemperatureData()).andReturn(testTemperature);
		EasyMock.expect(sensorArray.getWindspeedData()).andReturn(testWindspeed);
		EasyMock.expect(sensorArray.getHumidityData()).andReturn(testHumidity);
		EasyMock.replay(sensorArray);
		controller.measure();
		EasyMock.verify(sensorArray);
		
		IMeteorologicalStorage storage = injector.getInstance(IMeteorologicalStorage.class);
		storage.setTemperature(testTemperature);
		storage.setWindspeed(testWindspeed);
		storage.setHumidity(testHumidity);
		storage.save();
		EasyMock.replay(storage);
		controller.save();
		EasyMock.verify(storage);
	}

}

package edu.tum.cs.pse.meteostat.solution.test;

import org.easymock.EasyMock;

import com.google.inject.Binder;
import com.google.inject.Module;

import edu.tum.cs.pse.meteostat.solution.IMeteorologicalSensorArray;
import edu.tum.cs.pse.meteostat.solution.IMeteorologicalStationGUI;
import edu.tum.cs.pse.meteostat.solution.IMeteorologicalStorage;

public class TestModule implements Module {

	public void configure(Binder binder) {
		IMeteorologicalStationGUI guiMock = EasyMock.createMock(IMeteorologicalStationGUI.class);
		binder.bind(IMeteorologicalStationGUI.class).toInstance(guiMock);
		IMeteorologicalStorage storageMock = EasyMock.createMock(IMeteorologicalStorage.class);
		binder.bind(IMeteorologicalStorage.class).toInstance(storageMock);
		IMeteorologicalSensorArray sensorArrayMock = EasyMock.createMock(IMeteorologicalSensorArray.class);
		binder.bind(IMeteorologicalSensorArray.class).toInstance(sensorArrayMock);
	}

}

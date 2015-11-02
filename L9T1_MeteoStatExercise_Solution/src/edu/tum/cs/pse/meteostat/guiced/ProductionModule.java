package edu.tum.cs.pse.meteostat.guiced;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * This production module defines the binding between interfaces and implementations.
 *
 */
public class ProductionModule implements Module {

	/**
	 * Configures the binding.
	 */
	public void configure(Binder binder) {
		// Bind the GUI interface to the Swing implementation.
		binder.bind(IMeteorologicalStationGUI.class).to(MeteorologicalStationGUI.class);
	}
}

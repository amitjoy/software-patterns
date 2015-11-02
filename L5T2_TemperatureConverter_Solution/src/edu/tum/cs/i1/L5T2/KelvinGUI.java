package edu.tum.cs.i1.L5T2;
 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class KelvinGUI extends TemperatureGUI {

	private Controller controller;
	
	public KelvinGUI(Controller controller, int h, int v) {
		super("Kelvin Temperature", h, v);
		
		this.controller = controller;
		addRaiseTempListener(new RaiseTempListener());
		addLowerTempListener(new LowerTempListener());
		addDisplayListener(new DisplayListener());
	}

	public void update(Observable t, Object o) { // Called from the Model
		setDisplay("" + (((TemperatureModel) t).getK()));
	}

	class RaiseTempListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.increaseK();
		}
	}

	class LowerTempListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.decreaseK();
		}
	}

	class DisplayListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = getDisplay();
			controller.setK(value);
		}
	}
}
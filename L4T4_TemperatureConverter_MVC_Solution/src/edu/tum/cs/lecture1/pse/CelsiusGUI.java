package edu.tum.cs.lecture1.pse;
 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class CelsiusGUI extends TemperatureGUI {
	private Controller controller;
	
	public CelsiusGUI(Controller controller, int h, int v) {
		super("Celsius Temperature", h, v);
		this.controller = controller;
		addRaiseTempListener(new RaiseTempListener());
		addLowerTempListener(new LowerTempListener());
		addDisplayListener(new DisplayListener());
	}
	
	@Override
	public void update(Observable t, Object o) { // Called from the Model
		setDisplay("" + ((TemperatureModel) t).getC());
	}

	class RaiseTempListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.increaseC();
		}
	}

	class LowerTempListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.decreaseC();
		}
	}

	class DisplayListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = getDisplay();
			controller.setC(value);
		}
	}
}
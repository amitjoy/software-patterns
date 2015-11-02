package edu.tum.cs.i1.L5T2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class FahrenheitGUI extends TemperatureGUI {
	private Controller controller;
	
	public FahrenheitGUI(Controller controller, int h, int v) {
		super("Fahrenheit Temperature", h, v);
		this.controller = controller;
		addRaiseTempListener(new RaiseTempListener());
		addLowerTempListener(new LowerTempListener());
		addDisplayListener(new DisplayListener());
	}

	public void update(Observable t, Object o) { // Called from the Model
		setDisplay("" + ((TemperatureModel) t).getF());
	}

	class RaiseTempListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.increaseF();
		}
	}

	class LowerTempListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			controller.decreaseF();
		}
	}

	class DisplayListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			double value = getDisplay();
			controller.setF(value);
		}
	}
}

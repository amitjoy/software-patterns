package edu.tum.cs.i1.L5T2;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class TemperatureGUI implements java.util.Observer {
	
	@SuppressWarnings("unused")
	private String label;
	private Frame temperatureFrame;
	private TextField display = new TextField();
	private Button raiseTempButton = new Button("Raise");
	private Button lowerTempButton = new Button("Lower");
	
	TemperatureGUI(String label, int h, int v) {
		this.label = label;
		temperatureFrame = new Frame(label);
		temperatureFrame.add("North", new Label(label));
		temperatureFrame.add("Center", display);
		Panel buttons = new Panel();
		buttons.add(raiseTempButton);
		buttons.add(lowerTempButton);
		temperatureFrame.add("South", buttons);
		temperatureFrame.addWindowListener(new CloseListener());
		temperatureFrame.setSize(200, 100);
		temperatureFrame.setLocation(h, v);
		temperatureFrame.setVisible(true);
	}

	public void setDisplay(String s) {
		display.setText(s);
	}

	public double getDisplay() {
		double result = 0.0;
		try {
			result = Double.valueOf(display.getText()).doubleValue();
		} catch (NumberFormatException e) {
			// Do nothing
		}
		return result;
	}

	public void addDisplayListener(ActionListener a) {
		display.addActionListener(a);
	}

	public void addRaiseTempListener(ActionListener a) {
		raiseTempButton.addActionListener(a);
	}

	public void addLowerTempListener(ActionListener a) {
		lowerTempButton.addActionListener(a);
	}

	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}

package edu.tum.cs.i1.L5T2;


import java.awt.Frame;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Observable;
import java.util.Observer;

public class SliderGUI implements Observer {

	private Scrollbar tempControl = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, -273, 160);
	private Controller controller;
	private Frame sliderFrame = new Frame("Celsius");
	
	public SliderGUI(Controller controller, int h, int v) {
		this.controller = controller;
		sliderFrame.add(tempControl);
		tempControl.addAdjustmentListener(new SlideListener());
		sliderFrame.setSize(250, 50);
		sliderFrame.setLocation(h, v);
		sliderFrame.setVisible(true);
		sliderFrame.addWindowListener(new TemperatureGUI.CloseListener());
	}

	public void update(Observable t, Object o) {
		double temp = ((TemperatureModel) t).getC();
		tempControl.setValue((int) temp); // Move the slider thumb
	}

	class SlideListener implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent e) {
			controller.setC(tempControl.getValue());
		}
	}
}

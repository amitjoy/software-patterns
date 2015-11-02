package edu.tum.cs.lecture1.pse;


import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Observable;
import java.util.Observer;

public class GraphGUI extends Frame implements Observer {

	private static final long serialVersionUID = 4385762751045760627L;
	private Controller controller;
	private Canvas gaugeCanvas;
	private TemperatureGauge gauge;
	
	private TemperatureModel model=null;
	
	public GraphGUI(Controller controller, int h, int v) {
		super("Temperature Gauge");
		this.controller = controller;
		gauge = new TemperatureGauge(-20, 150);
		Panel Top = new Panel();
		add("North", Top);
		gaugeCanvas = new TemperatureCanvas(gauge);
		gaugeCanvas.setSize(500, 280);
		add("Center", gaugeCanvas);
		setSize(220, 300);
		setLocation(h, v);
		setVisible(true);
	}

	public void update(Observable obs, Object o) { // Respond to changes
		model = (TemperatureModel) obs;
		repaint();
	}

	public void paint(Graphics g) {
		int celsius = model == null ? 0 : (int) model.getC(); // Use the current data to paint
		model = null;
		gauge.set(celsius);
		gaugeCanvas.repaint();
		super.paint(g);
	}
}

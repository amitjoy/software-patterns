package edu.tum.cs.lecture1.pse;
import javax.swing.JOptionPane;


public class Controller{
	
	private TemperatureModel model;
	
	public Controller(TemperatureModel model){
		this.model  = model;
	}
	
	public void init(){
		model.addObserver(new FahrenheitGUI(this, 100, 100));
		model.addObserver(new CelsiusGUI(this, 100, 250));
		model.addObserver(new SliderGUI(this, 20, 100));
		model.addObserver(new GraphGUI(this, 200, 200));
		model.addObserver(new KelvinGUI(this, 300, 100));
		try {
			model.setC(0.0);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	
	public void setC(double value){
		try {
			model.setC(value);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}	
	public void setF(double value){
		try {
			model.setF(value);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}	
	public void setK(double value){
		try {
			model.setK(value);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void increaseC() {
		try {
			model.setC(model.getC()+1);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
		}
	}
	public void increaseF() {
		try {
			model.setF(model.getF()+1);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void increaseK() {
		try {
			model.setK(model.getK()+1);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void decreaseC() {
		try {
			model.setC(model.getC()-1);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void decreaseF() {
		try {
			model.setF(model.getF()-1);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void decreaseK() {
		try {
			model.setK(model.getK()-1);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
}

package edu.tum.cs.i1.L5T2;
import javax.swing.JOptionPane;

public class Controller{
	
	private TemperatureModel model;
	private Invoker manageInvoker = new Invoker();
	
	public Controller(TemperatureModel model){
		this.model  = model;
	}
	
	public void init(){
		model.addObserver(new FahrenheitGUI(this, 100, 100));
		model.addObserver(new CelsiusGUI(this, 100, 250));
		model.addObserver(new SliderGUI(this, 20, 100));
		model.addObserver(new GraphGUI(this, 200, 200));
		model.addObserver(new KelvinGUI(this, 300, 100));
		manageInvoker.addObserver(new ControlPanel(this, 350, 300));
		
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
			SetCCommand setC = new SetCCommand(model);
			setC.setCTemperature(value);
			manageInvoker.execute(setC);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}	
	public void setF(double value){
		try {
			SetFCommand setF = new SetFCommand(model);
			setF.setFTemperature(value);
			manageInvoker.execute(setF);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}	
	public void setK(double value){
		try {
			SetKCommand setK = new SetKCommand(model);
			setK.setKTemperature(value);
			manageInvoker.execute(setK);
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void increaseC() {
		try {
			manageInvoker.execute(new RaiseCCommand(model));
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
		}
	}
	public void increaseF() {
		try {
			manageInvoker.execute(new RaiseFCommand(model));
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void increaseK() {
		try {
			manageInvoker.execute(new RaiseKCommand(model));
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void decreaseC() {
		try {
			manageInvoker.execute(new LowerCCommand(model));
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void decreaseF() {
		try {
			manageInvoker.execute(new LowerFCommand(model));
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	public void decreaseK() {
		try {
			manageInvoker.execute(new LowerKCommand(model));
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	
	public void undo() {
		try {
			manageInvoker.undo();
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
	
	public void redo(){
		try {
			manageInvoker.redo();
		} catch (IllegalTemperatureException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
            System.exit(0);
		}
	}
}

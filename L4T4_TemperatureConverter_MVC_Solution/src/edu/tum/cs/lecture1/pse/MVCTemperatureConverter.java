package edu.tum.cs.lecture1.pse;

/**
 * This solution was mainly written by Zhang Zhe and slightly adapted
 */
public class MVCTemperatureConverter {
	
	public static void main(String args[]) {
		TemperatureModel temperature = new TemperatureModel();
		new Controller(temperature).init();
		
	}
}

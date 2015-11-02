package lightswitch;

import java.awt.Label;

public class Light {
	private final Label lightLabel;

	public Light(Label lightLabel) {
		this.lightLabel = lightLabel;
	}

	public void turnOn() {
		System.out.println("The light is on");
		
		lightLabel.setBackground(new java.awt.Color(255, 255, 0));
	}

	public void turnOff() {
		System.out.println("The light is off");
		
		lightLabel.setBackground(new java.awt.Color(0, 0, 0));
	}
}

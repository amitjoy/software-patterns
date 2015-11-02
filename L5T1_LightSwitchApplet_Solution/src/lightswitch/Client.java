package lightswitch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Client extends java.applet.Applet {

	Light lamp;
	LightSwitchCommand switchUp;
	LightSwitchCommand switchDown;
	Switch lightSwitch;
	Button btnUp;
	Button btnDown;
	Label lightLabel;
	
	public void init() {
		lightLabel = new Label();
		lamp = new Light(lightLabel);
		switchUp = new FlipUpCommand(lamp);
		switchDown = new FlipDownCommand(lamp);
		lightSwitch = new Switch(switchUp, switchDown);
		
		setLayout(new GridLayout(3,2)); //Use Grid Layout

		btnUp = new Button();
		btnDown = new Button();
		
		btnUp.setLabel("switch up");
		btnDown.setLabel("switch down");
		
		add(btnUp);
		add(btnDown);
		
		add(lightLabel);
		
		btnUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lightSwitch.flipUp();
			}
		});
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lightSwitch.flipDown();
			}
		});
	}
	
	public void paint() {}
	
	public void start() {}
	
	public void stop() {}
	
	public void destroy() {
		lamp = null;
		switchUp = null;
		switchDown = null;
		lightSwitch = null;
		btnUp = null;
		btnDown = null;
		lightLabel = null;
	}
	
}

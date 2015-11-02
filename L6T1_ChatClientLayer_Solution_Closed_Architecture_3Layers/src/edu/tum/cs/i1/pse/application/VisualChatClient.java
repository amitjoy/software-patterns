package edu.tum.cs.i1.pse.application;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.tum.cs.i1.pse.network.NetworkLayerInterface;
import edu.tum.cs.i1.pse.presentation.PresentationLayerInterface;

public class VisualChatClient extends JFrame implements ApplicationLayerInterface, ActionListener {
	private NetworkLayerInterface networkLayer;
	private PresentationLayerInterface presentationLayer;
	private final JTextArea textArea;
	private final JButton sendButton;
	private final JTextField messageField;

	public VisualChatClient() {
		messageField = new JTextField(40);
		sendButton = new JButton("Send");
		sendButton.addActionListener(this);
		textArea = new JTextArea(10, 50);
		
		JPanel sendPanel = new JPanel();
		sendPanel.setLayout(new FlowLayout());
		sendPanel.add(messageField);
		sendPanel.add(sendButton);
		
		setLayout(new BorderLayout());
		add(sendPanel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		
		setSize(600, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void sendMessage(String message) {
		if (presentationLayer != null) {
			presentationLayer.sendMessage(message);
		} else if (networkLayer != null) {
			networkLayer.sendMessage(message);
		}
	}

	@Override
	public void receiveMessage(String message) {
		textArea.append("Received: " + message + "\n");
	}

	@Override
	public void setPresentationLayer(
			PresentationLayerInterface presentationLayer) {
		this.presentationLayer = presentationLayer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(sendButton)) {
			String message = messageField.getText();
			textArea.append("You sent: " + message + "\n");
			sendMessage(message);
			messageField.setText("");
		}
	}
	
	
}

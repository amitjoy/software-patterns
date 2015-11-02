package edu.tum.cs.i1.pse.application;

import java.util.Scanner;

import edu.tum.cs.i1.pse.network.NetworkLayerInterface;
import edu.tum.cs.i1.pse.presentation.PresentationLayerInterface;

public class ChatClient implements ApplicationLayerInterface {
	private NetworkLayerInterface networkLayer;
	private PresentationLayerInterface presentationLayer;
	
	public void waitForUserInput() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			sendMessage(input);
		}
	}
	
	@Override
	public void receiveMessage(String message) {
		System.out.println("Received new message: " + message);
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
	public void setPresentationLayer(
			PresentationLayerInterface presentationLayer) {
		this.presentationLayer = presentationLayer;		
	}
	
}
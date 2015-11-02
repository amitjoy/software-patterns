package edu.tum.cs.i1.pse.application;

import edu.tum.cs.i1.pse.presentation.PresentationLayerInterface;

public interface ApplicationLayerInterface {
	
	void sendMessage(String message);
	void receiveMessage(String message);
	
	void setPresentationLayer(PresentationLayerInterface presentationLayer);

}
package edu.tum.cs.i1.pse.network;

import edu.tum.cs.i1.pse.presentation.PresentationLayerInterface;

public interface NetworkLayerInterface {

	void sendMessage(String message);
	void receiveMessage(String message);
	
	void setPresentationLayer(PresentationLayerInterface presentationLayer);
	
}

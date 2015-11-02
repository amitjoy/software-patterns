package edu.tum.cs.i1.pse;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

import edu.tum.cs.i1.pse.application.ApplicationLayerInterface;
import edu.tum.cs.i1.pse.application.VisualChatClient;
import edu.tum.cs.i1.pse.network.NetworkClient;
import edu.tum.cs.i1.pse.network.NetworkLayerInterface;
import edu.tum.cs.i1.pse.presentation.AESEncryption;
import edu.tum.cs.i1.pse.presentation.PresentationLayerInterface;

public class Main {
	
	public static void main(String[] args) {
		String hostname = "ec2-54-217-104-219.eu-west-1.compute.amazonaws.com";
		int port = 1337;
		
		NetworkLayerInterface networkLayer = new NetworkClient(hostname, port, null);
		PresentationLayerInterface presentationLayer = new AESEncryption(getFixedAESKey());
		// PresentationLayerInterface presentationLayer = new CaesarEncryption(12);
		
		presentationLayer.setNetworkLayer(networkLayer);
		networkLayer.setPresentationLayer(presentationLayer);

		ApplicationLayerInterface applicationLayer = new VisualChatClient();
		// ConsoleChatClient applicationLayer = new ConsoleChatClient();
		applicationLayer.setPresentationLayer(presentationLayer);
		presentationLayer.setApplicationLayer(applicationLayer);
		// applicationLayer.waitForUserInput();
	}
	
	static byte[] getFixedAESKey() {
		return new byte[]{42, 13, 12, -94, 2, -91, 78, -121, 76, -77, 119, 122, -32, -67, 6, -43};
	}
	
	static byte[] generateAESKey() {
		KeyGenerator kgen;
		try {
			kgen = KeyGenerator.getInstance("AES");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		kgen.init(128);
		byte[] key = kgen.generateKey().getEncoded();
		return key;
	}

}
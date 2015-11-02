package edu.tum.cs.i1.pse.presentation;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import edu.tum.cs.i1.pse.application.ApplicationLayerInterface;
import edu.tum.cs.i1.pse.network.NetworkLayerInterface;


public class AESEncryption implements PresentationLayerInterface {
	NetworkLayerInterface networkLayer;
	ApplicationLayerInterface applicationLayer;

	private javax.crypto.Cipher cipher;
	private SecretKeySpec skeySpec;
	private byte[] key;

	public AESEncryption(byte[] key) {
		try {
			cipher = javax.crypto.Cipher.getInstance("AES");
			this.key = key;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		}
	}

	public String encrypt(String s, byte[] key) {
		skeySpec = new SecretKeySpec(key, "AES");
		try {
			cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, skeySpec);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		}
		try {
			byte[] encryptedBytes = cipher.doFinal(s.getBytes());
			char[] encryptedChars = new char[encryptedBytes.length]; int i=0;
			for(byte b:encryptedBytes) encryptedChars[i++]=(char) b;
			return new String(encryptedChars);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		}
	}

	public String decrypt(String s, byte[] key) {
		skeySpec = new SecretKeySpec(key, "AES");
		try {
			cipher.init(javax.crypto.Cipher.DECRYPT_MODE, skeySpec);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		}
		try {
			char[] charInput = s.toCharArray();
			byte[] byteInput = new byte[charInput.length]; int i=0;
			for (char c:charInput)
				byteInput[i++]=(byte)c;
			byte[] original = cipher.doFinal(byteInput);
			return new String(original);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void sendMessage(String message) {
		String encryptedMessage = encrypt(message, key);
		System.out.println("Sent encrypted message " + encryptedMessage);
		networkLayer.sendMessage(encryptedMessage);
	}

	@Override
	public void receiveMessage(String message) {
		String decryptedMessage = decrypt(message, key);
		System.out.println("Received decrypted message " + decryptedMessage);
		applicationLayer.receiveMessage(decryptedMessage );
	}

	@Override
	public void setApplicationLayer(ApplicationLayerInterface applicationLayer) {
		this.applicationLayer = applicationLayer;
	}

	@Override
	public void setNetworkLayer(NetworkLayerInterface networkLayer) {
		this.networkLayer = networkLayer;
	}

}

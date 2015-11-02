package edu.tum.pse.tictactoe.model;

import java.net.URL;

import javax.swing.ImageIcon;

public class Token {
	private final String tokenIconFile;
	private ImageIcon image;
	
	public Token(String tokenIconFile) {
		this.tokenIconFile = tokenIconFile;
	}
	
	public ImageIcon getImage() {
		if(image == null) {
			final ClassLoader cl = Thread.currentThread().getContextClassLoader();
			final URL url = cl.getResource(this.tokenIconFile);
			
			image = new ImageIcon(url); 
		}
		return image;
	}
}

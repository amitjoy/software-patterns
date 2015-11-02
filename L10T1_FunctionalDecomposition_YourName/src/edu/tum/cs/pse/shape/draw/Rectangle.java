package edu.tum.cs.pse.shape.draw;
import java.util.UUID;


public class Rectangle{

	private UUID id;
	private int width;
	private int height;
	private int xCoordinate;
	private int yCoordinate;
	
	public Rectangle(int width, int height, int x, int y ) {
		id = UUID.randomUUID();
		this.width = width;
		this.height = height;
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public void draw() {
		System.out.println("Drawing: " + this.toString());
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height
				+ ", xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + ", id=" + id + "]";
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getX() {
		return xCoordinate;
	}

	public int getY() {
		return yCoordinate;
	}
	
}

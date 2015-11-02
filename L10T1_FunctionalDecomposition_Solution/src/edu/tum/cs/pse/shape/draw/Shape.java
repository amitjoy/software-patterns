package edu.tum.cs.pse.shape.draw;
import java.util.UUID;

public abstract class Shape {

	protected int width;
	protected int height;
	protected int xCoordinate;
	protected int yCoordinate;
	protected UUID id;
	
	
	public Shape(int width, int height, int x, int y) {
		id = UUID.randomUUID();
		this.width = width;
		this.height = height;
		this.xCoordinate = x;
		this.yCoordinate = y;
	}
	
	public abstract void draw();

}

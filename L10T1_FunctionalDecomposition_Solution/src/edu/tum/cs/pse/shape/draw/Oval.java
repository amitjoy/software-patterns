package edu.tum.cs.pse.shape.draw;

public class Oval extends Shape {

	public Oval(int width, int height, int x, int y) {
		super(width, height, x, y);
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing:  " + this.toString());
	}

	@Override
	public String toString() {
		return "Oval [width=" + width + ", height=" + height + ", xCoordinate="
				+ xCoordinate + ", yCoordinate=" + yCoordinate + ", id=" + id
				+ "]";
	}

	public static Oval changeForm(Shape s) {
		return new Oval(s.width, s.height, s.xCoordinate, s.yCoordinate);
	}
	
}

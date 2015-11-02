package edu.tum.cs.pse.shape.draw;

public class Rectangle extends Shape {

	public Rectangle(int width, int height, int x, int y) {
		super(width, height, x, y);
	}
	
	@Override
	public void draw() {
		System.out.println("Drawing: " + this.toString());
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height
				+ ", xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + ", id=" + id + "]";
	}

	public static Rectangle changeForm(Shape s) {
		return new Rectangle(s.width, s.height, s.xCoordinate, s.yCoordinate);
	}

}

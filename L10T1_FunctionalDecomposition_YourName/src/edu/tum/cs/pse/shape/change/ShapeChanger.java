package edu.tum.cs.pse.shape.change;

import edu.tum.cs.pse.shape.draw.Oval;
import edu.tum.cs.pse.shape.draw.Rectangle;

/**
 * Class holds helper method for changing shapes
 */
public class ShapeChanger {

	public static Oval changeRectangleToOval(Rectangle r) {
		Oval result = new Oval(r.getWidth(), r.getHeight(), r.getX(), r.getY());
		return result;
	}
	
	public static Rectangle changeOvalToRectangle(Oval o){
		Rectangle result = new Rectangle(o.getWidth(), o.getHeight(), o.getX(), o.getY());
		return result;
	}
}

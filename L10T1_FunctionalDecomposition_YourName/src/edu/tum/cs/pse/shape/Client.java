package edu.tum.cs.pse.shape;

import edu.tum.cs.pse.shape.change.ShapeChanger;
import edu.tum.cs.pse.shape.draw.Oval;
import edu.tum.cs.pse.shape.draw.Rectangle;

public class Client {

	public static void main(String[] args) throws Exception {
		// change oval to rectangle
		Oval o = new Oval(10,20,30,40);
		System.out.println("Changing oval to rectangle");
		System.out.println("Before change: " + o);
		Rectangle resultingRectangle = ShapeChanger.changeOvalToRectangle(o);
		resultingRectangle.draw();
		
		System.out.println();
				
		// change rectangle to oval
		Rectangle r = new Rectangle(1,2,3,4);
		System.out.println("Changing rectangle to oval");
		System.out.println("Before change: " + r);
		Oval resultingOval = ShapeChanger.changeRectangleToOval(r);
		resultingOval.draw();
	}

}

package tk.astris.physics.collisions;

import java.awt.Shape;
import java.awt.geom.Area;

public class Collision {
	
	public static boolean testIntersection(Shape shapeA, Shape shapeB) {
		   Area areaA = new Area(shapeA);
		   areaA.intersect(new Area(shapeB));
		   return !areaA.isEmpty();
		}
	
}

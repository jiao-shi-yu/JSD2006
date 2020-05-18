package collection;

import java.util.ArrayList;
import java.util.Collection;

public class ContainsDemo {
	public static void main(String[] args) {
		Collection<Point> c = new ArrayList();
		Point p1 = new Point(1, 2);
		Point p2 = new Point(1, 2);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("p1==p2: "+(p1==p2));
		System.out.println("p1.equals(p2): "+(p1.equals(p2)));
		System.out.println("c: " + c);
		c.add(p1);
		System.out.println("c added p1: "+p1);
		System.out.println("c: " + c);
		System.out.println("c contains p2" + p2 + ": " + (c.contains(p2)));
		
	}
}

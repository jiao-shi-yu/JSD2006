package collection;

import java.util.ArrayList;
import java.util.Collection;

public class ReferenceDemo {
	public static void main(String[] args) {
		String str = "hello";
		int a = 1;
		Point p = new Point(1, 2);
		Collection c = new ArrayList();
		c.add(p);
		dosome(a, str, p, c);
		System.out.println("str:" + str);
		System.out.println("a:" + a);
		System.out.println("p:" + p);
		System.out.println("c:" + c);
		
	}

	private static void dosome(int a, String str, Point p, Collection c) {
		str = str + "world";
		a = a + 1;
		p.setX(a);
		c = new ArrayList();
		p = new Point(5, 6);
		c.add(p);
		c = new ArrayList();
		c.add(new Point(7,8));
		c.clear();
		c.add(p);
		
	}
	
	// 我的推断
	// str:hello
	// a:1
	// p:(2, 2)
	// c:[(2, 2)]
}

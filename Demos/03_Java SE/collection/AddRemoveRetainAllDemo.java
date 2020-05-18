package collection;


import java.util.Collection;
import java.util.HashSet;

public class AddRemoveRetainAllDemo {
	public static void main(String[] args) {
		Collection<String> c1 = new HashSet<>();
		c1.add("java");
		c1.add("c++");
		c1.add(".net");
		
		System.out.println(c1);
		
		Collection<String> c2 = new HashSet<>();
		c2.add("php");
		c2.add("ios");
		c2.add("java");
		
		System.out.println(c2);
		
		c2.addAll(c1);
		System.out.println(c2);
		
		c2.retainAll(c1);
		System.out.println(c2);
		
		c2.removeAll(c1);
		System.out.println(c2);
	}
}

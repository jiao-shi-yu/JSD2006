package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		c.add("上才艺~");
		c.add("E");
		c.add("D");
		c.add("M");
		c.add("EDM~");
		c.add("EDM~");
		
		Iterator<String> it = c.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(c);
	}
}

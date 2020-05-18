package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ForEachDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		c.add("one");
		c.add("two");
		c.add("three");
		c.add("four");
		c.add("five");
		System.out.println(c);
		
		c.forEach(
			(s) -> System.out.println(s)
		);
		
		/*
		 * 将现有集合转换为并发安全的集合
		 */
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		System.out.println(list);
		list = Collections.synchronizedList(list);
	}
}

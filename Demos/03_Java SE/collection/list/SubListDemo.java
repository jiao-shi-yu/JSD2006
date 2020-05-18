package collection.list;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("zero");
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		list.add("six");
		
		List<String> sublist = list.subList(3, 5);
		System.out.println(sublist);
		sublist.clear();
		System.out.println(list);
		
	}
}

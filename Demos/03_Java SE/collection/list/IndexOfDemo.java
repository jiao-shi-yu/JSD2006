package collection.list;

import java.util.ArrayList;
import java.util.List;

public class IndexOfDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("one");
		list.add("two");
		System.out.println(list);
		System.out.println("index of \"one\": "+list.indexOf("one"));
		System.out.println("last index of \"one\": "+list.lastIndexOf("one"));
	}
}

package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToArrayDemo {
	public static void main(String[] args) {
		List<String> list  = new ArrayList<>();
		
		list.add("one");
		list.add("two");
		list.add("three");
		
		Object[] objects = list.toArray();
		System.out.println(Arrays.toString(objects));
		
		String[] strs = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(strs));
		
	}
}

package collection.list;


import java.util.Arrays;
import java.util.List;

public class ArraysAsListDemo {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "four"};
		List<String> list = Arrays.asList(array);
		System.out.println(Arrays.toString(array));
		System.out.println(list);
		
		list.set(0, "1");
		System.out.println(list);
		System.out.println(Arrays.toString(array));		
		list.add("five");
	}
}

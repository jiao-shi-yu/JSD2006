package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("zero");
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		list.add(3, "3");
		
		System.out.println(list);
		
		String old = list.remove(3);
		System.out.println(list);
		System.out.println(old);
	}
}
/*Output
[zero, one, two, 3, three, four, five]
[zero, one, two, three, four, five]
3
*/
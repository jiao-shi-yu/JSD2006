package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ReverseDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		System.out.println(list);
		// 创建新集合的情况下，将集合倒序排列
		for (int i = 0; i < list.size()/2; i++) {
			String right = list.set(list.size()-1-i, list.get(i));
			list.set(i, right);
		}
		System.out.println(list);
	}
}

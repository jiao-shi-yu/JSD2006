package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		System.out.println("list:" + list);
		
		String str = list.get(0);
		
		System.out.println("使用 for 循环遍历线性表：");
		for (int i = 0; i < list.size(); i++) {
			str = list.get(i);
			System.out.printf( "\t%d %s%n", i, str);
		}
		

		String old = list.set(0, "zero");
		
		System.out.println("list:" + list);
		
		System.out.println("old:" + old);
		
		//list.set(99, "ninty-nine");
	}
}

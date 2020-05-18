package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForEachDemo2 {
	public static void main(String[] args) {
		// 创建一个线程安全的集合
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");

		Thread t1 = new Thread() {
			public void run() {
				System.out.println(list);
				list.forEach(
					(element) -> {
						System.out.println(element);
						try {
							Thread.sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				);
				System.out.println(getName() + ":遍历集合完毕");
				
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(getName() + ":开始添加新元素");
				list.add("6");
				System.out.println(getName() + ":添加新元素完毕");
				System.out.println(getName() + list);
			}
		};
		t1.start();
		t2.start();
	}
}

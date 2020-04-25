package day03;

import java.util.Arrays;

/**
 * 演示引用数组类型
 * @author yuyu
 *
 */
public class RefArrayDemo {
	public static void main(String[] args) {
		Student[] students = new Student[3];
		students[0] = new Student("小明", 19, "大连");
		students[1] = new Student("小红", 19, "青岛");
		students[2] = new Student("小帅", 19, "济南");
		
		System.out.println(students[2].name);
		students[2].age = 99;
		students[2].sayHi();
		
		Student[] stus = {
			new Student("小明", 19, "大连"),
			new Student("小红", 19, "青岛"),
			new Student("小帅", 19, "济南")	
		};
	
	}
}

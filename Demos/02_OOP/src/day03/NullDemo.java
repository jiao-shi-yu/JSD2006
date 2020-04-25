package day03;

public class NullDemo {
	public static void main(String[] args) {
		Student student = new Student("小明", 17, "上海");
		System.out.println(student.age);
		student = null;
		System.out.println(student);
		
//		System.out.println(student.age); //java.lang.NullPointerException
	}
}

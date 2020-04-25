package day02;

public class StudentTest {
	public static void main(String[] args) {
		Student wuMing = new Student();
		wuMing.sayHi();
		
		Student zs = new Student("张三", 66, "宇宙银河系太阳系地球北半球");
		zs.sayHi();
	}
}

package day01;

public class StudentTest {
	public static void main(String[] args) {
		//创建一个学生实例
		Student zs = new Student();
		//给成员变量赋值
		zs.name = "zhangsan";
		zs.age = 25;
		zs.address = "河北廊坊";
		//调用方法
		zs.study();
		zs.sayHi();
	}
}

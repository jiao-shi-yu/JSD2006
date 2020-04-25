package day02;

/** 
 * 主要演示类的构造方法
 * 默认访问控制权限 包内可见
 * @author yuyu
 *
 */
public class Student {
	// 成员变量
	String name;
	int age;
	String address;
	
	// 调用有参构造
	Student() { // 
		this("无名氏", 1, "未知"); 
	}
	
	// 有参构造
	Student(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	// 成员方法
	void study() {
		System.out.println(name + "学习...");
	}
	void sayHi() {
		System.out.println("大家好，我叫"+name+", 今年"+age+"岁，家住"+address);
	}
}
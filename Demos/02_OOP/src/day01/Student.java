package day01;
/** 
 * 写一个简单的学生类
 * @author yuyu
 *
 */
public class Student {
	// 成员变量
	String name;
	int age;
	String address;
	
	// 成员方法
	void study() {
		System.out.println(name + "学习...");
	}
	void sayHi() {
		System.out.println("大家好，我叫"+name+", 今年"+age+"岁，家住"+address);
	}
}

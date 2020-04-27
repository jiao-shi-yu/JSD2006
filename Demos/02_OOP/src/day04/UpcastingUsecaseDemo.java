package day04;

public class UpcastingUsecaseDemo {
	public static void main(String[] args) {
		Person[] persons = new Person[3];
		persons[0] = new Person("张三", 25, "北京");
		persons[1] = new Student("李四", 21, "上海", "12345");
		persons[2] = new Teacher("王五", 30, "济南", 5000.00);
		
		for (Person person : persons) {
			person.sayHi();
		}
	}
}
class Person {
	String name;
	int age;
	String address;
	Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	void sayHi() {
		System.out.println("大家好，我叫" + name + "， 今年" + age + "岁。家住" + address);
	}
}
class Student extends Person {
	String stuId; // 学号
	Student(String name, int age, String address, String stuId) {
		super(name, age, address);
		this.stuId = stuId;
	}
}
class Teacher extends Person {
	double salary; 
	Teacher(String name, int age, String address, double salary) {
		super(name, age, address);
		this.salary = salary;
	}
}
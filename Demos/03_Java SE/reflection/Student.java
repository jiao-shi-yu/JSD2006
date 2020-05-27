package reflection;
/**
 * 测试反射 有参构造
 * @author yuyu
 *
 */
public class Student {
	private String name = "小明";
	private int age = 9;
	public Student() {
		
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void sayHello() {
		System.out.println("学生：大家好，我是" + name + ", 我今年" + age + "岁");
	}
	public String toString() {
		return "学生[name=" + name + ", age=" + age + "]";
	}
}


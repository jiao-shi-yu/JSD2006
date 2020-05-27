package reflection;

public class Person {
	
	public void sayHello() {
		System.out.println("person:hello!");
	}
	public void say(String info) {
		System.out.println("person:" + info);
	}
	
	public void say(String name, int age) {
		System.out.println("person:大家好我是:" + name + ", 我今年" + age);
	}
	public void dosome() {
		System.out.println("我是Person的私有方法 dosome()!");
	}
}

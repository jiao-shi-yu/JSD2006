package day02;

public class OverloadDemo {
	public static void main(String[] args) {
		A a = new A();
		a.show();
		a.show("Summer", 19);
	}
}
class A {
	void show() {};
	void show(String name) {};
	void show(int age) {};
	void show(String name, int age) {};
}
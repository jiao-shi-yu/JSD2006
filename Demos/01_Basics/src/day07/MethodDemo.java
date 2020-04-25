package day07;

public class MethodDemo {
	public static void main(String[] args) {
		say();
		say("老王");
		say("小王", 17);
		sayHello("老王", 41);
		
		double num = getNum();
		System.out.println("num="+num);
		
		int sum = plus(1, 1);
		System.out.println("sum = plus(1, 1) = " + sum);
		System.out.println("plus(99, 99) returns " + plus(99, 99));
		
		a();
	}
	// 无参无返回
	public static void say() {
		System.out.println("你好，我是 JSY，今年 21 岁。");
	}
	// 有参无返回
	public static void say(String name) {
		System.out.println("你好，我是 " + name + "，今年 99 岁。");
	}
	// 多参无返回
	public static void say(String name, int age) {
		System.out.println("你好，我是 " + name + "，今年 " + age + " 岁。");
	}
	// 提前return
	public static void sayHello(String name, int age) {
		if (age > 40) {
			System.out.println("Hello，我是 " + name + "。 别问我多少岁，问就是 18.");
			return;
		}
		System.out.println("大家好，我叫" + name + "，今年 " + age + "岁。");
	}
	
	
	// 无参有返回
	public static double getNum() {
//		return; //编译错误，return 后面需要跟一个值
//		return "abc"; //编译错误，返回值类型不匹配
		return 8.88;
	}
	// 有参有返回
	public static int plus(int num1, int num2) {
		int num = num1 + num2;
		return num;
	}
	// 嵌套调用
	public static void a() {
		System.out.println("MethodDemo.a()");
		b();
	}
	public static void b() {
		System.out.println("MethodDemo.b()");
	}
}

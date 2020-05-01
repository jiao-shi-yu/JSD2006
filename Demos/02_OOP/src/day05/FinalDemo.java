package day05;

public class FinalDemo {
	/**
	 * final定义常量
	 */
	public static final Double PI = 3.1415926535;
	
	public static void main(String[] args) {
		/**
		 * final 修饰变量
		 *
		 * 
		 */
		
		//  修饰基本类型的变量--变量值不可变
		final int num = 1;
//		num = 2; //
		
		// 修饰整数类型的变量--引用地址不可变
		final Person 你大爷 = new Person("小明");
		System.out.println(你大爷);
//		你大爷 = new Person("小红");
		你大爷.name = "小红";
		System.out.println(你大爷);
		
		/**
		 * final 被定义的变量必须被初始化
		 */
		final Person finalPerson;
//		System.out.println(finalPerson.name);// 这样会报错
		finalPerson = new Person("罗志祥");
		System.out.println(finalPerson.name);
	}
}


class Person {
	String name;
	Person(String name) {
		this.name = name;
	}
}


/**
 * final 修饰类表示类不允许被继承
 * @author yuyu
 *
 */
final class FinalClass {
	
}
// class AClass extends FinalClass {} //final 修饰的类不允许被继承

/**
 * final 修饰的方法不允许被重写
 * 
 */
class NotFinalClass {
	final void sayHello() {
		System.out.println("你好");
	}
}
class SubClass extends NotFinalClass {
//	void sayHello() {} // 无法修改最终方法。
}
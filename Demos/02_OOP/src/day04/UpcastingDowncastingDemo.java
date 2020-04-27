package day04;

public class UpcastingDowncastingDemo {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.eyes = "一双大眼睛";
		animal.eat();
//		animal.wings; // 编译错误，父类不能访问子类特有的属性。
//		animal.fly(); // 父类也不能访问子类所特有的方法。
		Bird bird = new Bird();
		bird.eyes = "一对小眼睛"; // 子类可以访问父类的属性
		bird.eat(); // 子类可以调用父类的方法
		// 当然也可以调用独有的属性
		bird.wings = "一双翅膀";
		bird.fly();
		
		/**
		 * 子类对象直接赋值给父类引用，这就是向上造型。
		 */
		
		Animal birdAnimal = new Bird();
		System.out.println(birdAnimal.eyes);
		
		/**
		 * 向下转型是指把指向了子类对象的父类引用赋值给子类引用。
		 */
	}
}

class Animal {
	String eyes;
	void eat() {}
}
class Bird extends Animal {
	String wings; 
	void fly() {}
}
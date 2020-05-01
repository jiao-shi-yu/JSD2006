package day07.NestedClasses.member;

public class Circle {
	private double radius = 0;
	
	public static int count = 0;
	
	public Circle(double radius) {
		this.radius = radius;
		getDrawInstance().drawShape();
	}
	
	private Draw getDrawInstance() {
		return new Draw();
	}
	class Draw {
		public void drawShape() {
			/**
			 * 内部类可以任意访问外部类成员
			 */
			System.out.println(radius);
			System.out.println(count);
		}
	}
	public static void main(String[] args) {
		Circle circle = new Circle(4); //自动类型转换
		Circle.Draw draw = new Circle(6).new Draw();
		// private 方法在当前类里面，是可见的。
		Circle.Draw draw2 = new Circle(7).getDrawInstance();
	}
}

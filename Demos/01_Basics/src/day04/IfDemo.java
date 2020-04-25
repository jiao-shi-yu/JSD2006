package day04;

public class IfDemo {
	public static void main(String[] args) {
		double price = 300.00;
		if (price >= 500) {
			price *= 0.8;
		}
		System.out.println("消费金额为:"+price);
		
		int num = 6;
		if (num%2==0) {
			System.out.println("num 是偶数");
		}
		System.out.println("over");
	}
}

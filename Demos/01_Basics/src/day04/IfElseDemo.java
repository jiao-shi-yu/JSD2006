package day04;

public class IfElseDemo {
	public static void main(String[] args) {
		double price = 300.0;
		if (price>=500) {
			price*=0.8;
		} else {
			price*=0.9;
		}
		System.out.println("折后金额为："+price);
		
		
		
		int num = 5;
		if (num%2==0) {
			System.out.println(num+"是偶数");
		} else {
			System.out.println(num+"是奇数");
		}
		System.out.println("over");
	}
}

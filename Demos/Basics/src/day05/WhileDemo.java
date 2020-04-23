package day05;

public class WhileDemo {
	public static void main(String[] args) {
		/**
		 * 输出 10 次“行动是成功的阶梯”
		 */
		int times = 0; 			// 1. 循环变量的初始化
		while (times < 10) { 	// 2. 循环条件
			System.out.println("行动是成功的阶梯"+(++times));
			//times ++; 			// 3. 循环变量的改变
		}
		System.out.println("Over");
		
		/**
		 * 在控制台输出 9x9 乘法表
		 */
		int a = 1, b;
		while (a <= 9) {
			b = 1;
			while (b <= a) {
				System.out.print(b + " * " + a + " = " + a*b + "\t");
				b ++;
			}
			System.out.println();
			a++;	
		}
	}
}

package thread;

import java.util.Scanner;

public class SleepDemo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int seconds = scanner.nextInt();
		System.out.println("计时开始");
		try {
			/**
			 * 完成倒计时程序，程序启动后，输入一个数字。
			 * 然后从该数字开始计时
			 */
			for (; seconds > 0; seconds--) {
				System.out.println(seconds);
				Thread.sleep(1 * 1000);
			}
		} catch (Exception e) {
			
		}
		System.out.println("计时结束");
	}
}

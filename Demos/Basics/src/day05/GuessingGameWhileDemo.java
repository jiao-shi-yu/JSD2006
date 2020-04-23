package day05;

import java.util.Scanner;

public class GuessingGameWhileDemo {
	public static void main(String[] args) {
		/**
		 * 程序从 1 到 100 之间，生成一个随机整数。用户来猜。
		 */
		
		// 两种实现都需要用到 Scanner 
		Scanner scanner = new Scanner(System.in);
		
		// 从 1 到 100 之间，生成一个随机整数
		int number = (int)(Math.random() * 100 + 1);
		System.err.println(number); // 作弊
		
		// 开始实现功能
		System.out.print("程序已经从 1 到 100 之间，挑选了一个数字。请你猜猜看这个数字是多少\n-> ");
		
		int userGuess = scanner.nextInt();
		
		while (userGuess != number) {
			System.out.print("不对哦，给你点儿提示：");
			if (userGuess > number) {
				System.out.print("你猜的数字【太大了】");
			} else {
				System.out.print("你猜的数字【太小了】");
			}
			System.out.print("再猜一次吧\n-> ");
			userGuess = scanner.nextInt();
		}
		
		System.out.println("猜对了");
		
		// 关闭 Scanner
		scanner.close();
	}
	
}

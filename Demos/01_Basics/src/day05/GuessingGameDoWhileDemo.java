package day05;

import java.util.Scanner;

public class GuessingGameDoWhileDemo {
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
		int userGuess;
		do { 
			
			userGuess = scanner.nextInt();
			if (userGuess > number) {
				System.out.print("你猜的数字【太大了】");
			} else if (userGuess < number) {
				System.out.print("你猜的数字【太小了】");
			} else {
				System.out.println("你猜对了");
				break;
			}
			System.out.print("再猜一次吧\n-> ");
		} while (userGuess != number);
		
		// 关闭 Scanner
		scanner.close();
	}
	
}

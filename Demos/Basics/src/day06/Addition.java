package day06;

import java.util.Scanner;

public class Addition {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = 0;
		for (int i = 1; i <= 10; i++) {
			int a = (int)(Math.random()*100);
			int b = (int)(Math.random()*100);
			
			int result = a + b;
			
			System.out.println("("+i+")"+a+"+"+b+"=?");
			System.out.print("你的答案是：\n->");
			int answer = scanner.nextInt();
			
			if (answer == -1) {
				System.out.println("Bye~");
				break;
			}
			
			if (answer == result) {
				score += 10;
				System.out.println("答对了");
			} else {
				System.out.println("答错了");
			}
		}
		System.out.println("得分："+score);
	}
}

package cn.tedu;

import java.util.Scanner;

public class Demo01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请问有什么能够帮助您？");
		String info = sc.nextLine();
		info = info.replace("吗", "");
		info = info.replace("?", "!");
		info = info.replace("我", "我也");
		System.out.println(info);
	}
}

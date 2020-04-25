package day04;

import java.util.Scanner;

// 命令解析程序
public class CommandBySwitch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请选择功能：1.显示全部记录 2.查询登录记录 3.修改账户信息 0.退出");
		
		int command = scan.nextInt();
		
		switch(command) {
		case 1:
			System.out.println("显示记录操作");
			break;
		case 2:
			System.out.println("查询记录操作");
			break;
		case 3:
			System.out.println("修改账户信息操作");
			break;
		case 0:
			System.out.println("Bye~");
			break;
		default:
			System.out.println("输入错误");
		}
	}
}

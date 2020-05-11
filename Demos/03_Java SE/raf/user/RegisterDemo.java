package raf.user;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成用户注册的功能
 * 程序启动后要求用户一次输入：用户名，密码，昵称，年龄
 * 其中年龄为 int , 其他都是字符串。
 * 
 * 设计，用户名密码昵称，各站 32 字节。 年龄为固定的 4 字节。
 * 每条记录占用100字节。
 * @author yuyu
 *
 */
public class RegisterDemo {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎注册！");
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码");
		String password = scanner.nextLine();
		System.out.println("请输入昵称");
		String nickname = scanner.nextLine();
		System.out.println("请输入年龄");
		int age = scanner.nextInt();
		scanner.close();
		
		System.out.println(username + ", " + password + ", " + ", " + nickname + ", " + age);
		
		RandomAccessFile raf =  new RandomAccessFile("user.dat", "rw");
		// 移动指针到文件末尾，一遍追加新纪录
		raf.seek(raf.length());
		
		// 写用户名
		byte[] bytes = username.getBytes("UTF-8");
			// 将数组扩容到 32 字节。
		bytes = Arrays.copyOf(bytes, 32);
		raf.write(bytes);
		
		// 写密码
		bytes = password.getBytes("UTF-8");
		bytes = Arrays.copyOf(bytes, 32);
		raf.write(bytes);
		
		// 写昵称
		bytes = nickname.getBytes("UTF-8");
		bytes = Arrays.copyOf(bytes, 32);
		raf.write(bytes);
		
		// 写年龄
		raf.writeInt(age);
		
		// 关闭
		raf.close();
		System.out.println("写入完毕");
	}
}

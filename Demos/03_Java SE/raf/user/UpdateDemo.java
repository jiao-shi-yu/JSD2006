package raf.user;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 程序启动后要求用户输入用户名和新昵称
 * 修改 user.dat 文件中该用户的昵称。若不存在用户名，则在控制台输出：查无此人。
 * @author yuyu
 *
 */
public class UpdateDemo {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入新昵称：");
		String nickname = scanner.nextLine();
		
		RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");
		for (int i = 0; i < raf.length()/100; i++) {
			byte[] bytes = new byte[32];
			raf.seek(i * 100);
			raf.read(bytes);
			String usernameFromFile = new String(bytes, "UTF-8").trim();
			System.out.println(usernameFromFile);
			if (username.equals(usernameFromFile)) {
				raf.seek(i * 100 + 64);
				bytes = Arrays.copyOf(nickname.getBytes(), 32);
				raf.write(bytes);
				System.out.println("修改成功！");
				return;
			}
		}
		System.out.println("查无此人！");
		
	}
}

package io.readerWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后要求用户在控制台先输入文件名，然后对该文件写操作。
 * 之后用户在控制台输入的每一行字符串都按行写入到该文件。
 * @author yuyu
 *
 */
public class Note {
	public static void main(String[] args) throws IOException {
		System.out.print("请输入文件名：\n> ");
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		
		PrintWriter pw = new PrintWriter(fileName);
		int i = 1;
		System.out.print("第" + i + "行> ");
		String line = null;
		while(!(line = scanner.nextLine()).equals("q")) {
			pw.println(line);
			i ++;
			System.out.print("第" + i + "行> ");
		};
		scanner.close();
		pw.close();
		System.out.println("保存成功！");
	}
}

package io.stream.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("bos.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int d = -1;
		// 缓冲读入，实际上不是一个字节读取的。
		while ((d = bis.read())!=-1) {
			System.out.print(d + " "); // 读取到的二进制字节对应的10进制整形。
		}
		bis.close();
	}
}

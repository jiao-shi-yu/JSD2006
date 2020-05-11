package io.stream.fileStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用文件输入流读取文件
 * @author yuyu
 *
 */
public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fos.txt");
		byte[] bytes = new byte[1000];
		int len = fis.read(bytes);
		System.out.println("实际读取到的字节："+len);
		String str = new String(bytes, "UTF-8");
		System.out.println("读取到的字符串:" + str);
		fis.close();
	}
}

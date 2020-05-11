package io.stream.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("bos.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		String str = "种一棵树最好的时间有两个，一个是十年前，一个是现在。";
		byte[] bytes = str.getBytes("UTF-8");
		bos.write(bytes);
		// flush()方法，将缓冲区的数据强制写出。
//		bos.flush();
		System.out.println("写出完毕");
		bos.close();
		
	}
}

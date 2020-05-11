package io.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo2 {
	public static void main(String[] args) throws IOException {
		// 读取数据
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "r");
		/**
		 * read() 读一个字节
		 */
		int integer = raf.read();
		System.out.println(integer);
		integer = raf.read();
		System.out.println(integer);
		integer = raf.read();
		System.out.println(integer);
		raf.close();
		
	}
}

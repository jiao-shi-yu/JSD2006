package io.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * java.io.RandomAccessFile
 * 基于指针随机读写文件。
 * @author yuyu
 *
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		/**
		 * 对当前目录下的 raf.dat 文件进行操作
		 * 构造方法中的第一个参数指定的是要操作的文件，第二个参数为操作方式。
		 * r:只读  rw:读写
		 *
		 */
		RandomAccessFile raf = new RandomAccessFile("raf.dat", "rw");
		
		/**
		 * void write(int d)
		 * 向文件中写入一个字节，写入的是给定的 int 值所对应的二进制数的低八位。
		 * 
		 */
		raf.write(1);
		System.out.println("写出完毕！");
		raf.close();
	}
}

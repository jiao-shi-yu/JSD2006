package raf.string;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过RandomAccessFile向文件中写入字符串
 * @author yuyu
 *
 */
public class WriteStringDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "rw");
		
		String str = "让我再看你一遍， 从南到北\n";
		/**
		 * byte[] getbytes(String charsetName);
		 * 返回一个字节数组。
		 * charsetName: UTF-8 or GBK or ISO8859-1
		 */
		byte[] bytes = str.getBytes("UTF-8");
		raf.write(bytes);
		str = "像是北五环路，蒙住的双眼";
		bytes = str.getBytes("UTF-8");
		raf.write(bytes);
		
		raf.close();
		
		System.out.println("写出完毕！");
		
	}
}

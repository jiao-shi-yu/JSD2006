package io.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 通过提高单次读写的数据量，提高读写效率
 * @author yuyu
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile src = new RandomAccessFile("./music.mp3", "r");
		RandomAccessFile dest = new RandomAccessFile("./music_copy_2.mp3", "rw");
		
		
		/**
		 * int read(byte[] bytes)
		 * 一次读取多个字节，存到数组中。
		 * 返回值为读取到的字节量，-1 表示读取到了文件末尾。
		 */
		
		long start = System.currentTimeMillis();
		byte[] bytes = new byte[1024*10]; // 10kb
		int d = 0;
		while((d = src.read(bytes)) != -1) {
			dest.write(bytes);
		}
		src.close();
		dest.close();
		long end = System.currentTimeMillis();
		System.out.println("复制完毕！耗时："+(end - start)+"ms");
	}
}

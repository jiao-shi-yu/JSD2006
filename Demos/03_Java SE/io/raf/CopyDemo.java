package io.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyDemo {
	public static void main(String[] args) throws IOException {
		/**
		 * 1.创建一个 RAF 用于读取源文件
		 * 2.一个 RAF 用于目标文件
		 * 3. 循环读取-复制
		 */
		RandomAccessFile src = new RandomAccessFile("./music.mp3", "r");
		RandomAccessFile dest = new RandomAccessFile("./music_copy.mp3", "rw");
		
		int d = 0;
		long startMillis = System.currentTimeMillis();
		while((d = src.read())!=-1) {
			dest.write(d);
		}
		long endMillis = System.currentTimeMillis();
		System.out.println("复制完毕！耗时："+(endMillis-startMillis) + "ms");
		src.close();
		dest.close();
	}
}

package io.stream.buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		
		FileInputStream fis = new FileInputStream("music.mp3");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("music_copy_3.mp3");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		
		
		int d = -1;
		while((d = fis.read()) != -1) {
			bos.write(d);
		}
		bis.close();
		bos.close();
		long end = System.currentTimeMillis();
		System.out.println("复制完毕，耗时" + (end - start) + "ms");
		
	}
}

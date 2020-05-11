package raf.string;

import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 先读取到字节数组中。
 * @author yuyu
 *
 */
public class ReadStringDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("raf.txt", "r");
		
		
		long len = raf.length();
		System.out.println(len);
		
		byte[] bytes = new byte[(int)len];
		raf.read(bytes);
		
		String str = new String(bytes, "UTF-8");
		System.out.println(str);

	}
}

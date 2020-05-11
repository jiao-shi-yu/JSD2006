package raf.user;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

/**
 * 向控制台中打印 user.dat 文件中的所有用户信息。
 * @author yuyu
 *
 */
public class ShowAllUsersDemo {
	static byte[] bytes = new byte[32];
	static RandomAccessFile raf;
	static {
		try {
			raf =  new RandomAccessFile("user.dat", "r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		
		
		// 每 100 字节，存储一条用户数据。
		for (int i = 1; i <= raf.length()/100; i ++) {
			String username = readBytesNewString();
			String password = readBytesNewString();
			String nickname = readBytesNewString();
			
			int age = raf.readInt();
			
			System.out.println("[" + i + "]" + username + ", " + password + ", " + nickname + ", " + age);
		}
	}

	private static String readBytesNewString() {
		try {
			raf.read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = null;
		try {
			str = new String(bytes, "UTF-8").trim();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}

package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchFinllayDemo2 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("fos.dat");
			fos.write(1);
			System.out.println("成功写了一个 1 对应的 二进制低八位");
		} catch (IOException e) {
			System.out.println("出错了！");
		} finally {
			try {
				if (fos!=null) {					
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

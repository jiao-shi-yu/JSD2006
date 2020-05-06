package file;

import java.io.File;

/**
 * File[] listFiles();
 * 以数组形式返回目录中的所有子项，每一个子项都是一个 File 对象
 * @author yuyu
 *
 */
public class ListFilesDemo {
	public static void main(String[] args) {
		// 获取当前目录下的所有子项
		File dir = new File(".");
		/*
		 * boolean isFile()
		 * 判断当前 File 表示的是否为一个文件。
		 * 
		 * boolean isDirectory()
		 * 判断当前 File 表示的是否为一个目录。
		 */
		
		if (dir.isDirectory()) {
			File[] subs = dir.listFiles();
			System.out.println(subs.length);
			for (File file : subs) {
				System.out.println(file.getName());
			}
		}
		
	}
}

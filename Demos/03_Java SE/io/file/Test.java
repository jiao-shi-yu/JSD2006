package io.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 获取当前目录下的所有文件（子项是目录的不要）
 * @author yuyu
 *
 */
public class Test {
	public static void main(String[] args) {
		File dir = new File(".");
		if (dir.isDirectory()) {
			FileFilter filter = new FileFilter() {

				@Override
				public boolean accept(File file) {
					// TODO Auto-generated method stub
					return file.isFile();
				};
				
			};
			File[] data = dir.listFiles(filter);
			System.out.println(data.length);
			for (File file : data) {
				System.out.println(file.getName());
			}
		}
	}
}

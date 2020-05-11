package io.file;

import java.io.File;
import java.io.IOException;

/**
 * 使用File 新建一个文件
 * @author yuyu
 *
 */
public class createNewFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录下新建一个文件：test.txt
		 */
		File file = new File("test.txt");
		/**
		 * boolean exist()
		 * 判断当前 File 表示的文件或目录是否存在
		 */
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建成功！");
		} else {
			System.out.println("文件已存在");
		}
	}
}

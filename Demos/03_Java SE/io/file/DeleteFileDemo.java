package io.file;

import java.io.File;

/**
 * 删除一个文件
 * @author yuyu
 *
 */
public class DeleteFileDemo {
	public static void main(String[] args) {
		/*
		 * 相对路径中"./"可以不写，不写默认就是当前目录。
		 * 下面两种写法，意思一样。
		 */
		File file = new File("./test.txt");
//		File file = new File("test.txt");
		if (file.exists()) {
			file.delete();
			System.out.println("成功删除！");
		} else {
			System.out.println("文件不存在！");
		}
	}
}

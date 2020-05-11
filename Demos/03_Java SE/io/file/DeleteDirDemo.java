package io.file;

import java.io.File;

/**
 * 删除一个目录
 * @author yuyu
 *
 */
public class DeleteDirDemo {
	public static void main(String[] args) {
		File dir = new File("demo");
		if (dir.exists()) {
			dir.delete();
			System.out.println("成功删除");
		} else {
			System.out.append("目录不存在");
		}
	}
}

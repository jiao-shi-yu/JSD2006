package file;

import java.io.File;

/**
 * 创建一个多级目录
 * @author yuyu
 *
 */
public class MakeDirsDemo {
	public static void main(String[] args) {
		// 在当前目录下新建目录：a/b/c/
		File dir = new File("a/b/c");
		if (!dir.exists()) {
			// 该方法会将所有不存在的父目录一同创建出来
			dir.mkdirs();
			System.out.println("目录成功创建！");
		} else {
			System.out.println("目录已存在！");
		}
	}
}

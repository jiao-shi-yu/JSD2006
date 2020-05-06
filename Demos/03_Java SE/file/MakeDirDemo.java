package file;

import java.io.File;

/**
 * 使用File创建一个目录
 * @author yuyu
 *
 */
public class MakeDirDemo {
	public static void main(String[] args) {
		// 在当前目录下新建一个子目录: demo
		File dir = new File("demo");
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("目录成功创建！");
		} else {
			System.out.println("目录已存在！");
		}
	}
}

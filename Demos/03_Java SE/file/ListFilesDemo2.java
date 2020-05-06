package file;

import java.io.File;
import java.io.FileFilter;

/**
 * File[] listFiles(FileFilter filter)
 * 重载的 listFiles 方法要求我们传入一个文件过滤器，
 * 满足条件的文件，才会被列出。
 * @author yuyu
 *
 */
public class ListFilesDemo2 {
	public static void main(String[] args) {
		// 获取当前目录下所有名字以"."开头的子项
		File dir = new File("."); // 当前目录
		/* FileFilter 是个接口，不能直接实例化
		 * 需要使用匿名内部类来创建实现类的对象
		 */
		FileFilter filter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				// TODO Auto-generated method stub
				return file.getName().startsWith(".");
			}
		};
		/**
		 * File[] listFiles(FileFilter filter)
		 * 该方法会将目录中的每一个子项都顺序传入过滤器的 accept 方法，
		 * 返回值为 true 的子项才会保留。
		 * 最终结果是一个 File[] 数组
		 */
		File[] subs = dir.listFiles(filter);
		for(File file : subs) {
			System.out.println(file.getName());
		}
	}
}

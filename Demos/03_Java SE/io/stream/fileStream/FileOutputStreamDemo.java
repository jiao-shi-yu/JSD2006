package io.stream.fileStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件输入流示例
 * 构造方法
 * 写出方法
 * @author yuyu
 *
 */
public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		/**
		 * 文件输入流 常用构造方法
		 * FileOutputStream(String path)
		 * FileOutputStream(File file)
		 * 使用文件路径，或使用指定的文件，构造一个文件输入流。默认是覆盖模式，会将文件原有内容清除。
		 * 
		 * 可以用一个布尔类型的参数，指明是否使用追加模式。
		 * FileOutputStream(String path, boolean append)
		 * FileOutputStream(File file, boolean append)
		 * 
		 */
		
		FileOutputStream fileOutputStream = new FileOutputStream("fos.txt", true);
		String str = "hello~姐~";
		byte[] bytes = str.getBytes("UTF-8");
		fileOutputStream.write(bytes);
		str = "来了老弟~";
		bytes = str.getBytes("UTF-8");
		fileOutputStream.write(bytes);
		
		fileOutputStream.close();
		System.out.println("写出完毕！");
		
	}
}

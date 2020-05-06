package file;

import java.io.File;

/**
 * java.io.File
 * File 用来表示文件系统上的一个文件或目录（实际是抽象路径）
 * 使用 File 我们可以：
 * 1. 访问文件过目录的属性信息（名字，大小，修改时间）
 * 2. 创建或删除文件和目录
 * 3. 访问一个目录中的所有子项
 * 
 * 但是不能访问文件数据
 * @author yuyu
 *
 */
public class FileDemo {
	public static void main(String[] args) {
		/*
		 * 创建 File 时要指定路径
		 * 这里的路径通常用相对路径，而相对路径中的"./"表示当前目录。
		 * 当前目录具体是哪里要视当前程序运行环境而定。
		 * 在 Eclipse 中执行时，表示的是当前程序所在的项目目录。 
		 */
		File file = new File("./demo.txt");
		// 获取文件名
		String name = file.getName();
		System.out.println("名字："+name);
		
		// 获取文件大小(单位是字节)
		long length = file.length();
		System.out.println("length="+length);
		
		// 获取文件读写权限的情况
		boolean cr = file.canRead();
		boolean cw = file.canWrite();
		System.out.println("可读：" + cr);
		System.out.println("可写：" + cw);
		
		
	}
}

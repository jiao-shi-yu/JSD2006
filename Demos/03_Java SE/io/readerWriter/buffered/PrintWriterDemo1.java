package io.readerWriter.buffered;


import java.io.IOException;

import java.io.PrintWriter;

/**
 * 缓冲字符流
 * BufferedWriter BufferedReader
 * 字符流同样有缓冲流，内部有缓冲区，可以做到块儿读写，提高读写字符的效率。
 * 
 * 对于输出字符而言，经常要换行，PrintWriter就是具有自动行刷新功能的缓冲流。
 * PrintWriter的println()方法，会在你要输出的字符串后添加一个换行符。
 * @author yuyu
 *
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		/**
		 * PrintWriter的构造方法中会帮你连接到 缓冲字符输出流、字符输出流、文件字节输出流。
		 
		 *  public PrintWriter(File file) throws FileNotFoundException {
        		this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))),
             false);
    		}
    	 * 你只需要指定文件名和字符集编码名就好。
		 */
		PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
		pw.println("一给我哩giao~");
		pw.println("我太难了");
		pw.close();
		System.out.println("写出完毕！");
		
	}
}

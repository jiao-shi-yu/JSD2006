package io.readerWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流
 * JavaIO将流按照读写单位划分为了字节流与字符流
 * 字符流的超类：
 * java.io.Writer：所有字符输入流的超类
 * java.io.Reader：所有字符输出流的超类
 * 
 * 字符流底层实际还是读写字节，只不过他底层进行了字节字符的转换，让我们可以以 char 为单位，进行文本数据的读写。
 * 字符流只适合读写文本数据。
 * @author yuyu
 *
 */
public class OutputStreamWriterDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("osw.txt");
		/**
		 * 常用构造方法
		 * OutputStreamWriter(OutputStream out);
		 * OutputStreamWriter(OutputStream out, String charsetName);
		 */
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, "UTF-8");
		outputStreamWriter.write("来，左边跟我一起画个龙");
		outputStreamWriter.write("右边儿画一道彩虹");
		
		outputStreamWriter.close();
		System.out.println("写出完毕");
		
	}
}

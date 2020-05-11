package io.readerWriter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream inputStream = new FileInputStream("osw.txt");
		InputStreamReader reader = new InputStreamReader(inputStream);
		
		/**
		 * int read()
		 * 读取一个字符，以 Unicode 码对应的 10 进制数返回。 -1 表示 EOF
		 */
		int d = 0;
		while((d=reader.read())!=-1) {
			char c = (char)d;
			System.out.println(c);
		}
		reader.close();
	}
}

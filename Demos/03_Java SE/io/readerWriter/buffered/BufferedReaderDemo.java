package io.readerWriter.buffered;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fileIn = new FileInputStream("pw.txt");
		InputStreamReader inReader = new InputStreamReader(fileIn, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inReader);
		
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		
		bufferedReader.close();
		System.out.println("\n读取完毕");
	}
}

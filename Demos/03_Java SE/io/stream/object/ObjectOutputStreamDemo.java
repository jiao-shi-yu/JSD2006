package io.stream.object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流是一对高级流，将对象进行序列化与反序列化。
 * 只管调用 wirteObject 方法就行，具体的工程有 Java 帮我们实现。
 * @author yuyu
 *
 */
public class ObjectOutputStreamDemo {
	
	
	public static void main(String[] args) throws IOException {
		Person gewei  = new Person("戈薇", 15, "女");
		
		System.out.println(gewei);
		
		FileOutputStream fos = new FileOutputStream("gewei.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(gewei);
		
		System.out.println("写出完毕");
		oos.close();
		
	}
}

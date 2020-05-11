package io.stream.object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("gewei.obj");
		ObjectInputStream objectInputStream = new ObjectInputStream(fis);
		/**
		 * Object readObject()
		 * 将读取到的字节按照其结构还原为 java 对象的过程，称为对象的反序列化。
		 */
		Person p = (Person)objectInputStream.readObject();
		System.out.println(p);
		objectInputStream.close();
	}
}

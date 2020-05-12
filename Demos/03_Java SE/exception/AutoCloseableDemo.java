package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseableDemo {
	public static void main(String[] args) {
		try (FileOutputStream fos = new FileOutputStream("fos.dat");) {
			fos.write(0);
		} catch (IOException e) { 
			e.printStackTrace();
		} // ! 不需要 finally.
	}
}

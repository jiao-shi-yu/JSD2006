package exception;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Testoos implements Serializable {
	  private User user = new User();
	  public static void main(String[] args) {
	    Testoos tts = new Testoos();
	    try {
	      FileOutputStream fs = new FileOutputStream("testoos.txt");
	      ObjectOutputStream os = new ObjectOutputStream(fs);
	      os.writeObject(tts.user);
	      os.close();
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	  }
	}
	class User {}
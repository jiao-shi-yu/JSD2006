package string;

public class StringDemo {
	public static void main(String[] args) {
		String s1 = "123abc";
		String s2 = "123abc";
		System.out.println(s1 == s2); // true
		
		String s3 = "123abc";
		System.out.println(s1 == s3); // true
		
		s1 = s1 + "!";				  // 123abc!
		System.out.println(s1);       // 123abc
		System.out.println(s2);       // 123abc!
		
		System.out.println(s1 == s2); // false
		System.out.println(s3 == s2); // true
	}
}

package string;
/**
 * static String valueOf(...)
 * String提供了一组载的静态方法valueOf，
 * 作用是将指定的内容转换为字符串。
 * @author yuyu
 *
 */
public class ValueOfDemo {
	public static void main(String[] args) {
		int a = 123;
		String s = String.valueOf(a);
		System.out.println(s);
		
		double dou = 123.123;
		String s2 = String.valueOf(dou);
		System.out.println(s2);
		
		String s3 = a + ""; // int + 空串
		System.out.println(s3.getClass().getName());
	}
}

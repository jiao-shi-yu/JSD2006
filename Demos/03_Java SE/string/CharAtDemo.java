package string;
/**
 * char charAt(int index);
 * 返回当前字符串中指定位置的字符
 * @author yuyu
 *
 */
public class CharAtDemo {
	public static void main(String[] args) {
		String line = "thinking in java";
		char c  = line.charAt(line.length()-1);
		System.out.println(c);
	}
}

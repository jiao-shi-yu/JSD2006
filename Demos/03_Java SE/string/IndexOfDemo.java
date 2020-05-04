package string;
/**
 * int indexOf(String str)
 * 检索给定字符串在字符中的位置，若不包含给定内容时，返回-1.
 * @author yuyu
 *
 */
public class IndexOfDemo {
	public static void main(String[] args) {
		String str = "thinking in java";
		int index = str.indexOf("in");
		System.out.println(index);
		
		index = str.indexOf("in", 3);
		System.out.println(index);
		
		index = str.lastIndexOf("in");
		System.out.println(index);
		
		
	}
}

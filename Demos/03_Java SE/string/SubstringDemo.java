package string;
/**
 * String substring(int beginIndex, int endIndex);
 * 截取指定范围的字符串
 * 在 Java API 中有一个特点：使用两个数字表示范围时，都是“含头不含尾”的。
 * @author yuyu
 */
public class SubstringDemo {
	public static void main(String[] args) {
		String location = "www.tedu.cn";
		String name = location.substring(4, 4 + 4);
		System.out.println(name);
		// 传一个参数，则是截取到末尾
		name = location.substring(4);
		System.out.println(name);
		
		
	}
}

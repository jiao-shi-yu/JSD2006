package regex;
/**
 * boolean matches(String regex)
 * 使用给定的正则表达式验证当前字符串是否符合要求，
 * 符合则返回 true
 * @author yuyu
 *
 */
public class MatchesDemo {
	public static void main(String[] args) {
		/**
		 * 电子邮箱的正则表达式
		 * [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+
		 */
		String email = "fan_cq@tedu.com.cn";
		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
		boolean match = email.matches(regex);
		if (match) {
			System.out.println("是邮箱");
		} else {
			System.out.println("不是邮箱");
		}
	}
}

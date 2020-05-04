package string.stringBuilder;
/**
 * 演示频繁修改字符串带来的性能损耗
 * 电脑变得好卡
 * @author yuyu
 *
 */
public class StringDemo2 {
	public static void main(String[] args) {
		String str = "a";
		for (int i = 0; i < 999999; i++) {
			str = str + i;
		}
		System.out.println("执行完毕");
	}
}

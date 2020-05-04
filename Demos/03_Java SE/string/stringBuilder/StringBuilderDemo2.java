package string.stringBuilder;

public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("a");
		
		for (int i = 0; i < 999999; i++) {
			builder.append(i);
		}
		System.out.println("执行完毕");
	}
}

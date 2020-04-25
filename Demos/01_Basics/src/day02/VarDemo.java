package day02;

public class VarDemo {
	public static void main(String[] args) {
		int a;
		int b, c, d;
		
		int e = 250;
		int f;
		f = 250;
		f = 360;
		
		int g = 5;
		int h = g + 10;
		System.out.println(h);
		System.out.print("h");
		// int i = 3.14; mismatch: cannot convert int from double
		
		// System.out.println(m); // m 未声明，cannot be resolved to a variable
		
		int n;
		// System.out.println(n); // the loacal variable may not be have been initialized
		
		
		/*
		 * 变量的命名
		 */
		int a1, a_5$, _$;
//		int a*%&*; // 错误，特殊符号 不被允许
//		int 2020LOVE; // 不能以数字开头
		int aa = 5;
//		System.out.print(Aa); // aa != Aa Java 严格区分大小写
		
//		int class; // 不允许使用关键字
		
		int 年龄; // 中文可行，但不建议。
		
		int age; // 英文的见名知意
		
		int score, myScore, myJavaScore; // 驼峰命名法
		
	}
}

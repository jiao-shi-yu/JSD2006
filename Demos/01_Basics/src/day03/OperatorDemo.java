package day03;

public class OperatorDemo {
	public static void main(String[] args) {
		/** 6
		 * 三目运算符
		 */
		System.out.println("\n\t三目元算符");
		int num = 5;
		
		int flag = num>0 ? 1 : -1;
		System.out.println(flag);
		
		
		int a = 8, b = 5;
		int max = a > b ? a : b;
		System.out.println("最大值为" + max);
		
		/** 5
		 * 字符串连接运算符
		 * 
		 */
		System.out.println("\n\t字符串连接运算符");
		int age = 21;
		System.out.println("我今年" + age + "岁。");
		System.out.println(10 + 20 + "" + 30);
		System.out.println("(10 + 20 + \"\" + 30) 是按照从左往右的顺序，先算加法，再拼接一个空字符串，然后再拼接一个30");
		
		/** 4
		 * 赋值运算符
		 */
		/**
		 * 常见面试题：下面三句话，哪里错了？为什么？怎么改？
		 */
		System.out.println("\n\t赋值运算符");
		short s = 5;
		s += 10;    // 赋值运算符包含了强转。相当于 s = (short)(s + 10);
//		s = s + 10; // 编译错误，需要强转。 s + 10 的结果是 int.
		
		int j = 5; 
		j *= 5;
		System.out.println(j);
		j /= 6;
		System.out.println(j);
		j %= 2;
		System.out.println(j);
		
		/** 3
		 * 逻辑运算符
		 */
		System.out.println("\n\t逻辑运算符");
		int a1 = 5, b1 = 10, c1 = 5;
		boolean b3 = a1>b1 && c1++ > 2; // 因为 a1 不是大于 b1 的，所以 c1++ 不会执行
		// 所以 b3 是 false， c1 还是 5;
		System.out.println("b3="+b3);
		System.out.println("c1="+c1);
		
		boolean b4 = a1 < b1 || c1++ > 2; // a1 确实 < b1，然后后面 c1++，就不会执行了。
		System.out.println("b4="+b4);
		System.out.println("c1="+c1); // c1 还是 5.
		
		
		
		/**
		 * 关系运算符
		 */
		System.out.println("\n\t关系运算符");
		int m = 5, n = 10, o = 5;
		System.out.println("o=5, o++>5:"+(o++>5));
		
		/**
		 * 算术运算符
		 */
		System.out.println("\n\t算术运算符");
		int p = 9, q = 2;
		int value = (p+q)%(p-q);
		System.out.println(value);
		
		System.out.println("p="+p+ ", sout(p++):" + p++);
		System.out.println("p="+p+ ", sout(++p):" + ++p);
		System.out.println("也可以看出++运算符的优先级，是高于+的");
		
		
	}
}

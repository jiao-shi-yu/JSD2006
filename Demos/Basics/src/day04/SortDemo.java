package day04;

public class SortDemo {
	public static void main(String[] args) {
		// 两个数的排序
		int a = 8, b = 5; // 升序
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		System.out.println(a + "," + b);
		
		// 变量的作用域和范围
		int m = 5;
		if (m > 2) {
			int n = 8;
//			int m = 55; // 重复的局部变量 m 
		} else {
			int n = 9;
		}
	}
}

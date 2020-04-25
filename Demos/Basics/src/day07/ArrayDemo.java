package day07;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		// 7. 数组的复制
		int[] a = {10, 20, 30, 40, 50};
		// 7.1 数组扩容
		System.out.println("\t数组缩容");
		a = Arrays.copyOf(a, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("\t数组扩容");
		a = Arrays.copyOf(a, a.length + 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		
		// 7.2 数组复制
		System.out.println("\t数组复制");
		int[] b = {10, 20, 30, 40, 50};
		int[] c = new int[6];
		System.arraycopy(b, 1, c, 0, 4); // 20, 30, 40, 50, 0, 0
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
		
		
		// 8. 数组的排序
		System.out.println("\t数组的排序");
		int[] arr = {29, 6, 28, 15, 3, 75, 58};
		Arrays.parallelSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
}

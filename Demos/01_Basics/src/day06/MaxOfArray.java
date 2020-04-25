package day06;

import java.util.Arrays;

public class MaxOfArray {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			// 生成一个随机数
			int num = (int)(Math.random()*100);
			// 赋值给数组元素
			arr[i] = num;
		}
		
		System.out.println(Arrays.toString(arr));
		
		// 开始寻找最大值
		
		int max = arr[0];  // 假设第一个元素为最大值
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) { // 如果当前遍历元素，大于历史最大值
				max = arr[i]; // 更改最大值
			}
		}
		System.out.println("最大数为：" + max);
	}
}

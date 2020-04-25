package day06;

public class ArrayDemo {
	public static void main(String[] args) {
		// 1. 定义数组
		int[] arr1 = new int[10];
		// 2. 初始化数组
		int[] arr2 = new int[3];
		int[] arr3 = {1, 4, 7};
		int[] arr4 = new int[]{1, 4, 7};
		int[] arr5;
//		arr5 = {1, 4, 7};
		arr5 = new int[] {1, 4, 7};
		
		// 3. 访问数组
		int[] arr = new int[3];
		System.out.println(arr.length);
		
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
//		arr[3] = 400; // runtimeException ArrayIndexOutOfBoundsException
		
		System.out.println(arr[arr.length - 1]);
		
		// 4. 数组的遍历
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = 100; // 每个元素都赋值为 100
			System.out.println(array[i]); // 顺便输出一下
		}
		
	}
}

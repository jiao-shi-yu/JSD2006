package day06;

public class ForDemo {
	public static void main(String[] args) {
		// 累加 1 到 100 的和，要求个位不为 3
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%10!=3) {
				sum += i;
			}
		}
		System.out.println("sum="+sum);
		
		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%10==3) {
				continue;
			}
			sum2 += i;
		}
		System.out.println("sum2="+sum2);
	}
}

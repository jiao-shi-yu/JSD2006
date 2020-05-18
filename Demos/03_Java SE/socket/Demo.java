package socket;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		int pw = 25;
		int[] allOut = {12, 36, 879, 546, 26, 25, 993};
		System.out.println(Arrays.toString(allOut));		/**
		 * 从 allOut 中删除 pw
		 */
		for (int i = 0; i < allOut.length; i++) {
			if (allOut[i]==pw) {
				allOut[i] = allOut[allOut.length-1];
			}
		}
		allOut = Arrays.copyOf(allOut, allOut.length - 1);
		System.out.println(Arrays.toString(allOut));
	}
}

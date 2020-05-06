package object;

import java.util.Arrays;

/**
 * 测试 Ojbect 类中常用的方法
 * @author yuyu
 *
 */
public class Demo {
	public static void main(String[] args) {
		Point p = new Point(1, 2);
		/**
		 * String toString()
		 * Object提供的该方法默认为 当前对象的地址信息
		 */
		String str = p.toString();
		System.out.println(str);
		
		/**
		 * System.out.println() 默认调用的就是对象的 toString() 方法，进行输出显示。
		 */
		System.out.println(p);
		
		Point[] arr = {new Point(1, 2),  new Point(3, 4), new Point(7, 1)};
		String line = Arrays.deepToString(arr);
		System.out.println(line);
		
		
		/**
		 * equals方法
		 * 作用比较两个对象是否相等。
		 * 通常需要重写，
		 * 因为 Object 默认是使用"=="比较的，没有实际意义。
		 */
		Point p2 = new Point(1, 2);
		System.out.println(p == p2);
		System.out.println(p.equals(p2));
	}
}

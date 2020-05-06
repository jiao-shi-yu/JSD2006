package wrapper;
/**
 * JDK5 推出了一个新特性：自动拆装箱
 * @author yuyu
 *
 */
public class AutoUnwrapping {
	public static void main(String[] args) {
		int d = 1;
		/**
		 * 自动装箱，编译器实际上编译的是：
		 * Integer i = Integer.valueOf(d);
		 */
		Integer i = d;
		/**
		 * 自动拆箱，编译器实际上编译的是：
		 * d = i.intValue();
		 * double d2 = i.doubleValue();
		 */
		d = i;
		double d2 = i;
		System.out.println("d = " + d + ", d2 = " + d2);
		
	}
}

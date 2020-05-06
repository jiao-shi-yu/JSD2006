package wrapper;
/**
 * 包装类的常用功能
 * @author yuyu
 *
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		/**
		 * 通过包装类得到基本类型的取值范围
		 */
		int imax = Integer.MAX_VALUE;
		int imin = Integer.MIN_VALUE;
		
		long lmax = Long.MAX_VALUE;
		long lmin = Long.MIN_VALUE;
		
		System.out.println("Integer: " + imin + "~" + imax);
		System.out.println("Long: " + lmin + "~" + lmax);
		
		/**
		 * 包装类可以将字符串解析为对应的基本类型
		 * 前提是该字符串能够表示一个 Number。
		 */
		String str = "123";
		int int1 = Integer.parseInt(str);
		System.out.println(int1);
		
		double dou = Double.parseDouble(str);
		System.out.println(dou);
		
	}
}

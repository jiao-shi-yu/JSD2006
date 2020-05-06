package wrapper;
/**
 * 包装类是为了解决基本类型不能直接参与面向对象开发的问题而出现的。
 * @author yuyu
 *
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		// 装箱：基本类型转换为包装类
		int d = 127;
		
//		Integer i1 = new Integer(d);
		
		// Java 建议我们使用静态方法 valueOf 将基本类型转换为包装类。
		Integer i1 = Integer.valueOf(d);
		Integer i2 = Integer.valueOf(d);
		
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		
		System.out.println(d == i1);
		
		Double d1 = Double.valueOf(123.123);
		Double d2 = Double.valueOf(123.123);
		
		// xxx.xxxValue 返回其基本类型对应数值
		double dou = d1.doubleValue();
		System.out.println(dou);
		
		// xxx.yyyValue 返回指定基本类型数值
		int i = d1.intValue();
		System.out.println(i);
		
		
	}
}

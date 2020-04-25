package day02;
/**数据类型的演示
 * 
 * @author yuyu
 *
 */
public class DataTypeDemo {
	public static void main(String[] args) {
		int a = 5;
		long b = 5;		// 自动类型转换
		int c = (int)b; // 强制类型转换
		
		long d = 5; 	// 自动类型转换
		double e = 5;	// 自动类型转换
		
		long f = 10000000000000L;
		
		int g = (int)f;
		System.out.print(g); 	// 溢出
		
		double h = 45.987;
		int i = (int)h;
		System.out.println(i); 	// 丢失精度
		
		byte b1 = 5; // 整数字面量可以直接赋值为 byte，short和char
		byte b2 = 6;
		
//		byte b3 = b1 + b2; // byte, short, char 型数据，参与运算，一律转换为 int 再运算。
		
		byte b4 = (byte)(b1 + b2);
	}
}

package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 利用反射调用方法
 * @author yuyu
 *
 */
public class RelectionDemo4 {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入类名");
		String className = scan.nextLine();
		System.out.println("请输入方法名");
		String methodName = scan.nextLine();
		scan.close();
		// 1. 获取类对象
		Class<?> cls = Class.forName(className);
		// 2. 通过类对象实例化对象
		Object obj = cls.newInstance();
		// 3. 通过类对象获取方法
		Method m = cls.getMethod(methodName);
		// 4. 方法被示例对象调用 invoke
		m.invoke(obj);
	}
}

package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReflectionDemo {
	public static void main(String[] args) {
		
		// Class clazz = Person.class;
		try {
			// 获取用户输入
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入类的完全限定名：");
			String className = scan.nextLine();
			scan.close();
			// 反射获取类的信息
			Class<?> cls = Class.forName(className);
			String clsName = cls.getName();
			System.out.println("className: " + clsName);
			System.out.println("\nMethods: ");
			List<Method> methods = Arrays.asList(cls.getMethods());
			methods.forEach(
					m -> {
						System.out.println(m.getName());
					}
			);
			System.out.println("\nDeclared Methods:");
			Method[] declaredMethods = cls.getDeclaredMethods();
			for (Method method : declaredMethods) {
				System.out.println(method);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

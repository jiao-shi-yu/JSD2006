package reflection;

import java.lang.reflect.Constructor;

/**
 * 使用反射机制实例化对象
 * 
 * @author yuyu
 *
 */
public class ReflectionDemo3 {
	public static void main(String[] args) {
		
		try {
			
			// 1. 获取类对象
			Class<?> cls = Class.forName("reflection.Student");
			
			// 2. 获取构造器
			Constructor<?> constructor = cls.getConstructor(String.class, int.class);
			
			// 3. 调用构造器的 newInstance 方法
			Object obj = constructor.newInstance("老王", 99);
			
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}

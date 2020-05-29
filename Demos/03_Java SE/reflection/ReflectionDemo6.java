package reflection;

import java.lang.reflect.Method;

/**
 * 使用反射机制，调用私有方法
 * @author yuyu
 *
 */
public class ReflectionDemo6 {
	public static void main(String[] args) throws Exception {
		Class<?> clas = Class.forName("reflection.Person");
		Object o = clas.newInstance();
		Method m = clas.getMethod("dosome");
		m.setAccessible(true);
		m.invoke(o);
	}
}

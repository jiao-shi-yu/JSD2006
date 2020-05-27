package reflection;

import java.lang.reflect.Method;

public class ReflectionDemo5 {
	public static void main(String[] args) throws Exception {
		Class<?> cls = Class.forName("reflection.Person");
		
		Object o = cls.newInstance();
		
		Method m = cls.getMethod("say", String.class);
		
		m.invoke(o, "哈喽");
		
		Method m2 = cls.getMethod("say", String.class, int.class);
		m2.invoke(o, "李四", 44);
	}
}

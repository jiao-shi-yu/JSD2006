package reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ReflectionDemo {
	public static void main(String[] args) {
		// Class clazz = Person.class;
		try {
			Class cls = Class.forName("reflection.Person");
			List<Method> methods = Arrays.asList(cls.getMethods());
			methods.forEach(
					m -> {
						System.out.println(m.getName());
					}
			);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}

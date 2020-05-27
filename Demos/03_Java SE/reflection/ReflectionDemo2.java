package reflection;
/**
 * 使用反射机制实例化对象
 * 
 * @author yuyu
 *
 */
public class ReflectionDemo2 {
	public static void main(String[] args) {
		
		try {
			
			// 1. 加载类对象
			Class<?> cls = Class.forName("reflect.Person");
			
			// 2. 调用类对象的 newInstance() 方法
			Object obj = cls.newInstance();
			
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}

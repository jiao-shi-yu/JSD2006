package exception;

public class ThrowDemo {
	public static void main(String[] args) {
		Person p = new Person();
		// 满足语法但是不满足业务逻辑
		try {
			p.setAge(10000);
		} catch (IllegalAgeException e) {
			e.printStackTrace();
		}
		
		System.out.println(p.getAge());
	}
}

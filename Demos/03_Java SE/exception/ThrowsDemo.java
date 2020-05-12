package exception;

public class ThrowsDemo {

	public static void main(String[] args) throws Exception {
		Person p = new Person();
		// 满足语法但是不满足业务逻辑
		p.setAge(10000);
		System.out.println(p.getAge());
	}
}


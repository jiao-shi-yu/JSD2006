package day07.innerClasses.anonymous;

abstract class Person {
	private String name;
	public abstract double getHeight();
	public Person() {}
	public Person(String name) {
		this.name = name;
	}
	// getter and setter for name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
public class AbstractClassAnonymousClassTest {
	public void test(Person p) {
		System.out.printf("姓名为%s;%n身高为%.2f;%n", p.getName(), p.getHeight());
	}
	public static void main(String[] args) {
		AbstractClassAnonymousClassTest ac = new AbstractClassAnonymousClassTest();
		
		// 调用有参构造，实例化匿名类对象。
		ac.test(new Person("图灵") /*这边调用有参构造传入一个参数*/ 
				{
					// 实现抽象方法
					@Override
					public double getHeight() {
						return 1.80;
					} 
					
				}
		);
		
		ac.test(new Person() /* 这次使用的是无参构造*/ {
			// 实现抽象方法
			@Override
			public double getHeight() {
				// TODO Auto-generated method stub
				return 1.68;
			}
			// 重写父类方法
			@Override
			public String getName() {
				return "小明";
			}
		});
	}
}

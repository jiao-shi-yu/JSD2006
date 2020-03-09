package cn.tedu.spring;

public class User {
	// Kate
	private String name;
	
	// ShangHai
	private String from;
	
	// 26
	private int age;

	public User(String name, String from, int age) {
		super();
		this.name = name;
		this.from = from;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", from=" + from + ", age=" + age + "]";
	}
	
	
	
	
	
}

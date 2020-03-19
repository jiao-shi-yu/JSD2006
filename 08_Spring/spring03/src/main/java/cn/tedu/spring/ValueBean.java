package cn.tedu.spring;

public class ValueBean {
	// 值是SampleBean的name
	private String name;

	// 值是SampleBean的from
	private String from;
	
	// 值是SampleBean的age
	private int age;
	
	// 值是SampleBean的skills中的第二个skill
	private String skill;

	// 值是SampleBean的numbers中的第一个number
	private int number;
	
	
	// 值是SampleBean的cities中的第一个值
	private String city;
	
	// 值是SampleBean的session中的password
	private String password;
	
	
	
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSkill() {
		return skill;
	}
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "ValueBean [name=" + name + ", from=" + from + ", age=" + age + ", skill=" + skill + "]";
	}
	
}

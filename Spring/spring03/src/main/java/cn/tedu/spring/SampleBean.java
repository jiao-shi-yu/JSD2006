package cn.tedu.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SampleBean {
	// Frank
	private String name;
	
	// Beijing
	private String from;
	
	// 35
	private Integer age;
	
	
	// Java SE, MySQL, Spring
	private List<String> skills;
	
	// Beijing, Shanghai, Guangzou, Shenzen
	private Set<String> cities;
	
	// username=Billy, password=1234, age=28
	private Map<String, String> sessions;
	
	// 9, 5, 2, 7
	private int[] numbers;
	
	// 值来自jdbc.properties文件
	private Properties jdbc;
	
	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public Map<String, String> getSessions() {
		return sessions;
	}

	public void setSessions(Map<String, String> sessions) {
		this.sessions = sessions;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getJdbc() {
		return jdbc;
	}

	public void setJdbc(Properties jdbc) {
		this.jdbc = jdbc;
	}

	public Set<String> getCities() {
		return cities;
	}

	public void setCities(Set<String> cities) {
		this.cities = cities;
	}
	
	
}

package cn.tedu.mybatis;

import java.util.List;

public class GroupVO {
	private Integer id;
	private String name;
	private List<User> users;
	// Setters & Getters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "GroupVO [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
	
	// toString()
	
}


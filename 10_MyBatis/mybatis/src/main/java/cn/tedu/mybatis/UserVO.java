package cn.tedu.mybatis;

public class UserVO {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String phone;
    private String email;
    private Integer groupId;
    private String groupName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", phone="
				+ phone + ", email=" + email + ", groupId=" + groupId + ", groupName=" + groupName + "]";
	}


    // Getters and Setters

    // toString()
	
}
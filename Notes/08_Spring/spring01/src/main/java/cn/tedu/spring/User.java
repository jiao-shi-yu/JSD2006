package cn.tedu.spring;

public class User {
	// private User() --- OK
	// public User(Object ojb) --- NOT OK
	public User() {
		System.out.println("User.User()");
	}
}

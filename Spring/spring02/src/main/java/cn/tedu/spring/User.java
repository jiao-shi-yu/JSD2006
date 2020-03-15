package cn.tedu.spring;

public class User extends Object {
	public User() {
		System.out.println("\tUser.User()");
	}
	public void init() {
		System.out.println("\tUser.init()");
	}
	public void destroy() {
		System.out.println("\tUser.destory()");
	}
}

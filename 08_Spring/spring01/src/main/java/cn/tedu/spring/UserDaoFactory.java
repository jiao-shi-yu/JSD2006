package cn.tedu.spring;

public class UserDaoFactory {
	public UserDao newInstance() {
		return new UserDao(null);
	}
}

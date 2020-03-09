package cn.tedu.spring;

public class UserLoginServlet {
	
	private UserDao userJdbcDao;
	
	public void setUserJdbcDao(UserDao userJdbcDao) {
		this.userJdbcDao = userJdbcDao;
	}

	public void doPost() {
		System.out.println("UserLoginServlet.doPost()");
		userJdbcDao.login();
	}
}

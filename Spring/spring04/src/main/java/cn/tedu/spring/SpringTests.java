package cn.tedu.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTests {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		UserLoginServlet userLoginServlet = ac.getBean("userLoginServlet", UserLoginServlet.class);
		
		userLoginServlet.doPost();
		
		ac.close();
		
	}
}

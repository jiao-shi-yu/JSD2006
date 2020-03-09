package cn.tedu.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		System.out.println("[1] 准备加载Spring的配置文件...");
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("[1] 完成加载Spring的配置文件！");
		
		
		System.out.println("[2] 准备从Spring容器中获取对象...");
		User user1 = ac.getBean("user", User.class);
		User user2 = ac.getBean("user", User.class);
		User user3 = ac.getBean("user", User.class);
		UserLoginServlet userLoginServlet = ac.getBean("userLoginServlet", UserLoginServlet.class);
		System.out.println("[2] 完成从Spring容器中获取对象！");
		
		
		System.out.println("[3] 准备测试...");
		System.out.println("\t"+user1);
		System.out.println("\t"+user2);
		System.out.println("\t"+user3);
		userLoginServlet.doPost();
		
		System.out.println("[3] 完成测试！");
		
		System.out.println("[4] 准备关闭...");
		ac.close();
		System.out.println("[4] 完成关闭！");
	}
}

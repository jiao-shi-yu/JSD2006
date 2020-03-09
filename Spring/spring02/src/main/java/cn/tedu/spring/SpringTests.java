package cn.tedu.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTests {
	
	public static void main(String[] args) {
		// 1. 加载Spring的配置文件，获取Spring容器
		System.out.println("[1]准备加载Spring的配置文件...");
		ClassPathXmlApplicationContext ac 
		= new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("[1]完成加载Spring的配置文件...");
		
		
		// 2. 从Spring容器中获取对象
		System.out.println("[2]准备从Spring中获取对象...");
		User user1 = ac.getBean("user", User.class);
		User user2 = ac.getBean("user", User.class);
		User user3 = ac.getBean("user", User.class);
		System.out.println("[2]完成从Spring中获取对象...");

		// 3. 测试
		System.out.println("[3]准备测试...");
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user3);
		System.out.println("[3]完成测试...");
		System.out.println("\t\n-------------\n");
		
		// 4. 关闭
		System.out.println("[4]准备关闭Spring容器...");
		ac.close();
		System.out.println("[4]完成关闭Spring容器...");
	}
}

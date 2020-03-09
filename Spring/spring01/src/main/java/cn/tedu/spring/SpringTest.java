package cn.tedu.spring;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	public static void main(String[] args) {
		// 加载Spring配置文件，获取Spring容器
		ClassPathXmlApplicationContext ac 
		= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 从Spring容器中获取对象，调用getBean()方法时，参数就是配置文件中的Bean Id
		Date date = (Date) ac.getBean("date");
		
		User user = (User) ac.getBean("user");
		
		Calendar calendar = (Calendar) ac.getBean("calendar");
		
		Person person = (Person) ac.getBean("person");
		
		UserDao userDao = (UserDao) ac.getBean("userDao");
		// 关闭
		ac.close();
		
		// 测试
		System.out.println(date);
		System.out.println(user);
		System.out.println(calendar);
		System.out.println(person);
		System.out.println(userDao);
	}

}

package cn.tedu.spring;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTests {

	public static void main(String[] args) {
		// 1. 加载Spring配置文件，获得Spring容器
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		// 2. 从Spring容器获取对象
		SampleBean sampleBean = ac.getBean("sampleBean", SampleBean.class);
		User user = ac.getBean("user", User.class);
		ValueBean valueBean = ac.getBean("valueBean", ValueBean.class);
		
		// 3. 测试
		System.out.println(sampleBean.getName());
		System.out.println(sampleBean.getFrom());
		System.out.println(sampleBean.getAge());
		// 3.1 List
		System.out.println("\n\t--------\n");
		System.out.println(sampleBean.getSkills().getClass());
		for (String skill: sampleBean.getSkills()) {
			System.out.println(skill);
		}
		// 3.2 Set
		System.out.println("\n\t--------\n");
		System.out.println(sampleBean.getCities().getClass());
		for (String city: sampleBean.getCities()) {
			System.out.println(city);
		}
		// 3.3 Map
		System.out.println("\n\t--------\n");
		System.out.println(sampleBean.getSessions().getClass());
		for (String key : sampleBean.getSessions().keySet()) {
			System.out.println("\tkey="+key+", value="+sampleBean.getSessions().get(key));
		}
		// 3.4 Array
		System.out.println("\n\t--------\n");
		System.out.println(sampleBean.getNumbers().getClass());
		System.out.println(Arrays.toString(sampleBean.getNumbers()));

		// 3.5 Properties
		System.out.println("\n\t--------\n");
		System.out.println(sampleBean.getJdbc().getClass());
		System.out.println(sampleBean.getJdbc());
		System.out.println(sampleBean.getJdbc().get("url"));
		
		// 4.1 通过有参数的构造方法获取对象
		System.out.println("\n\t--------\n");
		System.out.println(user.getClass());
		System.out.println(user);
		
		System.out.println("\n\t--------\n");
		System.out.println(valueBean.getClass());
		System.out.println(valueBean.getName());
		System.out.println(valueBean);
		
		System.out.println(valueBean.getSkill());
		System.out.println(valueBean.getNumber());
		System.out.println(valueBean.getCity());
		System.out.println(valueBean.getPassword());
		// 4. 关闭
		ac.close();
	}
}

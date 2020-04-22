package cn.tedu.mybatis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GroupTests {
	
	private ClassPathXmlApplicationContext ac;
	private GroupMapper mapper;
	
	@Before
	public void doBefore() {
		ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		mapper = ac.getBean("groupMapper", GroupMapper.class);
	}
	@Test
	public void findVOByIdTest() {
		Integer id = 2;
		GroupVO result = mapper.findVOById(id);
		System.out.println(result);
	}
	
	@After
	public void doAfter() {
		ac.close();
	}
}

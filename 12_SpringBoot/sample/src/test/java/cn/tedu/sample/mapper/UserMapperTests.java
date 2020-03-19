package cn.tedu.sample.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.sample.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	@Autowired
	private UserMapper mapper;
	
	@Test
	public void addNewTest() {
		User user = new User();
		user.setUsername("springboot666");
		user.setPassword("1234");
		user.setAge(19);
		user.setPhone("1384383838");
		user.setEmail("spring@tedu.com");
		System.err.println(user);
		Integer rows = mapper.addNew(user);
		System.err.println("rows="+rows);
		System.err.println(user);
	}
}

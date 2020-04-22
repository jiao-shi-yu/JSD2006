package cn.tedu.store;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	@Autowired
	private UserService service;
	
	@Test
	public void reg() {
		User user = new User();
		user.setUsername("spring");
		user.setPassword("1234");
		user.setSalt("0000");
		service.reg(user);
	}
}

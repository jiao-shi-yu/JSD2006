package cn.tedu.store;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	@Autowired
	private UserMapper mapper;
	@Test
	public void addNewTest() {
		User user = new User();
		user.setUsername("project");
		user.setPassword("1234");
		user.setSalt("salt");
		user.setGender(0);
		user.setPhone("1834383838");
		user.setEmail("project@163.com");
		user.setAvatar("avatar");
		user.setIsDelete(0);
		user.setCreatedUser("系统管理员");
		user.setCreatedTime(new Date());
		user.setModifiedUser("超级管理员");
		user.setModifiedTime(new Date());
		Integer rows = mapper.addNew(user);
		System.err.println("rows="+rows);
		System.err.println(user);
	}
	
	@Test
	public void findByUsernameTest() {
		String username = "project";
		User user = mapper.findByUsername(username);
		System.err.println(user);
	}
}

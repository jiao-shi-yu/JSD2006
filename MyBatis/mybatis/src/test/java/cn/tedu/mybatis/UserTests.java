package cn.tedu.mybatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class UserTests {
	MapperScannerConfigurer msc;
	SqlSessionFactoryBean ssfb;
	private ClassPathXmlApplicationContext ac;
	private UserMapper userMapper;
	
	@Before
	public void doBefore() {
		ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		userMapper = ac.getBean("userMapper", UserMapper.class);
	}
	@Ignore
	public void contextLoads() {
		System.out.println("Tests.contextLoads()");
	}
	@Test
	public void getConnection() throws SQLException {
		
		BasicDataSource dataSource = ac.getBean("dataSource", BasicDataSource.class);
		System.out.println(dataSource.getConnection());
	}
	@Ignore
	public void addnew() {
		
		
		
		User user = new User();
		user.setUsername("root115");
		user.setPassword("1234");
		user.setAge(16);
		user.setPhone("12345678901");
		user.setEmail("root@163.com");
		userMapper.addnew(user);
		
		System.out.println("OK");
		
		ac.close();
	}
	@Ignore
	public void deleteById() {
		Integer id = 1;
		Integer rows = userMapper.deleteById(id);
		System.out.println("OK");
		System.out.println("rows: "+rows);
	}
	
	@Ignore
	public void deleteByIdsTest() {
		Integer[] ids = {12, 14, 15};
		Integer rows = userMapper.deleteByIds(ids);
		System.out.println("deleted rows: " + rows);
	}
	
	@Ignore
	public void UpdateEmailByIdTest() {
		Integer id = 3;
		String email = "hahaha@gmail.com";
		
		Integer rows = userMapper.updateEmailById(email, id);
		System.out.println("Tests.UpdateEmailByIdTest(): OK");
		System.out.println("rows: "+rows);
	}
	@Ignore
	public void updatePassword() {
		String newPassword = "HHHHHHHHHH";
		Integer rows = userMapper.updatePassword(newPassword);
		System.out.println("updatePassword:OK");
		System.out.println("rows: "+rows);
	}
	@Ignore
	public void count() {
		Integer count = userMapper.count();
		System.out.println("用户数:"+count);
				
	}
	@Test
	public void findUserByIdTest() {
		Integer id = 11;
		User user = userMapper.findUserById(id);
		System.out.println(user);
		System.out.println("FindUserByIdTest: OK");
	}
	
	@Ignore
	public void findUserByNameTest() {
		String name = "summer";
		User user = userMapper.findUserByName(name);
		System.out.println(user);
		System.out.println("findUserByNameTest:OK");

	}
	@Ignore
	public void findUserByNameAndPasswordTest() {
		String username = "summer";
		String password = "HHHHHHHHHH";
		User user = userMapper.findUserByNameAndPassword(username, password);
		System.out.println("OK!");
		System.out.println(user);
	}
	@Ignore
	public void findAllUsersTest() {
		List<User> users = userMapper.findAllUsers();
		System.out.println("count="+users.size());
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Ignore
	public void findUserOfMaxAgeTest() {
		User user = userMapper.findUserOfMaxAge();
		System.out.println("OK!");
		System.out.println(user);
	}
	@Ignore
	public void findTest() {
		String where = "where username = 'summer'";
		String orderBy = null;
		Integer offset = null;
		Integer count = null;
		List<User> users = userMapper.find(where, orderBy, offset, count);
		System.out.println(users);
	}
	
	@Ignore
	public void findAllTest() {
		List<User> users = userMapper.findAll();
		System.out.println("OK");
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void findUserVOByIdTest() {
		Integer id = 11;
		UserVO userVO = userMapper.findUserVOById(id);
		System.out.println("OK");
		System.out.println(userVO);
	}
	
	
	@After
	public void doAfter() {
		ac.close();
	}
}

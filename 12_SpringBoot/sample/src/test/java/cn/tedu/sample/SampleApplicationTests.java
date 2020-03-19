package cn.tedu.sample;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {
	@Autowired
	DataSource dataSource;
	
	public void contextLoads() {
	}
	@Test
	public void getConnection() throws SQLException {
		System.err.println("dataSource.getConnection()");
	}
}


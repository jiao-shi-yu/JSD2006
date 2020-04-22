package cn.tedu.store;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@MapperScan("cn.tedu.store.Mapper")
@RunWith(SpringRunner.class)
@SpringBootTest
class StoreApplicationTests {
	
	@Autowired DataSource dataSource;
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getConnectionTest() throws SQLException {
		System.err.println(dataSource.getConnection());
	}
}

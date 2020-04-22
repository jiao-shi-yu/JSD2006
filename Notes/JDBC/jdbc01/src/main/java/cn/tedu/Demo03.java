package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class Demo03 {
	Connection conn;
	// 与数据库软件建立连接
	@Before
	public void getConn() throws SQLException {
		// 从驱动管理器获得连接
		conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/newdb3", "root", "uiop7890");
	}
	
	
	// 增
	@Ignore
	@Test
	public void insert() throws SQLException {
		System.out.println("insert");
		// 创建SQL执行对象
		Statement statement = conn.createStatement();
		// 准备SQL语句
		String sql = "INSERT INTO emp(empno, ename) VALUES(100, 'Tom')";
		// 执行SQL语句
		statement.executeUpdate(sql);
	}
	
	// 删
	@Ignore
	@Test
	public void delete() throws SQLException {
		System.out.println("开始删除");
		Statement statement = conn.createStatement();
		String sql = "DELETE FROM emp WHERE empno = 100";
		statement.executeUpdate(sql);
	}
	
	// 改
	@Ignore
	@Test
	public void update() throws SQLException {
		System.out.println("将编号为50的员工的姓名改为'Jerry'");
		Statement statement = conn.createStatement();
		String sql = "UPDATE emp SET ename = 'Jerry' WHERE empno = 5";
		statement.executeUpdate(sql);
	}
	// 查
	@Test
	public void select() throws SQLException {
		System.out.println("开始查询");
		Statement statement = conn.createStatement();
		String sql = "SELECT sal, ename FROM emp";
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString(2);
			double sal = rs.getDouble(1);
			System.out.println(name + ":\t" + sal);
		}
	}
	@After
	public void close() throws SQLException {
		System.out.println("操作完成");
		conn.close();
	}
	
	
	
	
	
}

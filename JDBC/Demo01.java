package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {

	public static void main(String[] args) throws SQLException {
		// 5.0之后的版本会自动处理注册驱动，不需要写Class.forName.
		// Class.forName("com.mysql.jdbc.Driver");
		
		// 获取数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb3", "root", "uiop7890");
		System.out.println(conn);
		
		// 创建执行SQL语句的对象
		Statement s = conn.createStatement();
		
		// 编写SQL
		String sql = "CREATE TABLE jdbct1(id INT, name VARCHAR(10))";
		// 执行
		s.execute(sql);
		System.out.println("执行完成");
		// 关闭资源
		conn.close();
	}
}

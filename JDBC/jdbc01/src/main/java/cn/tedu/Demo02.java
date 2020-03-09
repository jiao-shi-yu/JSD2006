package cn.tedu;
/**
 * 本示例展示如何删除一张表
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		// 获取连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/newdb3",
				"root",
				"uiop7890"
				);
		
		// 创建SQL执行对象
		Statement s = conn.createStatement();
		String sql = "DROP TABLE jdbct1";
		s.execute(sql);
		System.out.println("执行完成");
		
		// 关闭资源
		conn.close();
	}
}

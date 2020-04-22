package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

public class Demo05 {
	public static void main(String[] args) {
		// 获取数据库连接
		try (Connection conn = DBUtils.getConn()){
			String sql1 = "INSERT INTO user VALUES(NULL, 'aaa', '111')";
			String sql2 = "INSERT INTO user VALUES(NULL, 'bbb', '222')";
			String sql3 = "INSERT INTO user VALUES(NULL, 'ccc', '333')";
			
			Statement statement = conn.createStatement();
			// 将SQL语句添加到批量操作
			statement.addBatch(sql1);
			statement.addBatch(sql2);
			statement.addBatch(sql3);
			// 执行批量操作
			statement.executeBatch();
			System.out.println("执行完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

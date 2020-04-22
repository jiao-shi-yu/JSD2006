package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo06 {

	public static void main(String[] args) {
		try (Connection conn = DBUtils.getConn()) {
			// 获取数据库软件
			String sql = "INSERT INTO user VALUES (null, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 1; i <= 100; i++) {
				// 替换用户名,密码
				ps.setString(1, "name"+i);
				ps.setString(2, "pwd"+i);
				// 添加到批量操作
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

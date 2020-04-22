package cn.tedu;
/**
 * 这个Demo演示如何解决SQLInjection
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo0402 {
	public static void main(String[] args) throws SQLException {
		// 获取输入的用户名和密码
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名"); // 用户名，空就好
		String username = sc.nextLine();
		System.out.println("请输入密码"); // 在这里输入 ' OR 'a'='a
		String password = sc.nextLine();
		
		try (Connection conn = DBUtils.getConn();) {
			String sql = "SELECT COUNT(*) FROM user WHERE username=? AND password=?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				int count = rs.getInt(1);
				if (count>0) {
					System.out.println("登陆成功");
				} else {
					System.out.println("登录失败");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

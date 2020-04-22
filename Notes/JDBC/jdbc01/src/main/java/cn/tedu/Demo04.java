package cn.tedu;
/**
 * 演示SQLInjection

1. mysql中新建表 CREATE TABLE user(id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(10), password VARCHAR(10));
2. 插入两条数据 INSERT INTO user VALUES (NULL, 'xiaoming', 'hahaha'), (NULL, 'xiaohong', 'xixixi');

3. Eclipse 控制台中，
请输入用户名

请输入密码
' OR 'a'='a
xiaoming	:	hahaha
xiaohong	:	xixixi
完成

 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) throws SQLException {
		// 获取输入的用户名和密码
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名"); // 用户名，空就好
		String username = sc.nextLine();
		System.out.println("请输入密码"); // 在这里输入 ' OR 'a'='a
		String password = sc.nextLine();
		
		try (Connection conn = DBUtils.getConn();) {
			String sql = "SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String uname = rs.getString(1);
				String pwd = rs.getString(2);
				System.out.println(uname+"\t:\t"+pwd);
			}
			System.out.println("完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

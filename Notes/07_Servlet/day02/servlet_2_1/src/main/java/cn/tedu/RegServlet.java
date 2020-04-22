package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 请求中包含中文，需要设置字符集
		req.setCharacterEncoding("UTF-8");
		
		// 获取传过来的参数
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		System.out.println(name+":"+pwd);
		
		// 获取数据库连接
		
		try (Connection conn = DBUtils.getConn()){
			String sql = "INSERT INTO user VALUES (null, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ps.executeUpdate();
			
			System.out.println("执行到这里，说明SQL语句成功执行了呢");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

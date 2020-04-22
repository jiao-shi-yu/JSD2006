package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 网页请求部分
		 * 
		 * 可以在处理网页请求部分，就把response设置好，并获得printWriter
		 */
		// 设置字符集
		request.setCharacterEncoding("UTF-8");
		// 从请求中获取参数
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		System.out.println(name + ":" + pwd);
		
		// 设置相应类型 
		// request的CharacterEncoding与response的ContentType里面的charset都是utf-8.
		response.setContentType("text/html;charset=utf-8");

		/**
		 * 数据库部分
		 * conn是数据库的连接，不是网页的连接。
		 */
		try (Connection conn = DBUtils.getConn()){
			String sql = "SELECT COUNT(*) FROM user WHERE name = ? AND pwd = ?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			ResultSet rs = pStatement.executeQuery();
			
			while (rs.next()) {
				int count = rs.getInt(1);
				if (count > 0) {
					response.getWriter().println("登录成功");
				} else {
					response.getWriter().println("用户名或密码错误");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		HttpServletRequest 请求对象
		HttpServletResponse 响应对象
		resp.setContentType 设置响应类型, 内容类型 和 字符集
		 */
		
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw.print("<h1>Hello World!</h1>");
		pw.close();
	}
}

package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SayHelloServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取传递过来的参数
		String name = req.getParameter("name");
		System.out.println("Hello,"+name);
		// 设置响应类型
		resp.setContentType("text/html;charset=UTF-8");
		// 得到输出对象
		PrintWriter pw = resp.getWriter();
		pw.println("你好,"+name+"!");
		pw.close();
	}

	
}

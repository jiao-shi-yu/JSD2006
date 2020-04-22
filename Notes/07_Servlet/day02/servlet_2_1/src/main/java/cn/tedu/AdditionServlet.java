package cn.tedu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdditionServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num1Str = req.getParameter("num1");
		String num2Str = req.getParameter("num2");
		
		double num1 = Double.parseDouble(num1Str);
		double num2 = Double.parseDouble(num2Str);
		
		double sum = num1 + num2;
		
		resp.setContentType("text/html;charset=UTF-8");
		
		resp.getWriter().print(num1 + " + " + num2 +" = " + sum);
		
	}
}
	
package cn.tedu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取传递过来的参数
		String empno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		String sal = request.getParameter("sal");
		System.out.println(empno+":"+ename+":"+sal);
		
		// 封装三个参数到Empty对象中
		Emp emp = new Emp(Integer.parseInt(empno), ename, Double.parseDouble(sal));
		
		// 调用 数据访问对象 中的方法， 把emp实例传递过去。
		EmpDao dao = new EmpDao();
		dao.insert(emp);
		
		
		
		
		
		
		
	}

}

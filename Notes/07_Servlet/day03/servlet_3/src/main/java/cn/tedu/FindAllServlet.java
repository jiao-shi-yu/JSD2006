package cn.tedu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindAllServlet
 */
public class FindAllServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 需要从数据中查询所有员工信息
		// 所以创建EmpDao
		EmpDao empDao = new EmpDao();
		List<Emp> emps = empDao.findAll();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<table border='1'>");
		pw.print("<tr><th>编号</th><th>姓名</th><th>工资</th></tr>");
		
		for (Emp emp : emps) {
			pw.print("<tr><td>"+emp.getEmpno()+"</td><td>"+emp.getEname()+"</td><td>"+emp.getSal()+"</td></tr>");
		}
		pw.print("</table>");
		pw.close();
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HeroDAO;
import entity.Hero;

/**
 * Servlet implementation class FindAllServlet
 */
public class FindAllServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HeroDAO heroDAO = new HeroDAO();
		List<Hero> heros = heroDAO.findAll();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("<table border='1'>");
		pw.print("<tr><th>id</th><th>姓名</th><th>类型</th><th>性别</th><th>价格</th><th>操作</th></tr>");
		
		for (Hero hero : heros) {
			pw.print("<tr><td>"+hero.getId()+"</td>");
			pw.print("<td>"+hero.getName()+"</td>");
			pw.print("<td>"+hero.getType()+"</td>");
			pw.print("<td>"+hero.getGender()+"</td>");
			pw.print("<td>"+hero.getPrice()+"</td>");
			pw.print("<td><a href='DeleteServlet'>删除</a></td></tr>");
		}
		
		pw.print("</table>");
		
	}

	

}

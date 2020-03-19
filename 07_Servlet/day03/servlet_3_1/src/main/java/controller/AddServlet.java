package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HeroDAO;
import entity.Hero;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String gender = request.getParameter("gender");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Hero hero = new Hero(0, name, type, gender, price);
		
		HeroDAO heroDAO = new HeroDAO();
		
		heroDAO.insert(hero);
		
	}


}

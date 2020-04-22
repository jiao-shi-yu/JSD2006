package cn.tedu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AIServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String info = req.getParameter("info");
		// NOTE: info = info.replace(a, b)
		info = info.replace("吗", "");
		info = info.replace("?", "!");
		info = info.replace("我", "我也");
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().println(info);
	}

}

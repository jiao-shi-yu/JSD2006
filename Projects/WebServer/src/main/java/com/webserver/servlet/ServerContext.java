package com.webserver.servlet;

import java.util.HashMap;
import java.util.Map;

public class ServerContext {
	public static Map<String, HttpServlet> servletMapping = new HashMap<>();
	
	static {
		initServletMapping();
	}
	private static void initServletMapping() {
		servletMapping.put("/myweb/reg", new RegServlet());
		servletMapping.put("/myweb/login", new LoginServlet());
		servletMapping.put("/myweb/createQR", new CreateQRServlet());
		servletMapping.put("/myweb/userList", new UserListServlet());
	}
	/**
	 * 根据请求路径获取对应的 Servlet
	 * @param path 请求路径
	 * @return 对应的 Servlet
	 */
	public static HttpServlet getServlet(String path) {
		return servletMapping.get(path);
	}
}



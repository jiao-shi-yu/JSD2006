package com.webserver.servlet;

import java.io.RandomAccessFile;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class LoginServlet extends HttpServlet {
	
	public void service(HttpRequest request, HttpResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + " " +  password);
		
		if (username == null || password == null  ||
				username.contains("+") || password.contains("+")) {
			String filePath = "./webapps/root/invalid_args.html";
			forward(filePath, request, response);
			return;
		}
		try (RandomAccessFile raf = new RandomAccessFile("user.dat", "r")){
			
			for (int i = 0; i < raf.length()/100; i++) {
				raf.seek(i*100);
				byte[] bytes = new byte[32];
				raf.read(bytes);
				String usernameFromFile = new String(bytes, "UTF-8").trim();
				if (usernameFromFile.equals(username)) {
					raf.read(bytes);
					String passwordFromFile = new String(bytes, "UTF-8").trim();
					if (passwordFromFile.equals(password)) {
						// 登录成功，响应页面
						System.out.println("\n\n\t >---> 登录成功 <---<\n\n");
						String filePath = "./webapps/root/login_succeed.html";
						forward(filePath, request, response);
						return;
					}
					break;
				}
			}
			String filePath = "./webapps/root/login_failed.html";
			forward(filePath, request, response);
			
		
		} catch (Exception e) {
		}
	}
	
}

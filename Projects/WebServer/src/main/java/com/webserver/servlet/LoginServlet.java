package com.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class LoginServlet {
	
	public void service(HttpRequest request, HttpResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username + " " +  password);
		
		if (username == null || password == null  ||
				username.contains("+") || password.contains("+")) {
			File invalidArgsPage = new File("./webapps/root/invalid_args.html");
			response.setEntity(invalidArgsPage);
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
						File loginSucceedPage = new File("./webapps/root/login_succeed.html");
						response.setEntity(loginSucceedPage);
						return;
					}
					break;
				}
			}
			File loginFailedPage = new File("./webapps/root/login_failed.html");
			response.setEntity(loginFailedPage);
		
		} catch (Exception e) {
		}
	}
	
}

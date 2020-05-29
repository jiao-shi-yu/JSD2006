package com.webserver.core;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;
import com.webserver.servlet.HttpServlet;
import com.webserver.servlet.ServerContext;

public class ClientHandler implements Runnable {
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
	    try {
	        // 1. 解析请求
	        HttpRequest request = new HttpRequest(socket);
	        //   2.x 实例化一个响应
	        HttpResponse response = new HttpResponse(socket);
	        // 2. 处理请求
	        String path = request.getRequestURI();
	        System.out.println("-------------> path: " + path);
	        
	        HttpServlet servlet = ServerContext.getServlet(path);
	        System.out.println("servlet: " + servlet);
	        // 判断请求的是否为一个业务
	        if (servlet != null) { // 注册业务
	        	servlet.service(request, response);
	        } else { // 请求静态资源
	        	
		        File file = new File("./webapps" + path);
		        if (file.exists()) {
		            System.out.println("该资源已经找");
		           
		            response.setEntity(file);
		         
		            
		        } else {
		            System.out.println("该资源不存在");
		            
		            // 设置状态码和状态描述
		            response.setStatusCode(404);
		            response.setStatusReason("NOT FOUND");
		            
		            // 准备一个 404 页面
		            File notFoundPage = new File("webapps/root/404.html");
		            response.setEntity(notFoundPage);
		        }
		       
	        }
	        
	        // 3. 响应客户端
	        response.flush();

	        
	    } catch (Exception e) {
	    } finally {
	    	// 最终和客户端断开连接
	    	try {
	    		socket.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }
	}
}

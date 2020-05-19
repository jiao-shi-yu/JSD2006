package com.webserver.core;

import java.net.Socket;

import com.webserver.http.HttpRequest;

public class ClientHandler implements Runnable {
	private Socket socket;
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			// 1. 解析请求
			HttpRequest request = new HttpRequest(socket);
			// 2. 处理请求
			
			// 3. 响应客户端
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

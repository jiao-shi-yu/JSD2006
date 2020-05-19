package com.webserver.core;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private ServerSocket serverSocket;

	public WebServer() {
		try {
			System.out.println("正在启动服务端");
			serverSocket = new ServerSocket(8088);
			System.out.println("服务端启动完毕\n");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void start() {
		try {
			System.out.println("等待客户端连接……");
			Socket socket = serverSocket.accept();
			System.out.println("一个客户端连接成功\n");
			
			// 启动一个 handler 处理请求
			ClientHandler handler = new ClientHandler(socket);
			Thread handlerThread = new Thread(handler);
			handlerThread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.start();
	}
}  

package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个请求分为三部分：
 * 请求行
 * 消息头
 * 消息正文
 * @author yuyu
 *
 */
public class HttpRequest {
	/*
	 * 请求行相关信息
	 */
	private String method;
	private String uri;
	private String protocol;
	
	/*
	 * 消息头相关信息
	 */
	private Map<String, String> headers = new HashMap<>();
	/*
	 * 消息正文相关信息
	 */
	
	/*
	 * 与客户端连接，相关的信息
	 */
	private Socket socket;
	// 通过客户端获取的输入流，用于读取客户信息。
	private InputStream in;
	
	/**
	 * 构造方法，用于初始化一个 Request 对象
	 */
	public HttpRequest(Socket socket) {
		this.socket = socket;
		try {
			this.in = this.socket.getInputStream();
			parseRequestLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 通过输入流获取到的文本，经过解析，解析为请求行、消息头、消息正文三部分，
		// 赋值给属性，封装到 HttpRequest 对象中。
		
		parseHeaders();
		parseContent();
	}
	
	/**
	 * 解析请求行
	 */
	private void parseRequestLine() throws EmptyRequestException {
		System.out.println("开始解析请求行");
		
		try {
			String line = readLine();
			if (line.isEmpty()) {
				throw new EmptyRequestException();
			}
			System.out.println(line);
			String[] arr = line.split("\\s");
			this.method = arr[0];
			this.uri = arr[1];
			this.protocol = arr[2];
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("method: " + method);
		System.out.println("url: " + uri);
		System.out.println("protocol: " + protocol);
		
		System.out.println("完成解析请求行\n");
	}
	
	/**
	 * 解析消息头
	 */
	private void parseHeaders() {
		System.out.println("开始解析消息头");
		try {
			
			while(true) {
				String line = readLine();
				if ("".equals(line)) {
					break;
				}
				String[] data = line.split(": ");
				headers.put(data[0], data[1]);
			}
			System.out.println("headers: " + headers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("完成解析消息头\n");
	}
	
	
	/**
	 * 解析消息正文
	 */
	private void parseContent() {
		System.out.println("开始解析消息正文");
		System.out.println("完成解析消息正文\n");
	}
	
	/**
	 * 	从输入流读取一行字符串，并返回
	 * @throws IOException 
	 */
	private String readLine() throws IOException {
		int d = -1; 
		StringBuilder builder = new StringBuilder();
		while ((d = in.read())!=-1) { // 一直读到 文件末尾 EOF
			char chr = (char)d;
			/* 如果读到行尾，就break; 
			 * 一开始，是不会读到 crlf 的
			 * 
			 * 要确保 builder.length() - 1 >= 0
			 */
		
			if(builder.length()!=0&&builder.charAt(builder.length()-1)==13&&chr==10) {
				break;
			}
			builder.append(chr);
		}
		return builder.toString().trim();
	}

	public String getMethod() {
		return method;
	}

	public String getUri() {
		return uri;
	}

	public String getProtocol() {
		return protocol;
	}
	
	
	public String getHeader(String name) {
		return headers.get(name);
	}
	
	
	
	
}

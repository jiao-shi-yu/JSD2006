package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class HttpResponse {
	private Socket socket;
	private OutputStream outputStream;

	/*
	 * 状态码和状态描述
	 */
	private int statusCode = 200;
	private String statusReason = "OK";
	
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	/*
	 * 响应正文的实体文件
	 */
	private File entity;
	public void setEntity(File file) {
		this.entity = file;
	}
	public HttpResponse(Socket socket) {
		try {
			this.socket = socket;
			this.outputStream = this.socket.getOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向客户端发送一个标准的 HTTP 响应
	 */
	public void flush() {
		try {
			sendStatusLine();
			sendHeaders();
			sendContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 发送状态行
	private void sendStatusLine() throws UnsupportedEncodingException, IOException {
		String statusLine = "HTTP/1.1 " + statusCode + " " + statusReason;
		outputStream.write(statusLine.getBytes("ISO8859-1"));
		writeCRLF();
	}
	
	// 发送响应头
	private void sendHeaders() throws UnsupportedEncodingException, IOException {
		String header1 = "Content-Type: text/html";
		outputStream.write(header1.getBytes("ISO8859-1"));
		writeCRLF();
		String header2 = "Content-Size: " + entity.length();
		outputStream.write(header2.getBytes("ISO8859-1"));
		writeCRLF();
		writeCRLF();
	}
	
	// 发送响应正文
	private void sendContent() throws IOException {
		FileInputStream fis = new FileInputStream(entity);
		int len = -1;
		byte[] bytes = new byte[1024*10];
		while((len = fis.read(bytes))!=-1) {
			outputStream.write(bytes, 0, len);
		}
		fis.close(); // 秒啊 异常链形成
	}
	
	// 输出回车换行
	private void writeCRLF() throws IOException {
		outputStream.write(13);
		outputStream.write(10);
	}
	
}

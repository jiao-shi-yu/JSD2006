package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;



import static com.webserver.http.HttpContext.CR;
import static com.webserver.http.HttpContext.LF;

public class HttpResponse {
	private Socket socket;
	private OutputStream outputStream;
	
	/*
	 * 状态行相关
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
	 * 响应行相关 
	 */
	private Map<String, String> headers = new HashMap<>();
	
	/**
	 * 向 headers 中添加一些 响应头 
	 * @param name
	 * @param value
	 */
	public void putHeader(String name, String value) {
		this.headers.put(name, value);
	}
	
	/*
	 * 响应正文的实体文件
	 */
	private File entity;
	public void setEntity(File file) {
        // 获取响应正文的 mime 类型
        String fileName = file.getName();
        System.out.println("fileName: >--------> " + fileName);
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println("fileSuffix: >--------> " + extension);
        String mimeType = HttpContext.getMimeType(extension);
        // 响应正文的类型和长度
        putHeader("Content-Type", mimeType);
        putHeader("Content-Length", file.length() + "");
		this.entity = file;
	}
	/**
	 * 字节数组，可以直接响应
	 * 在 {@link #sendContent()} 响应
	 */
	private byte[] content;
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
		putHeader("Content-Length", content.length+"");
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
	private void sendStatusLine() {
		try {
			String statusLine = "HTTP/1.1 " + statusCode + " " + statusReason;
			outputStream.write(statusLine.getBytes("ISO8859-1"));
			writeCRLF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 发送响应头
	private void sendHeaders() throws UnsupportedEncodingException, IOException {
		/*
		 * 遍历 headers， 发送响应头
		 */
		for (Map.Entry<String, String> header : headers.entrySet()) {
			String name = header.getKey();
			String value = header.getValue();
			String line = name + ": " + value;
			// System.out.println("\n\n\n\n\n ----->" + line + "\n\n\n");
			outputStream.write(line.getBytes("ISO8859-1"));
			writeCRLF();
		}
		// 单独一个 CRLF，表示响应头结束
		writeCRLF();
	}
	private void writeCRLF() throws IOException {
		outputStream.write(CR);
		outputStream.write(LF);
	}
	
	// 发送响应正文
	private void sendContent() {
		if (content!=null) {
			try {
				outputStream.write(content); // content 是字节数组
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else if (entity!=null) {
			try(FileInputStream fis = new FileInputStream(entity);) {
				System.out.println("开始发送响应正文");
				int len = -1;
				byte[] bytes = new byte[1024*10];
				while((len = fis.read(bytes))!=-1) {
					outputStream.write(bytes, 0, len);
				}
				System.out.println("响应正文发送完毕");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}

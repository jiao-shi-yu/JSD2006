package com.webserver.servlet;

import java.io.ByteArrayOutputStream;

import com.webserver.http.HttpContext;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import qrcode.QRCodeUtil;

public class CreateQRServlet {
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("开始生成二维码");
		String content = request.getParameter("content");
		System.out.println("\n\n -------> 二维码内容:" + content);
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			QRCodeUtil.encode(content, null, baos, true);
			
			response.setContent(baos.toByteArray());
			response.putHeader("Content-Type", HttpContext.getMimeType("jpg"));
		} catch (Exception e) {
		}
		System.out.println("完成生成二维码");
	}
}

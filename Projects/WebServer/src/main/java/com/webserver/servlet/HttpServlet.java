package com.webserver.servlet;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public abstract class HttpServlet {
	/**
	 * 处理业务
	 * @param request 请求对象
	 * @param response 响应对象
	 */
	public abstract void service(HttpRequest request, HttpResponse response);
	/**
	 * 跳转到指定路径对应的资源
	 * @param path
	 * @param request
	 * @param response
	 */
	public void forward(String path, HttpRequest request, HttpResponse response) {
		
	}
}

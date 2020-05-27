package com.webserver.servlet;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import com.webserver.http.HttpContext;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class UserListServlet extends HttpServlet {
	public void service(HttpRequest request, HttpResponse response) {
		
		System.out.println("UserListServlet: 开始显示所有用户");
		
		try (RandomAccessFile raf =  new RandomAccessFile("user.dat", "r")) {
			List<Map<String, String>> list = new ArrayList<>();
			
			for (int i = 0; i < raf.length()/100; i++) {
				// 读取四条信息到 user 中
				Map<String, String> user = new HashMap<>();
				byte[] bytes = new byte[32];
				raf.read(bytes);
				String username = new String(bytes, "UTF-8").trim();
				user.put("username", username);
				raf.read(bytes);
				String password = new String(bytes, "UTF-8").trim();
				user.put("password", password);
				raf.read(bytes);
				String nickname = new String(bytes, "UTF-8").trim();
				user.put("nickname", nickname);
				int age = raf.readInt();
				user.put("age", age+"");
				System.out.println(user);
				// list 中添加一个用户
				list.add(user);
			}
			
			/*开始使用 Thymeleaf 动态生成页面*/
			
			// Context 用来保存数据
			Context context = new Context();
			context.setVariable("users", list); //存入一条数据
			
			// 文件模板解析器
			FileTemplateResolver templateResolver = new FileTemplateResolver();
			// 指定模板页面模式
			templateResolver.setTemplateMode("html");
			// 指定字符集
			templateResolver.setCharacterEncoding("UTF-8");
			
			// 创建模板引擎
			TemplateEngine engine = new TemplateEngine();
			
			// 模板引擎设置模板解析器
			engine.setTemplateResolver(templateResolver);
			
			/* 得到 html 中的字符串 */
			String html = engine.process("./webapps/myweb/userList.html", context);
			System.out.println(html);
			
			// 转换成字节数组
			byte[] data = html.getBytes("UTF-8");
			// 响应字节数组
			
			response.setContent(data);
			response.putHeader("Content-Type", HttpContext.getMimeType("html"));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("显示用户完毕");
	}
}

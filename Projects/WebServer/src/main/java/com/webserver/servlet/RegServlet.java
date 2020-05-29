package com.webserver.servlet;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

public class RegServlet extends HttpServlet {
	
	public void service(HttpRequest request, HttpResponse response) {
		System.out.println("\nRegServlet: 开始处理用户的注册请求");
		
		
		// 1. 获取注册信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		
		/*判断用户输入是否合法*/
		
		if (username == null || password == null || nickname == null ||
				username.contains("+") || password.contains("+") || nickname.contains("+")) {
			File invalidArgsPage = new File("./webapps/root/invalid_args.html");
			response.setEntity(invalidArgsPage);
			return;
		}
		
		int age = Integer.parseInt(request.getParameter("age"));

		System.out.println(">----------> username: " + username);
		
		
		
	
		try (RandomAccessFile raf = new RandomAccessFile("user.dat", "rw");){
			
			// before 2: 判断用户名是否已经存在
			boolean alreadyExist = false;
			for (int i=0; i < raf.length()/100; i++) {
				raf.seek(i*100);
				// 读取 32 个字节，以获取用户名
				byte[] bytes = new byte[32];
				raf.read(bytes); // <-- BUG! Fixed!
//				System.out.println("bytes: " + Arrays.toString(bytes));
				String usernameFromFile = new String(bytes, "UTF-8").trim();
//				System.out.println(">----------> usernameFromFile: " + usernameFromFile);
				if (usernameFromFile.equals(username)) {
					alreadyExist = true;
					break;
				}
			}
			// 如果用户名已存在，跳转到 alreadyExist.html 页面
			if (alreadyExist) {
				// 设置 alredayExist 页面
				forward("./webapps/root/alreadyExist.html", request, response);
	
			} else  { // 正常注册			
				// 2. 存储注册信息
				
				// 将指针移动到文件末尾
				raf.seek(raf.length());
				// 写用户名
				byte[] bytes = username.getBytes("UTF-8");
				bytes = Arrays.copyOf(bytes, 32);
				raf.write(bytes);
				// 写密码
				bytes = password.getBytes("UTF-8");
				bytes = Arrays.copyOf(bytes, 32);
				raf.write(bytes);
				// 昵称
				bytes = nickname.getBytes("UTF-8");
				bytes = Arrays.copyOf(bytes, 32);
				raf.write(bytes);
				// 年龄
				raf.writeInt(age);	
				raf.close();
				// 3. 设置响应
				forward("./webapps/root/regSuccess.html", request, response);
				
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("RegServlet: 处理完成用户的注册请求\n");
	}
	
}

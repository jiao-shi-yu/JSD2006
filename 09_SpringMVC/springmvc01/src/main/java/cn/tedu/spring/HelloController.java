package cn.tedu.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController.HelloServlet()");
	}
	
	@RequestMapping("hello.do")
	public String showHello() {
		System.out.println("HelloController.showHello()");
		/**
		 * 显示页面：
		 * 
		 * prefix + return value + suffix
		 * "templates/" + "hello" + ".html"
		 * "templates/hello.html"
		 */

		return "hello";
	}
}

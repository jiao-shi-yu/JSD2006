package cn.tedu.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TestController {
	@RequestMapping("test.do")
	@ResponseBody
	public String showTest() {
		System.out.println("UserController.showTest()");
		
		return "{\"username\":\"张三\", \"password\":\"1234\"}";
	}
	
	
	@RequestMapping("user.do")
	@ResponseBody
	public User showUser() {
		System.out.println("UserController.showUser()");
		User user = new User("张三", "1234", 13, "1384383838", "root@tedu.com");
		return user;
	}
}

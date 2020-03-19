package cn.tedu.spring;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
	public UserController() {
		System.out.println("UserController.UserController()");
	}
	
	@RequestMapping({"reg.do", "register.do"})
	public String showRegister() {
		System.out.println("UserController.showRegister()");
		return "reg";
	}
	
	@RequestMapping("handle_register.do")
	@ResponseBody
	public String HandleRegister(User user) {
		
		System.out.println("\t[4.3] " + user);
		
		// 暂不关心后续的显示
		return "OK";
	}
	
	
	@RequestMapping(path="login.do")
	public String showLogin() {
		System.out.println("UserController.showLogin()");
		return "login";
	}
	
	@RequestMapping(path="handle_login.do", method=RequestMethod.POST)
	public String HandleLogin(String username, String password, ModelMap map, HttpSession session) {
		System.out.println("username="+username);
		System.out.println("password="+password);
		
		if ("root".equals(username)) {
			if ("1234".equals(password)) {
				// 登陆成功，返回主页
				session.setAttribute("loginUsername", username);
				return "redirect:index.do";
			} else {
				// 登录失败，密码错误
				String message = "登录失败，密码错误！";
				map.addAttribute("errorMessage", message);
				return "error";
			}
		} else {
			// 登录失败，用户名错误
			String message = "登录失败，用户名错误！";
			map.addAttribute("errorMessage", message);
			return "error"; // 转发到error对应的页面
		}
	
	}
	
	
}

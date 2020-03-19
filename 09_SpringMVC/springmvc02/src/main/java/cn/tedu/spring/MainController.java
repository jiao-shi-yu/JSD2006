package cn.tedu.spring;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class MainController {
	@RequestMapping("index.do")
	public String showIndex(HttpSession session) {
		
		System.out.println("MainController.showIndex()");
		System.out.println("\tsession.username=root");
		return "index";
	}
}

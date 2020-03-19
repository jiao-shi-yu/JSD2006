package cn.tedu.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@RequestMapping("login.do")
	@ResponseBody
	public JsonResult login(String username, String password) {
		JsonResult jsonResult = new JsonResult();
		if ("root".equals(username)) {
			if ("1234".equals(password)) {
				jsonResult.setState(1);
			} else {
				jsonResult.setState(3);
			}
		} else {
			jsonResult.setState(2);
		}
		return jsonResult;
	}
}

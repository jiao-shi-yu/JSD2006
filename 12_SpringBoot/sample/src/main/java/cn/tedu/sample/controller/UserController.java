package cn.tedu.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.sample.JsonResult;
import cn.tedu.sample.User;
import cn.tedu.sample.mapper.UserMapper;

@RestController
public class UserController {
	@Autowired
	private UserMapper userMapper;
	// http://localhost:9999/hello
	@RequestMapping("hello")
	public String hello() {
		return "欢迎使用SpringBoot框架处理客户端请求！！";
	}
	@PostMapping("reg")
	public JsonResult reg(User userOfRequest) {
		User userOfDB = userMapper.findUserByName(userOfRequest.getUsername());
		System.err.println(userOfDB);
		if (userOfDB == null) { // 数据库中不存在 注册成功 数据库中添加用户信息
			userMapper.addNew(userOfRequest);
			return new JsonResult(1);
		} else { // 该用户名已经注册过了 注册失败
			return new JsonResult(2);
		}
	}
}

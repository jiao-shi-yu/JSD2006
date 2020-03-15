package cn.tedu.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user")
@Scope("singleton")
@Lazy
public class User {
	public User() {
		System.out.println("\tUser.user()");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("\tUser.init()");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("\tUser.destroy()");
	}
	
}

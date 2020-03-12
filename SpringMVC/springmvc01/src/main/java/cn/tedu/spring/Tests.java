package cn.tedu.spring;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Component
public class Tests {
	DispatcherServlet ds;
	ThymeleafViewResolver tvr;
	SpringTemplateEngine ste;
	ClassLoaderTemplateResolver cltr;
	public Tests() {
		System.out.println("Tests.Tests()");
	}
}

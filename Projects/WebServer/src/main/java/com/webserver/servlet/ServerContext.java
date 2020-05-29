package com.webserver.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServerContext {
	public static Map<String, HttpServlet> servletMapping = new HashMap<>();
	
	static {
		initServletMapping();
	}
	private static void initServletMapping() {
		/**
		 * 使用 DOM4J 解析 contf/servlets.xml文件
		 * 得到根标签下的所有<servlet> 标签
		 * path: 作为 mMap 的 key
		 * className 的值，得到后使用反射实例化对应的 Servlet 对象
		 * 将 servlet 对象作为 value 存入 Map.
		 */
		// 1. 获取SAXReader
		SAXReader reader = new SAXReader();
		try {
			// 2. 通过 reader 获取 Document 对象
			Document doc = reader.read("conf/servlets.xml");
			// 3. 通过 document 获取 根元素
			Element root = doc.getRootElement();
			System.out.println("\n\n\n" + root + "\n\n\n");
			// 4. 通过根元素，获取子级元素列表
			@SuppressWarnings("unchecked")
			List<Element> servlets = root.elements("servlet");
			// 5. 遍历子级元素列表，获取所需要的属性值或标签文本
			for (Element servletElement : servlets) {
				String path = servletElement.attributeValue("path");
				String className = servletElement.attributeValue("className");
				/*利用反射, 实例化 Servlet */
				Class<?> clazz = Class.forName(className);
				HttpServlet servlet = (HttpServlet) clazz.newInstance();
				// 向 Map 中 put key, value
				servletMapping.put(path, servlet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 根据请求路径获取对应的 Servlet
	 * @param path 请求路径
	 * @return 对应的 Servlet
	 */
	public static HttpServlet getServlet(String path) {
		return servletMapping.get(path);
	}
}



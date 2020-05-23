package com.webserver.http;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class HttpContext {
	private static final Map<String,String> mimeMapping = new HashMap<>();
	public static final char CR = 13;
	public static final char LF = 10;
	static {
		initMimeMapping();
	}
	/**
	 * 初始化文件后缀与媒体类型的映射
	 */
	private static void initMimeMapping() {
       /*
        * 解析 conf/web.xml 文件
        * 获取根标签
        * 获取多个子标签 <mime-mapping>, 用 list 存储，它有两个子标签 <extension> 和 <mime-type>
        * 将 <extension> 中的文本作为 key, <mime-type> 中的文本作为 value, put 到 headers 中
        */
		SAXReader reader = new SAXReader();
		Document doc;
		try {
			doc = reader.read(new File("conf/web.xml"));
			Element root = doc.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> maps = root.elements("mime-mapping");
			for (Element mapping : maps) {
				String key = mapping.elementTextTrim("extension");
				String value = mapping.elementTextTrim("mime-type");
				mimeMapping.put(key, value);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static String getMimeType(String extension) {
		return mimeMapping.get(extension);
	}
	public static void main(String[] args) {
		System.out.println(mimeMapping.size());
		String mimeType = HttpContext.getMimeType("png");
		System.out.println(mimeType);
	}
}

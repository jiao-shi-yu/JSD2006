package xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXMLDemo {
	public static void main(String[] args) {
		// 1. 创建 SAXReader
		SAXReader reader = new SAXReader();
		try {
			// 2. 读取 XML 文件
			Document document = reader.read(new File("emplist.xml"));
			// 3. 获取根元素
			Element root = document.getRootElement();
			// 4. 通过根元素获取子级元素集合
			List<Element> elements = root.elements("emp");
			for (Element empElement : elements) {
				// 获取姓名
				Element nameElement = empElement.element("name");
				String name = nameElement.getTextTrim();
				System.out.println(name);
				// 获取年龄
				Element ageElement = empElement.element("age");
				int age = Integer.parseInt(ageElement.getTextTrim());
				// 获取性别
				String gender = empElement.elementText("gender");
				// 获取工资
				int salary = Integer.parseInt(empElement.elementTextTrim("salary"));
				
				int id = Integer.parseInt(empElement.attributeValue("id"));
				// 输出：
				System.out.println(id + ", " + name + ", " + age + ", " + gender + ", " + salary);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

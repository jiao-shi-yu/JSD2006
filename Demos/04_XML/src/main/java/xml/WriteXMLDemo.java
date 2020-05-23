package xml;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class WriteXMLDemo {
	public static void main(String[] args) {
		// 0. 准备一组数据
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp(1, "张三", 23, "男", 5300));
		empList.add(new Emp(2, "李四", 24, "男", 5400));
		empList.add(new Emp(3, "王五", 25, "男", 5500));
		empList.add(new Emp(4, "赵六", 26, "男", 5600));
		empList.add(new Emp(5, "钱七", 27, "男", 5700));
		
		XMLWriter writer = null;
		try {
			// 1. 创建一个 Document 对象
			Document doc = DocumentHelper.createDocument();
			// 2. 添加根元素
			Element root = doc.addElement("list");
			// 3. 根节点中添加子节点
			for (Emp emp : empList) {
				// 根节点中添加一个 emp 节点
				Element empEle = root.addElement("emp");
				
				// emp 节点添加 name 子节点
				Element nameEle = empEle.addElement("name");
				// name 节点添加文本
				nameEle.addText(emp.getName());
				
				// 添加 age 节点元素
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");
				
				// 添加 gender 节点元素
				Element genderEle = empEle.addElement("gender");
				genderEle.addText("emp");
			
				// 添加 salary 节点元素
				Element salaryEle = empEle.addElement("salary");
				salaryEle.addText(emp.getSalary()+"");
				
				// 添加 id 属性
				empEle.addAttribute("id", emp.getId()+"");
			}
			// 4. 创建 XMLWrtier 
			writer = new XMLWriter(new FileOutputStream("myEmplist.xml"));
			writer = new XMLWriter(new FileOutputStream("myEmplist.xml"), OutputFormat.createPrettyPrint());

			// 5. 将 doucment 对象写出
			writer.write(doc);
			
			System.out.println("写出完毕，你去看看有了没？");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			// 6. 关闭 XMLWriter			
			if (writer!=null) {
				try {
					writer.close();
				} catch (Exception e) {
					
				}
			}
		}
	}
}

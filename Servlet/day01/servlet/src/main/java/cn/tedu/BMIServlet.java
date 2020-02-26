package cn.tedu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BMIServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取传递过来的参数, 注意：得到的参数都是String类型
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		
		// BMI Body Mass Index = w / h ^ 2
		double BMI = w/(h*h);
		String info = null;
		if (BMI < 18.5) {
			info = "兄Dei, 你瘦了！";
		} else if (BMI > 18.5 && BMI < 24) {
			info = "恭喜你，标准体重";
		} else if (BMI >= 24 && BMI < 28) {
			info = "哥们儿 可以少吃点儿了";
		} else {
			info = "兄弟你这一整块肌肉从哪儿练的？";
		}
		
		// 输出到页面
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println(info);
	}
}

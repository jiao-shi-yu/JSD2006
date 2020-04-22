package cn.tedu.spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserLoginServlet {
	@Resource(name="userMyBatisDao")
    private UserDao userDao;
    
    public void doPost() {
        System.out.println("\tUserLoginServlet.doPost()");
        userDao.login();
    }
    
}
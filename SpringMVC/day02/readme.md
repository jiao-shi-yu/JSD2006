## 3.5 显示页面
1. 在`src/main/resources`下，创建`templates`的文件夹，里面放`.html`文件。
2. 创建`hello.html`,
3. 添加`thymeleaf`,`thymeleaf-spring4`依赖;
    ```xml
    <!-- https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf -->
    <dependency>
        <groupId>org.thymeleaf</groupId>
        <artifactId>thymeleaf</artifactId>
        <version>3.0.11.RELEASE</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/org.thymeleaf/thymeleaf-spring4 -->
    <dependency>
        <groupId>org.thymeleaf</groupId>
        <artifactId>thymeleaf-spring4</artifactId>
        <version>3.0.11.RELEASE</version>
    </dependency>


    ```

# Eclipse `cmd + F6`切换编辑页

4. 配置视图解析器。
***在Spring的配置文件中，配置Thymeleaf的视图解析器***。  
    

```xml
    <!-- 配置模板解析器 -->
    <!-- ClassLoaderTemplateResolver: 当吧模板放在src/main/resources时, 必须使用这个 -->
    <bean id="templateResolver" class="org.thymeleaf.templateresolver.ClassLoaderTemplateResolver">
        <property name="prefix" value="/templates/"></property>
        <property name="suffix" value=".html"></property>
        <property name="characterEncoding" value="utf-8"></property>
        <property name="cacheable" value="false"></property>
        <property name="templateMode" value="HTML"></property>
    </bean>
    
    <!-- 配置模板引擎 -->
    <bean id="templateEngine" class="org.thymeleaf.spring4.SpringTemplateEngine">
        <property name="templateResolver" ref="templateResolver"></property>
    </bean>
    
    <!-- 配置Thymeleaf视图解析器 -->
    <bean class="org.thymeleaf.spring4.view.ThymeleafViewResolver">
        <property name="templateEngine" ref="templateEngine"></property>
        <property name="characterEncoding" value="utf-8"></property>
    </bean>
    
```

- 记得删除`@ResponseBody`.
```java
    @RequestMapping("hello.do")
    public String showHello() {
        System.out.println("HelloController.showHello()");
        /**
         * 显示页面：
         * 
         * prefix + return value + suffix
         * "templates/" + "hello" + ".html"
         * "templates/hello.html"
         */

        return "hello";
    }
```

# 4. 接收客户端提交的请求参数
## 4.1 通过HttpServletRequest获取

```java
    @RequestMapping("handle_register.do")
    @ResponseBody
    public String HandleRegister(HttpServletRequest request) {
        System.out.println("UserController.handleRegister()");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        
        System.out.println("\tusername=" + username);
        System.out.println("\tpassword=" + password);
        System.out.println("\tage=" + age);
        System.out.println("\tphone=" + phone);
        System.out.println("\temail=" + email);
        
        
        // 暂不关心后续的显示
        return "OK";
    }
```
## 4.2 通过匹配名称来获取
参数名卸载方法的参数列表中，还可以指定期望的类型。
```java
@RequestMapping("handle_register.do")
    @ResponseBody
    public String HandleRegister(String username, String password, int age, String phone, String email) {
        
        
        System.out.println("\t[4.2]username=" + username);
        System.out.println("\t[4.2]password=" + password );
        System.out.println("\t[4.2]age=" + age);
        System.out.println("\t[4.2]phone=" + phone);
        System.out.println("\t[4.2]email=" + email);
        
        
        // 暂不关心后续的显示
        return "OK";
    }
```
## 4.3 通过一个自定义类来匹配
自定义一个类：其中的属性与网页传来的属性，必须保证名称一致。
```java

public class User {
    private String username;
    private String password;
    private Integer age;
    private String phone;
    private String email;
    /* GETTERS and SETTERS省略了*/
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", age=" + age + ", phone=" + phone
                + ", email=" + email + "]";
    }
}

```
在处理请求的方法的参数列表中，传入刚刚自定义的类：
```java
    @RequestMapping("handle_register.do")
    @ResponseBody
    public String HandleRegister(User user) {
        
        System.out.println("\t[4.3] " + user);
        
        // 暂不关心后续的显示
        return "OK";
    }
```


## 4.4 小结
关于使用`HttpServletRequest`来获取请求参数的做法：
- 获取参数的过程比较麻烦
- 需要自行转换所需要的数据类型
- `HttpServletRequest`是重量级参数
- 不便于执行单元测试
所以在使用SpringMVC框架是，应该是使用 ***4.2***和 ***4.3***的做法。
- 当请求参数的数量较多(4~6)甚至非常多(>6)时，使用 ***4.3***的做法;
- 参数少使用 ***4.2***;
另外，***4.2***和 ***4.3***可以组合使用，
例如，设计注册功能时，可以通过4.3自定义类的做法接收用户填写的注册信息，
同时使用4.2匹配参数的做法接收验证码。




# 5. 转发
## 5.1 使用HttpServlet实现转发
```java

    @RequestMapping("handle_login.do")
    public String HandleLogin(String username, String password, HttpServletRequest request) {
        System.out.println("username="+username);
        System.out.println("password="+password);
        
        if ("root".equals(username)) {
            if ("1234".equals(password)) {
                
            } else {
                // 登录失败，密码错误
                String message = "登录失败，密码错误！";
                request.setAttribute("errorMessage", message);
                return "error";
            }
        } else {
            // 登录失败，用户名错误
            String message = "登录失败，用户名错误！";
            request.setAttribute("errorMessage", message);
            return "error"; // 转发到error对应的页面
        }
        return "OK";
    }
```


## 5.2 使用ModelMap实现转发

```java
    @RequestMapping("handle_login.do")
    public String HandleLogin(String username, String password, ModelMap map) {
        System.out.println("username="+username);
        System.out.println("password="+password);
        
        if ("root".equals(username)) {
            if ("1234".equals(password)) {
                
            } else {
                // 登录失败，密码错误
                String message = "登录失败，密码错误！";
                map.addAttribute("errorMessage", message);
                return "error";
            }
        } else {
            // 登录失败，用户名错误
            String message = "登录失败，用户名错误！";
            map.addAttribute("errorMessage", message);
            return "error"; // 转发到error对应的页面
        }
        return "OK";
    }
```






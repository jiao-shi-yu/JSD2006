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

## 4. 接收客户端提交的请求参数
### 4.1 通过HttpServletRequest获取

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
### 4.2 通过匹配名称来获取

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

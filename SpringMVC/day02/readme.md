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

### 4. 配置视图解析器。
***在Spring的配置文件中，配置Thymeleaf的视图解析器***。  
    

```xml
    <!-- 配置模板解析器 -->
    <!-- ClassLoaderTemplateResolver: 当吧模板放在src/main/resources时, 必须使用这个 -->
    <bean class="org.thymeleaf.templateresolver.ClassLoaderTemplateResolver">
        <property name="prefix" value="/templates/"></property>
        <property name="suffix" value=".html"></property>
        <property name="characterEncoding" value="utf-8"></property>
        <property name="cacheable" value="false"></property>
        <property name="templateMode" value="HTML"></property>
    </bean>
    
    <!-- 配置模板引擎 -->
    <bean id="templateEngine" class="org.thymeleaf.spring4.SpringTemplateEngine">
        <property name="setTemplateResolver"></property>
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



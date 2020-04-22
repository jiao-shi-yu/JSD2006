# 1.SpringMVC的主要作用

MVC = Model（数据模型） + View（视图） + Controller（控制器）

SpringMVC框架主要解决了VC之间的交互问题！在SpringMVC框架中，并不关心M的问题！

在传统的Java EE开发模式下，是使用Servlet组件作为项目的控制器，假设项目中有“用户注册”的功能，则可能需要创建`UserRegServlet`，如果还有“用户登录”功能，则可能需要创建`UserLoginServlet`，以此类推，每增加1个新的功能，就需要开发一个新的Servlet，如果某个项目中有100个功能，就需要开发100个Servlet，如果有500个功能，就需要开发500个Servlet！而且，每个Servlet可能还需要添加相关的配置，所以，一旦Servlet的数量过多，就会不利于管理和维护，并且，在服务器运行时，需要创建很多Servlet类的对象，会消耗较多的内存空间。

另外，Java EE的许多API并不简洁，在使用时并不是那么方便！

使用SpringMVC框架，以上问题都可以被解决！

# 2.SpringMVC的核心组件
- `DispatcherServlet`: 前端控制器, 主要负责接收所有请求，并分发到各个具体的`Controller`组件，该类是SpringMVC框架自带的；
- `HandlerMapping`: 用于记录路径与处理请求的`Controller`的对应关系，这是一个接口，在SpringMVC框架中，该接口及实现类都是框架自带的；
- `Controller`: 控制器，具体处理请求的组件，是开发人员自行创建的；
- `ModelAndView`: 控制器的处理结果，包括了处理得到的数据及视图的名称，即：哪些数据应该由那个名称对应的视图来显示，
- 这个`ModelAndView`是一个普通的类，当需要时，可以自行创建对象并向对象中
- ViewResolver：视图解析器，可根据视图名称确定需要使用的视图组件。
![](01.png)01.png


# 3.SpringMVC - HelloWorld
## 3.1 案例目标
开发完成后，启动项目，打开浏览器，输入`http://localhost:8080/项目名称/hello.do`网址，
可以在浏览器中显示指定的内容！

### 3.2. 创建项目

创建**Maven Project**，在创建过程中，勾选**Create a simple project**，**Group Id**值为`cn.tedu`，**Artifact Id**为`springmvc01`，**Packging**必须选择`war`。

创建好项目后，首先需要生成**web.xml**，然后，在**pom.xml**中添加`spring-webmvc`依赖：

```
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.6.RELEASE</version>
        </dependency>
    </dependencies>
```

> 在使用`spring-webmvc`时，推荐使用4.2或以上版本。

由于SpringMVC框架是基于Spring框架的，所以，需要从前序项目中复制**spring.xml**文件到当前项目中，并删除原有的配置。

### 3.3. 配置DispatcherSerlvet

```xml
<servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
</servlet>

<servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>*.do</url-pattern>
</servlet-mapping>
```

接下来，需要通过`DispatcherServlet`加载Spring配置文件。
在<servlet>节点的子级.


默认情况下，当第一个Servelt第一次需要接收请求是，才会创建对象。
需要配置成： 启动Tomcat就创建对象。
```xml
<servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <url-pattern>*.do</url-pattern>
</servlet-mapping>
```
先在**spring.xml**中添加组件扫描：

```xml
<context:component-scan base-package="cn.tedu.spring" />
```



类添加@Component注解

## 3.4 编写控制器 接受并处理 客户端的请求

在组件扫描的包下，创建控制器类。 
通常控制器类会使用Controller作为类名的后缀
控制器既不需要继承特定的类
也不需要实现特定的接口。

    @RequestMapping("hello.do")
    public String showHello() {
        System.out.println("HelloController.showHello()");
        return null;
    }

http://localhost:8080/springmvc01/hello.do

返回点儿东西

    @RequestMapping("hello.do")
    @ResponseBody
    public String showHello() {
        System.out.println("HelloController.showHello()");
        return "Hello, SpringMVC";
    }




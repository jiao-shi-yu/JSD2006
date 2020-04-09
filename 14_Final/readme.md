# 内容

- JSP
- SmartMVC
- 补充数据库相关知识
- 数据结构与算法
- JVM

# JSP
## 1. 什么是JSP?
- Java Server Pages, Java服务器页面。sun公司主导建立的一种动态网页技术标准。
- 本质是一个HttpServlet。
- JSP是一个以".jsp"为后缀的文件，该文件的主要内容是html和少量的java代码.
- 该文件会被容器转换成一个对应的Servlet.所以说JSP本质上是一个Servlet.

## 2. 如何写一个JSP?
### 1.添加一个以".jsp"为后缀的文件。
### 2.在该文件中，可以使用如下几种元素。
- html/css/js: 直接写即可。
- Java代码：
    - Java代码片段：
    ```
    <% java代码 %>
    ```

    - JSP表达式： 在service方法中，直接out.print输出
    ```
    <%= %>
    ```
 >容器：符合Servlet规范的应用程序，容器会提供Servlet运行的环境。比如Tomcat就是一个容器。
- 隐含对象
    + 什么是隐含对象：不加声明和创建就可以在JSP页面脚本中使用的成员变量，比如`out`、`request`、`response`.
    + 为什么可以直接使用：容器在生成JSP对应的Servlet源代码时，就已经创建好了这些对象。



#### page 
page对象代表JSP本身，只有在JSP页面内才是合法的。
page对象本质上是当前页面对应的Servlet的对象，可以看做是this关键字。
- 指令
    + 什么是指令：通知容器在生成Servlet源代码时，做一些额外的处理，比如导包。
    + 语法： `<% 指令名 属性=值 %>`
    + page指令
        - import属性：用于指定要导的包名。
        - 注：多个包之间用","隔开。
        - 例：
            - `<%@ page import="java.util.*" %>`
            - `<%@ page import="java.util.*, java.net.*" %>`
    + include指令：
        告诉容器在把JSP转换成Servlet时，将file属性指定的文件的内容插入到该指令所在的位置。

## 3. JSP是如何执行的？
1. 容器将JSP转换成一个对应的Servlet HttpJspBase extends HttpServlet
    a. html -> 在service方法中：`out.write`
    b. <% %> -> 照搬到service方法中。
2. 容器调用Servlet
    注:容器要将该Servlet先编译，然后实例化、初始化、然后调用Servlet实例的Service方法。
    + 容器读取jsp, 生成Servlet.  `pageEncoding`属性，告诉容器，在读取文件时，使用的编解码字符。
### 练习：写一个`date.jsp`, 要求页面中显示"当前时间：xxxx年xx月xx日"。







Day02 

## JSP声明：定义成员变量成员方法。

## 页面上下文只有当前页面可以访问。pageContext

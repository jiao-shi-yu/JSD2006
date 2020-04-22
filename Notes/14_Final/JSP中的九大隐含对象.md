>隐含对象，是指在JSP页面脚本中，不加声明和创建，就可以使用的成员变量。

>web容器在生成对应的Servlet时，已经帮我们创建好了这些隐含对象。

JSP中有九大隐含对象，
类型如下表所示：
|隐含对象|类型|作用域|
|------ |---|-----|
|request|javax.servlet.http.HttpServletRequest|request|
|response|javax.servlet.http.HttpServletResponse|page|
|pageContext|javax.servlet.jsp.PageContext|page|
|session|javax.servlet.httpSession|session|
|application|javax.servlet.ServletContext|application|
|out|javax.servlet.jsp.JspWriter|page|
|config|javax.servlet.ServletConfig|page|
|exception|java.lang.Throwable|page|



# request
__request__对象，封装了客户端生成的HTTP请求的所有细节，
主要包括HTTP头信息、系统信息、请求方式、请求参数等。
request对象，提供了一些方法，可以通过这些方法，
获取客户端提交的HTTP请求中的各项参数。

常用方法：
|方法|功能|
|---|----|
|getHeader(String name)|获取指定名字的的头文件信息|
|getHeaders(String name)|获取多个指定名字的头文件信息|


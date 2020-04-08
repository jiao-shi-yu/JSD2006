>JSP隐含对象（又称内置对象），是指可以不加声明和创建就可以在JSP页面脚本（Java程序片和Java表达式）中使用的成员变量。

在JSP中一共预先定义了九个隐含对象，分别为request,response,pageContext,session,application,out,config,page和exception。

JSP隐含对象的类型，如下表所示：
|隐含对象|类型|作用域|
|------ |---|-----|
|request|javax.servlet.http.HttpServletRequest|request|

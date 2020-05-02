# API　
什么是ＡPI?

Application Programming Interface, 应用程序编程接口。
就是一些已经写好，可供直接调用的功能。
在Java语言中，这些功能以类的形式封装。

JDK API 包含的类库功能强大，经常使用的有：
- 字符串操作
- 容器类
- IO流
- 网络通信
- 多线程


# JDK 包结构

为了便于使用和维护，JDK类库按照包结构划分，不同功能的类划分在不同的包中。

经常使用的包如下表所示：
|包名|功能|
|:-|:-:|
|java.lang|Java程序的基础类，如字符串、多线程等，该包中的类使用的频率非常高，不需要import就可以直接使用|
|java.util|常用工具类，如集合、随机数生成器、日历、时钟等|
|java.io| 文件操作、输入/输出操作|
|java.net|网络操作|
|java.math|数学运算相关操作|
|java.security|安全性相关操作|
|java.sql|数据库库访问|
|java.text|处理文字、日期、数字、信息的格式|


# 文档注释规范

## 文档注释
- 以`/**`开始，以`*/`结束；
- 加在类和方法的开头，用来说明类、方法、变量的作用。
- 通过javadoc工具，可以轻松地将Java文档注释转换为HTML文档说明；学习者和程序员主要通过文档了解API的功能；
- 文档注释不同于普通注释：普通注释用于程序员进行代码维护和交流。文档注释用于生成API的文档说明。


## 文档注释的规范
```java
package api;
/**
 * 文档注释是功能级注释，用来说明类、方法、常量的作用
 * @author jiao_ ------------作者
 * @version 1.2 -------------版本
 * @see java.lang.String  ---参考
 * @since JDK 1.7 -----------从JDK1.7加入了这个功能
 */
public class DocDemo {
	/**
	 * sayHello() 中的问候语
	 */
	public static final String INFO = "您好";
	/**
	 * 为特定的用户添加问候语
	 * @param name 给定的用户名
	 * @return 带有问候语的字符串
	 */
	public String sayHello(String name) {
		return INFO + name;
	}
}
```

# 字符串

## 字符串是不可变对象

- `java.lang.String`源码`private final char[] 
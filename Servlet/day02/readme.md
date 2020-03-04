### HTTP协议
- HTTP协议是网络应用层协议(数据传输协议), 用于规定数据传输的格式和内容
- TCP/IP协议：网络连接协议。三次握手，此协议规定了两个设备之间，如何建立连接
- 数据传输流程：参考图1


### GET请求和POST请求
1. GET：请求参数会显示在地址栏里，只能传输几k的数据，由于参数在地址后面安全性不能保证。
    - 地址栏发出的请求
    - 超链接发出的请求
    - form表单默认发出的请求
2. POST：请求参数列表 放在请求体 里面， 参数大小没有限制，请求参数不可见。安全性更高。
    - 只有当`form表单指定请求方式为POST`时，发出的才是`POST`请求。

### 乱码问题
1. GET请求方式，TomCat v8.0 以上，不需要做任何操作。v8.0 以下，则需要在`Servers`工程路径下，找到`server.xml`, 在65行`<Connector />`中添加属性`RIEncoding="UTF-8"`.
2. POST请求方式中有中文，则在Servlet中获取参数前，需要设置请求的字符编码`req.setCharacterEncoding("UTF-8");`.
3. 响应数据有中文，则在设置响应内容类型的时候，指定字符(编码)集`resp.setContentType("text/html;charset=UTF-8")`。


### Eclipse自定义代码块




### 工程使用数据库的准备工作
1. 确保有newdb3这个数据库和里面的user表
如果没有数据库，则执行以下代码：
```
CREATE DATABASE newdb3 CHARACTER SET UTF8;
USE newdb3;
CREATE TABLE user (id INT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20), password VARCHAR(20));
```

2. 在pom.xml配置文件中,添加mysql-connector-java的描述
```
  <dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.19</version> <-- 注意mysql 版本的问问题 -->
    </dependency>
    <dependency>
        <groupId>commons-dbcp</groupId>
        <artifactId>commons-dbcp</artifactId>
        <version>1.4</version>
    </dependency>
  </dependencies>
```

3. 在工程中添加`DBUtils.java`和`jdbc.properties`配置文件
    - `jdbc.properties`添加到`java/main/resources`路径下。



#### 工程JRE改成1.7后, 相应Facets也需要改变
```
工程名右键 -> 属性 -> Project Facets -> Java 1.5 -> 1.7 -> Apply
```

### Eclipse新建代码片段模板
```
Preferences -> Java -> Editor -> Templates， New一个出来。
```

### Eclipse生成Getter和Setter
```
Mac系统下，文档编辑页面右键，可以看到source对应的快捷键为： command + option + S 

然后选择需要生成的代码

```

### Eclipse 导包快捷键
```
command + shift + O
```




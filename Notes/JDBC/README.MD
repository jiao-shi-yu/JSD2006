# JDBC
- JavaDataBaseConnectivity, Java数据库连接，JDBC是SUN提供的一套API，
通过Java语言和数据库进行连接的API（Application Programming Interface, 
应用程序编程接口)。


### 如何使用JDBC
1. 创建一个Maven工程
2. 在`pom.xml`文件中添加 `mysql依赖`
```
    <dependencies>
            <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
    </dependencies>
```


#### JDBC 连接数据库的步骤

 1. 注册驱动
 2. 获取连接
 3. 准备要执行的SQL字符串
 4. 从连接得到执行对象Statement
 5. 执行
 6. 得到结果
 7. 关闭连接 
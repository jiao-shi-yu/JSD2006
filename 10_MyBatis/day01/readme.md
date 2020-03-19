# 1. MyBatis框架的作用
--------------------
MyBatis的主要作用:简化持久层数据库编程.

>数据持久化:把数据从内存存到硬盘上的过程.
>持久层:负责处理数据持久化的部分.一般都是使用数据库编程.

当使用MyBatis实现数据库编程时, 程序员只需要定义功能的抽象方法, 和需要执行的SQL语句即可.

# 2. 创建项目
------------
1. 创建Maven Project, 
    - Create Simple Project
    - Group Id为`cn.tedu`, Artifact Id为`mybatis`, 
    - Packing建议使用`war`(其实使用`jar`即可), 使用`war`是为了便于实现SSM框架的整合使用.

2. 创建好项目后:
    1. 需要先生成 __web.xml__文件; 
    2. 关联 __TomCat__;
    3. 在 __web.xml__配置`DispatcherServlet`和`CharacterEncodingFilter`.
    4. 在 __pom.xml__中添加依赖
    ```xml
        <dependencies>


        <!-- spring-webmvc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.1.13.RELEASE</version>
        </dependency>
        <!-- spring-jdbc -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.1.13.RELEASE</version>
        </dependency>


        <!-- MyBatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.3</version>
        </dependency>
        
        <!-- MyBatis 和 Spring 联合使用 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.3</version>
        </dependency>


        <!-- MySQL相关依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>

        <!-- 数据库连接池 -->
        <dependency>
            <groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>

        
        <!-- 单元测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>

    </dependencies>
    ```

# 3. 编写连接数据库的配置并尝试连接数据库
-----------------------------------

首先,得保证MySQL数据库服务器中存在'tedu_uns'
```mysql
mysql> \s
--------------
mysql  Ver 8.0.19 for macos10.15 on x86_64 (MySQL Community Server - GPL)

Connection id:      10
Current database:   
Current user:       root@localhost
SSL:            Not in use
Current pager:      stdout
Using outfile:      ''
Using delimiter:    ;
Server version:     8.0.19 MySQL Community Server - GPL
Protocol version:   10
Connection:     Localhost via UNIX socket
Server characterset:    utf8mb4
Db     characterset:    utf8mb4
Client characterset:    utf8mb4
Conn.  characterset:    utf8mb4
UNIX socket:        /tmp/mysql.sock
Binary data as:     Hexadecimal
Uptime:         1 hour 48 min 51 sec

Threads: 2  Questions: 6  Slow queries: 0  Opens: 113  Flush tables: 3  Open tables: 35  Queries per second avg: 0.000
--------------
```
```
url=jdbc:mysql://localhost:3306/tedu_ums?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai
driver=com.mysql.cj.jdbc.Driver
username=root
password=uiop7890
initialSize=10
maxActive=50
```

在/src/testjava





# 4. 编写插入用户数据的抽象方法
---------------------------
**src/main/java**下创建`cn.tedu.mybatis`包, 包中创建`UserMapper`接口:

```java
package cn.tedu.mybatis;

public interface UserMapper {

}
```

创建表:
```mysql
CREATE TABLE t_user {
    id INT AUTO_INCREMENT,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(20) NOT NULL,
    age INT,
    phone VARCHAR(20),
    email VARCHAR(50),
    PIMARY KEY(id)
} DEFAULT CHARSET=utf8;
```




在MyBatis中,
    - 返回值类型: 如果执行的SQL语句是`INSERT`/`UPDATE`/`DELETE`, 则使用`Integer`作为返回值类型.
    - 方法名称: 可以自定义. 但是不允许 重载.
    - 参数列表: 根据需要执行的SQL语句中有多少参数来决定, 也可以将多个参数封装到一个对象中.




## 指定接口所在的包.

# 5. 配置抽象方法对应的SQL语句

下载SomeMapper.xml文件, 复制到/src/main/resources/mappers路径下.


这个文件就是专门用于配置SQL语句.
```xml
<mapper namespace="cn.tedu.mybatis.UserMapper">
    <insert id="addnew">
        INSERT INTO t_user 
        (username, password, age, phone, email)
        VALUES
        (#{username}, #{password}, #{age}, #{phone}, #{email})
    </insert>
</mapper>
```
`UserMapper`中对应的方法也应该是`addnew`.


# 6. 使用MyBatist框架实现查询






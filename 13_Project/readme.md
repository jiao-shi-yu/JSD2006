## 1.项目分析
开发之前，对项目进行分析。
发现需要处理的数据类型有：
- 商品
- 商品类别
- 收藏
- 订单
- 购物车
- 用户
- 收货地址。

然后确定开发顺序，遵循的原则是由简到难。
用户>收货地址>修改资料>注册>登录。


先开发基础功能：修改密码>修改资料>上传头像。并且遵循“增查删改”的顺序。

数据表-->实体类-->业务-->控制器-->页面。


## 2. 创建用户数据表
创建数据库和用户表：
```mysql
CREATE DATABASE tedu_store;
USE tedu_store;
CREATE TABLE t_user (
    uid INT AUTO_INCREMENT COMMENT '用户id',
    username VARCHAR(20) UNIQUE NOT NULL COMMENT '用户名',
    password CHAR(32) NOT NULL COMMENT '密码',
    salt CHAR(36) COMMENT '盐值',
    phone VARCHAR(20) COMMENT '手机号码',
    email VARCHAR(20) COMMENT '电子邮箱',
    gender INT(1) COMMENT '性别：0-女，1-男',
    avatar VARCHAR(100) COMMENT '头像',
    is_delete INT(1) COMMENT '是否标记为删除：0-未删除，1-已删除',
    created_user VARCHAR(20) COMMENT '创建人',
    created_time DATETIME COMMENT '创建时间',
    modified_user VARCHAR(20) COMMENT '最后修改人',
    modified_time DATETIME COMMENT '最后修改时间',
    PRIMARY KEY (uid)
) DEFAULT CHARSET=utf8mb4;
```

>UTF-8编码在MySQL中有utf8mb3(most byte 3)和utf8mb4(most byte 4)这2种，如果在SQL语句中直接使用utf8，则表示utf8mb3.
推荐使用v5.5以上版本的MySQL。  



## 3. 创建用户实体类
+ 先创建一个`BaseEntiy`类，作为实体类的基类。基类中有四个属性。然后还实现了`Serializable`接口，便于Spring框架通过反射技术实例化这个类的实例对象。
```java
package cn.tedu.store.entity;

import java.io.Serializable;
import java.util.Date;

abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -3122958702938259476L;

    
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
    
    // Setters and Getters

    // toString()
    
}
```
然后创建一个`User`类

## 4. 用户-注册-持久层
application.properties添加配置：
```
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/tedu_store?useUnicode=true&characterEncoding=utf8&serverTimeZone=Asia/Shanghai
spring.datasource.driver=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=uiop7890

mybatis.mapper-locations=classpath:mappers/*.xml
```

# java单元测试：注意不要导错包
是`org.junit.Test`， 而不是`org.junit.jupiter.api.Test;`。另外，测试方法要用`public`修饰。

## 5. 用户注册业务的实现
- 实现原理和步骤：





- 关于用户密码的加密：

#### `commons-codec`提供了更多消息摘要算法的API。
添加依赖:

```xml
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
</dependency>
```
调用DigestUtils提供的摘要算法。
```java
import org.apache.commons.codec.digest.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {
    @Test
    public void sha1HaxTest() {
        String password = "123456";
        String md5Password = DigestUtils.sha1Hex(password.getBytes());
        System.err.println(md5Password);
    }
}
```
控制台输出：`7c4a8d09ca3762af61e59520943dc26494f8941b`.

注册和登录都需要对密码进行加密。所以单独的创建一个`public String getMd5Password(String password, String salt)`方法。


### Spring来统一处理异常
同样的异常可能会在多个业务中出现，且对应的处理方式是相同的。

SpringMVC提供了统一处理异常的机制。

具体做法：
+ 先定义一个统一处理异常的方法
    - 用`@ExceptionHandler`注解，标记这是一个异常处理的方法。
    - 应该使用`public`权限
    - 必须包含一个`Exception`类型的参数，以供框架捕获使用。
    - 
```java
@ExceptionHandler
public JsonResult<Void> aaa(Exception e) {

}
```



#### 上传头像

2. 规划异常: 不需要，因为操作很简单，几乎不会出错啊
3. `UserService`中添加抽象方法
4. `UserServiceImpl`中实现抽象方法
```java
/**
 uid, username, 用户ID和用户名；String avatar 是路径。
```


## 27.2 在控制器中处理文件上传

在处理请求的方法中，添加`MultipartFile`接口的参数。

这里的`MultipartFile`既封装了用户上传的文件，又封装了文件的一些信息，比如`file.getOrigalFileName()`。


## 27.3 `MultipartFile`接口提供的API
+ `String getOriginalFileName()`:获取文件的原始文件名。
+ `boolean isEmpty()`:上传表单中未选择文件就提交，或选择的文件大小为0
+ `long getSize()`:
+ `String getContentType`: 获取文件MIME类型
+ `void transferTo(File dest)`:将客户端上传的文件数据保存到服务器的某个文件中。



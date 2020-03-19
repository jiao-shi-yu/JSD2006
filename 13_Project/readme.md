## 1.项目分析

开始开发之前，现对项目进行分析。
首先确定需要处理的数据类型：商品， 商品类别，收藏，订单，购物车，用户，收货地址。

然后确定开发顺序，遵循的原则：由简到难。
用户>收货地址>修改资料>注册>登录。

先开发基础功能：修改密码>修改资料>上传头像。
并且遵循“增查删改”的顺序。

在开发一个功能之前，还应该先创建这中数据的数据表，再创建这种数据的实体类，在开发功能。
开发功能的顺序是: 持久层 > 业务层 > 控制器层 > 页面。


# 拆

## 2. 用户-创建数据表
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

`mostby4`

## 3. 用户-创建实体类

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
是`org.junit.Test`， 而不是`org.junit.jupiter.api.Test;`。
## 5. 用户-注册-业务层
## 6. 用户-注册-控制器层
## 7. 用户-注册-页面
## 8. 用户-登录-持久层
## 9. 用户-登录-业务层
## 10.用户-登录-控制器层
## 11.用户-登录-页面



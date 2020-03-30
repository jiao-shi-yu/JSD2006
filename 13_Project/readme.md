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
+ `long getSize()`: 获取上传的文件的大小，以字节为单位。
+ `InputStream getInputStream()`: 获取输入流。
+ `String getContentType`: 获取文件MIME类型
+ `void transferTo(File dest)`:将客户端上传的文件数据保存到服务器的某个文件中。


## 27.4 修改上传文件下载的限制
SpringBoot框架，限制了文件上传大小。
有两种解决方案：
### 在包含`@Configure`注解的类中配置
1. 在启动类中，更改上传文件的大小限制
```java
    // 定义全局的上传文件大小限制
    /**
     * 获取MultipartConfigElement
     */
    @Bean
    public MultipartConfigElement getMultipartConfigElement() {
        // 当前项目中 无论上传的是什么 都不允许超过100M， 若超过，则控制器不会执行。
        MultipartConfigFactory factory = new MultipartConfigFactory();
        DataSize dataSize = DataSize.ofMegabytes(100);
        factory.setMaxFileSize(dataSize);
        factory.setMaxRequestSize(dataSize);
        return factory.createMultipartConfig();
    }
```
主要使用到启动类的`@Configuration`注解，你自己写个类添加`@Configuration`注解，然后在自己写的类中添上面代码，也可以。



2. 在__application.properties__中添加配置信息：
根据SpringBoot版本添加不同的信息：
SpringBoot v1.4之前
```
multipart.maxFileSize=10MB          // 单个文件大小不得超过10MB
multipart.maxRequestSize=100MB      // 单次请求文件不得超过100MB
```
SpringBoot v1.4之后
```
spring.http.multipart.maxFileSize=10MB
spring.http.multipart.maxReqeustSize=100MB
```
SpringBoot v2.0之后
```
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=100MB
```

## 27.5 一次上传多个文件




### 上传数量固定的文件
```html
<form method="post" enctype="multipart/form-data" action="">
    <p>
    请选择身份证的正面照片：<input type="file" name="file1"/>
    </p>
    <p>
    请选择身份证的反面照片：<input type="file" name="file2"/>
    </p>
</form>
```
上传数量固定的文件时，控制器中，处理请求的方法中使用两个参数来表示两个不同的文件即可：
```java
public JsonResult<?> upload(MultipartFile file1, MultipartFile file2) {
    // 处理第一个文件
    // 处理第二个文件
}
```

### 上传数量不固定的文件
如果上传文件的数量在一定范围内不可控，例如微信朋友圈最多9张，但是你上传一张也可以。
再比如说，网购之后的买家秀，也是不定数量的图片。

针对这种情况，可以采取的做法，有

- 使用多个同名的上传控件。
```xml
<form method="post" enctype="multipart/form-data" action="">
    <p>
    请选择身份证的正面照片：<input type="file" name="file"/>
    </p>
    <p>
    请选择身份证的反面照片：<input type="file" name="file"/>
    </p>
</form>
```
一场代码中，使用的多个上传控件的`name`是相同的！在前端页面中，还可以使用JS技术动态添加更多的控件。

- 直接在上传控件上添加`multiple="multiple"`属性
```html
<form method="post" enctype="multipart/form-data" action="">
    <p>请选择上传的图片：
    <input type="file" name="file" mutliple="multiple"/>
    </p>
</form>
```
就可以一次上传多个文件。

在控制器处理请求的方法中，上传文件的参数对象应该声明为数组格式。例如：
```java
public JsonResult<?> upload(MultipartFile[] files) {
    // 遍历files, 处理每一个file


}
```


## 27.6 在前端页面使用`$.ajax()`函数实现异步上传

使用`$.ajax()`函数实现__上传文件__功能时，需要注意：
- `data`属性，必须是`new FromData(表单)`;
- 另外添加两个属性`"contentType":false`和`"processData":false`.




>$().click(); > 遍历整个数组，为数组中的每一个标签都绑定单击事件的响应函数。


```html
<script type="text/javascript">
    $("#btn-change-avatar").click(function() {
        $.ajax({
            "url":"/users/avatar/change",
            "data":new FormData($("#form-upload")[0])
            //......
         })
    })
 </script>
```
其中`$("#form-upload")`得到的结果是一个元素为`Form`的数组，通过`[0]`来访问数组当中的第一个元素。


# 28. 创建收货地址数据表
```mysql
CREATE TABLE t_address (
    aid INT     AUTO_INCREMENT PRIMARY KEY COMMENT "收货地址id",
    uid INT     COMMENT "归属用户的id",
    name    VARCHAR(20)      COMMENT "收货人姓名",
    province_name   CHAR(6)      COMMENT "省",
    province_code   CHAR(6)     COMMENT "省代号",
    city_name   VARCHAR(15)     COMMENT "市",
    city_code   CHAR(6)     COMMENT "市代号",
    area_name   VARCHAR(15)     COMMENT "区",
    area_code   CHAR(6)     COMMENT "区代号",
    zip CHAR(6)     COMMENT "邮政编码",
    address VARCHAR(50)     COMMENT "详细地址",
    phone   VARCHAR(20)     COMMENT "电话",
    tel VARCHAR(20)     COMMENT "固话",
    tag VARCHAR(10)     COMMENT "地址类型",
    is_default  INT(1)      COMMENT "是否默认：0-非默认， 1-默认",
    created_user    VARCHAR(20)     COMMENT "创建人",
    created_time    DATETIME        COMMENT "创建时间",
    modified_user   VARCHAR(20)     COMMENT "最后修改人",
    modified_time   DATETIME        COMMENT "最后修改时间"
) DEFAULT CHARSET=utf8mb4;
```
# 29. 创建收货地址实体类
```java
package cn.tedu.store.entity;

import java.util.Date;

public class Address extends BaseEntity {
    /**
     * Generated Serial id
     */
    private static final long serialVersionUID = 3807707125821455168L;
    // Properties

    // Getters and Setters
    
    // toString()

}

```
3. 持久层-插入数据
先创建个`AddressMapper`的接口，然后创装一个`AddressMapper.xml`的配置文件，
最后创建一个`AdressMapperTest`的测试类。
```java
package cn.tedu.store.mapper;

public interface AddressMapper {

}
```
```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" 
    "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">

<mapper namespace="cn.tedu.store.mapper.AddressMapper">

</mapper>
```
并在`AddressMapperTests`中引用一个`AddressMapper`实现类的实例对象
```java

package cn.tedu.store;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.mapper.AddressMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
    @Autowired
    private AddressMapper mapper;
    
}

```
开始实现插入数据的功能：
`UserMapper`接口中简单声明一个方法：
```java

```
__UserMapper.xml__配置文件中写好SQL语句:
```xml
    <insert id="addNew" useGeneratedKeys="true" keyProperty="uid">
        INSERT
        INTO t_address(
        aid,
        uid,
        name,
        province_name,
        province_code,
        city_name,
        city_code,
        area_name,
        area_code,
        zip CHAR(6),
        address,
        phone,
        tel,
        tag,
        is_default,
        created_user,
        created_time,
        modified_user,
        modified_time
        )
        VALUES
        (
        #{aid},
        #{uid},
        #{name},
        #{province_name},
        #{province_code},
        #{city_name},
        #{city_code},
        #{area_name},
        #{area_code},
        #{zip},
        #{address},
        #{phone},
        #{tel},
        #{tag},
        #{is_default},
        #{created_user},
        #{created_time},
        #{modified_user},
        #{modified_time}
        )
    </insert>
```

4. 持久层-根据uid删除收货地址


# 32. 收货地址-业务层

1. 规划并创建异常。








# 35. 导入省市区数据表
```mysql
mysql> source /Users/yuyu/Downloads/PROJECT_DAY07_ALL_1750/t_dict_district.sql 
mysql> show tables;
+----------------------+
| Tables_in_tedu_store |
+----------------------+
| t_address            |
| t_dict_district      |
| t_user               |
+----------------------+
3 rows in set (0.00 sec)
```
dict:字典
district:地区

# 36. 省市区-创建实体类
创建`cn.tedu.store.entity.District`地区实体类。
```java
public class District implements Serializable {
    // Serial Version UID
    // Properties
    private Integer id;
    private String parent;
    private String code;
    private String name;
    // Getters and Setters 
    // 基于id的hashCode()与equals()
    // toString
}
```
# 36. 省市区-显示列表-持久层



1. 分析规划需要执行的SQL语句
获取全国所有省/某省所有市/某市所有区的列表，需要执行的SQL语句大致是：
```mysql
SELECT * FROM t_dict_district WHERE parent=? ORDER BY code ASC;
```


# 37. 省市区-显示列表-业务层

2. 接口与抽象方法
```java
public interface DistrictService {
    List<District> getByParent(String parent);
}
```

3. 创建`DistrictServiceImpl`作为`DistrictService`的实现类。添加`@Service`注解，并在类中添加`@Autowired private DistrictMapper districtMapper;`持久层对象。
```java
package cn.tedu.store.service.impl;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Override
    public List<District> getByParent(String parent) {
        // TODO Auto-generated method stub
        return null;
    }

}
```
然后开始写业务：


# 38. 省市区-显示列表-控制器层
1. 处理异常： 无
2. 设计需要处理的请求
- 请求路径：`/districts/`
- 请求参数：`String parent`
- 使用Session：否
- 请求类型：`GET`
- 相应数据：`JsonResult<List<Distirct>>`
- 是否拦截：`否`
3. 处理请求
- 在拦截器的配置类`InterceptorConfigration`中，将`/districts/**`添加到白名单。
```java
patterns.add("/districts/**");
registy.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(patterns);
```
- 创建`DistrictController`继承自`BaseController`，在类的声明之前添加`@RestController`和`@RequestMapping("districts")`注解。并添加业务层对象`@Autowired private AddressService addressService`。
```java
@RestController
@RequestMapping("district")
public class DistrictController extends BaseController {
    @Autowired
    private DistrictService districtService;
    
    @GetMapping
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(SUCCESS, data);
    }
}
```


# Chrome快捷键 command option + J 控制台 command option + C 选择器





# 44. 收货地址 - 显示列表 - 持久层
1. 分析要执行的SQL语句
显示收货地址列表，需要执行的SQL语句大致是:
```mysql
SELECT * FROM t_address WHERE uid = ? ORDER BY is_default DESC modifiedTime DESC;
```
2. 接口与抽象方法
在`AddressMapper`接口中添加抽象方法：
```java
List<Address> findByUid(Integer uid);
```
3. 配置映射
在__AddressMapper.xml__中，配置映射：
```xml
<resultMap id="AddressEntityMap" type="cn.tedu.store.entity.Address">
    <id .../>
    <result .../>
</resultMap>
<select id="findByUid" resultMap="AddressEntityMap">
    SELECT * FROM t_address WHERE uid = #{uid} ORDER BY is_default DESC modifiedTime DESC;
</select>
```








4. 实现抽象方法
在`AddressService`中，添加抽象方法：
```java
public List<Address> getByUid(Integer uid);
```
在`AddressServiceImpl`中规划以上方法的实现：
```java
public List<Address> getByUid(Integer uid) {
    // 基于uid调整持久层的findById()查询得到收货地址的列表数据
    // 遍历查询到的收货地址的数据
    // 将遍历到的对象不需要显示在页面上的属性设置为null
    // uid provinceCode cityCode areaCode is
    // 返回收货地址列表
}
```


# 作业:
1. 将指定的收货地址设置为默认收货地址
需要执行的SQL语句大致是:
```mysql
UPDATE t_address SET is_default=1, modified_user=?, modified_time=? WHERE aid = ?
```
抽象方法应该设计为：
```java
Integer updateDefaultByAid (
    @Param("aid") Integer aid,
    @Param("modifiedUser") String modifiedUser,
    @Param("modifiedTime") Date modifiedTime
)
```
2. 将用户的默认收货地址取消掉
```mysql
UPDATE t_address SET is_default=0 WHERE uid=?
```
抽象方法应该设计为：
```java
Integer updateNoneDefaultByUid(Integer uid);
```
### 先执行2 再执行1
3. 根据收货地址id查询收货地址详情
需要执行的SQL语句：
```mysql
SELECT * FROM t_address WHERE uid=?
```
抽象方法应该设计为：
```java
Address findByAid(Integer aid);
```
4. 根据收货地址id删除收货地址数据
```mysql
DELETE FROM t_address WHERE aid=?
```
5. 查询某用户最后修改的收货地址数据
```mysql
SELECT * FROM t_address WHERE uid=? ORDER BY modified_time DESC LIMIT 0, 1;
```
6. 将t_products.sql脚本导入到数据库中
7. 在项目中创建数据的实体类`Product`
8. 根据商品id查询商品数据详情










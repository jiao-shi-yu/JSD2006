# 7. 使用多个参数

```


```



# 8. 动态SQL 


使用<foreach>节点来遍历.
找错:
```
<delete id="deleteByIds">
        DELETE FROM t_user WHERE id in 
        <foreach collection="array" item="id" separator="," open="(", close=")">
            #{id}
        </foreach>
    </delete>
```
多写了一个逗号.
```
@Test 
    public void findTest() {
        String where = "where username = summer";
        String orderBy = null;
        Integer offset = null;
        Integer count = null;
        List<User> users = userMapper.find(where, orderBy, offset, count);
        System.out.println(users);
    }
```
少些了单引号.
## `#{}`和`${}`区别
    + `#{}`只表示一个值,相当于`?`占位
    + `${}`可以表示任意片段, 存在 **SQL注入**风险.



# 11. 多表查询

先创建一个用户组表
```mysql
CREATE TABLE t_group (
    id INT AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL,
    PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;
```


```
INSERT INTO t_group(name) VALUES ('普通会员'), ('VIP会员'), ('系统管理员');
ALTER TABLE t_user ADD COLUMN group_id INT;

UPDATE t_user SET group_id = 1 WHERE id IN (3, 4);
UPDATE t_user SET group_id = 2 WHERE id IN (6, 9);
UPDATE t_user SET group_id = 3 WHERE id IN (10, 11);

```

## 11.2 
数据表中的字段名为`group_id`, 而`User`中的属性名是`groupId`, 使用的名称并不完全一致.
这种情况下, MyBatis 无法
解决: 
    1. 把`groupId`的`SETTER`方法改为`setGroup_id`即可.
    2. 或者在Mapper.xml中配置字段别名
    ```
    <select id="findAll" resultType="cn.tedu.mybatis.User">
        SELECT id, username, password, phone, email, group_id AS groupId 
        FROM t_user
        ORDER by id
    </select>
    ```
## 11.3 


# 12. 一对一的多表查询

```
SELECT t_user.id, username, password, age, phone, email, 
group_id AS groupId, name AS groupName
FROM t_user
LEFT JOIN t_group
ON t_user.group_id = t_group.id
WHERE t_user.id = #{id}
```

当执行关联查询时, 没有任何实体类可以封装查询结果! 
就要创建一个 __VO(Value Object)类__, 用于封装此次的查询结果:
```java
public class UserVO {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String phone;
    private String email;
    private Integer groupId;
    private String groupName;


    // Getters and Setters

    // toString()
}
```

>实体类与VO类, 在代码结构上类似. 只是定位不同. 实体类与数据表保持一致,VO类与查询结果对应一致.

在接口中添加抽象方法:
```
User 
```







```
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): cn.tedu.mybatis.UserMapper.findVOById
   
--- 应该是fingUserVOById
```


# 13. 一对多的关联查询
```
select * from t_group
```

创建GroupVO类，用于封装查询结果：
```java
public class GroupVO {
    private Integer id;
    private String name;
    private List<User> users;
    // Setters & Getters
    // toString()
}
```

然后，创建`UserMapper`接口，定义相应的抽象方法。


# 14. MyBatis总结
- 简化持久层开发
- 认识常用配置
- 抽象方法的设计原则
    - 返回值：增删改查返回`Integer`， 查询返回期望类型, 能封装查询结果即可。
    - 方法名是自定义的，单不允许重载，多个方法名称必须不同。
    - 参数列表: 根据执行SQL语句时的参数来设计。如果参数较多，可以将相关数据进行封装。如果抽象方法的参数超过一个，应该在每个参数之前添加`@Param`注解.
- SQL语句怎么写：
    - 根据需要执行的SQL语句的种类选择<insert>、<delete>等节点 每个节点都要有id属性
    - <select> 节点必须配置 resultType或resultMap属性
- `${}`和`#{}`
- 掌握动态SQL中的<foreach>的使用
- 了解动态SQL中的<if>和<choose>系列节点的使用
- 理解实体类与"ValueObject"类的概念
- 自定义别名
    + 自行穷举字段列表时，查询的字段名与属性名不一致，就需要自定义别名以匹配。
    + 多表连个查询时，两张表中的字段相同，也需要自定义别名，加以区分。
- <resultMap>的使用场景：
    + 查询时使用了*, 且查询结果的列表字段与封装类中的属性名不一致时。
    + 多表查询，数据存在“多对一或一对多”关系时。








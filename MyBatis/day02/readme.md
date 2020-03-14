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
SELECT t_user.id, username, password, age, phone, email, group_id, name
FROM t_user
LEFT JOIN t_group
ON t_user.group_id = t_group.id
WHERE t_user.id = 11;
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


























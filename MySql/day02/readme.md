# 数据类型
1. 整数类型： int 和 bigint（等效Java中的long)
```
CREATE TABALE t1(name varchar(10), age int(10) zerofill);

INSERT INTO t1 
VALUES ('aaa', 18);

```
2. 浮点数： 
+ float(m, d)和double(m, d)
    - m代表总长度
    - d代表小数长度
+ decimal(m, d)
    - 超高精度浮点数
3. 字符串
    - char(m): 固定长度， m=10, 存abc，占10个长度，最大长度255
    - varchar(m): 可变长度， m=10, 存abc, 占3个长度，最大长度65535，超过255建议使用text，节省空间。
    - text(m): 可变长度，最大长度65535
4. 日期：
    - date： 只能保存年月日
    - time： 只能保存时分秒
    - datetime: 默认值为null， 最大9999-12-31
    - timestamp: 默认值，当前系统时间，最大2038-1-19
```
CREATE TABLE t_date(t1 date, t2 time, t3 datatime, t4 timestamp);
INSERT INTO t_date 
VALUES (null, null,, '2020-2-18', null);
```

# 主键约束
- 什么是主键： 表示数据唯一性的字段
- 什么是约束： 创建表时，给表添加的限制条件
- 主键约束： 唯一且非空
```
CREATE TABLE t2
(id int primary key, name varchar(10));

INSERT INTO t2 
VALUES(1, 'aaa'); # 成功

INSERT INTO t2
VALUES(1, 'bbb'); # Duplicate entry '1' for key 't2.PRIMARY'

INSERT INTO t2
VALUES(null, 'ccc') # Column 'id' cannot be null
```

# 主键约束+自增

```
CREATE TABLE t3 
(id int PRIMARY KEY AUTO_INCREMENT, name varchar(10));

INSERT INTO t3 
VALUES (null, 'aaa');

INSERT INTO t3
VALUES (null, 'bbb');

INSERT INTO t3
VALUES (10, 'ccc');

INSERT INTO t3
VALUES (null, 'ddd');

DELETE FROM t3
WHERE id >= 10;

INSERT INTO t3
VALUES (null, 'eee');
```

- 自增规则：从*历史最大值*+1

# 导入`.sql`文件
    source /Users/yuyu/Documents/emp.sql;

# `is null`和`is not null`
1. 查询 没有上级领导 的员工信息
```
SELECT * FROM emp
WHERE mgr is NULL;
```
2. 查询 有上级领导的 员工姓名
```
SELECT ename FROM emp
WHERE mgr IS NOT NULL;
```


### 比较运算符 > < >= <= != <>
1. 查询 工资小于等于3000的员工姓名和工资
```
SELECT ename, sal FROM emp
WHERE sal <= 3000;
```
2. 查询工作不是程序员的员工姓名和工作
```
SELECT ename, job FROM emp
WHERE job <> "程序员";
```

### BETWEEN X AND Y 包含x和y
1. 查询工资在2000到3000之间的员工姓名和工资
```
SELECT ename, sal FROM emp
WHERE sal >= 2000 
AND sal <= 3000;

SELECT ename, sal FROM emp
WHERE sal BETWEEN 2000 AND 3000;
```


### IN (x,y,z);
1. 查询工资为3000, 1500, 5000的员工姓名和工资
```
SELECT ename,sal FROM emp
WHERE sal = 3000 
OR sal = 1500
OR sal = 5000;

SELECT ename,sal FROM emp
WHERE sal IN (3000, 1500, 5000);
```

















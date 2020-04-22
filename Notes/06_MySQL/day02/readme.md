# 数据类型
1. __整数类型__： `INT` 和 `BIGINT`（等效Java中的long)
```
CREATE TABALE t1(name VARCHAR(10), age INT(10) ZEROFILL);

INSERT INTO t1 
VALUES ('aaa', 18);

```
2. __浮点数__： 
+ `FLOAT(m, d)`和`DOUBLE(m, d)`
    - m代表总长度
    - d代表小数长度
+ `DECIMAL(m, d)``
    - 超高精度浮点数
3. __字符串__：
    - `CHAR(m)`: 固定长度字符串， m=10, 存abc，占10个长度，最大长度255
    - `VARCHAR(m)`: 可变长度字符串， m=10, 存abc, 占3个长度，最大长度65535，超过255建议使用text，节省空间。
    - `TEXT(m)`: 可变长度，最大长度65535
4. __日期__：
    - date： 只能保存年月日
    - time： 只能保存时分秒
    - datetime: 默认值为null， 最大9999-12-31
    - timestamp: 默认值，当前系统时间，最大2038-1-19
```
CREATE TABLE t_date(t1 DATE, t2 TIME, t3 DATATIME, t4 TIMESTAMP);
INSERT INTO t_date 
VALUES (NULL, NULL, '2020-2-18', NULL);
```

# 主键约束
- 什么是__主键__： __表示数据唯一性的字段__
- 什么是__约束__： 创建表时，__给表添加的限制条件__
- 主键约束：唯一且非空
```
CREATE TABLE t2
(id INT PRIMARY KEY, name VARCHAR(10));

INSERT INTO t2 
VALUES(1, 'aaa'); # 成功

INSERT INTO t2
VALUES(1, 'bbb'); # Duplicate entry '1' for key 't2.PRIMARY'

INSERT INTO t2
VALUES(NULL, 'ccc') # Column 'id' cannot be null
```

# 主键约束+自增

```
CREATE TABLE t3 
(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(10));

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

- 自增规则：从__历史最大值__+1

# 导入`.sql`文件
```
source /Users/yuyu/Documents/emp.sql;
```

# NULL需要使用`IS`关键字，而不是`=`
1. 查询__没有上级领导__的员工信息
```
SELECT * FROM emp
WHERE mgr IS NULL;
```
2. 查询__有上级领导的__员工姓名
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
SELECT ename,sal 
FROM emp
WHERE sal = 3000 
OR sal = 1500
OR sal = 5000;

SELECT ename,sal 
FROM emp
WHERE sal IN (3000, 1500, 5000);
```

### 综合练习
1. 查询有上级领导并且是在3号部门的员工信息
```mysql
SELECT * 
FROM emp
WHERE mgr IS NOT NULL
AND deptno = 3;
```
2. 查询2号部门工资在1000到2000之间的员工姓名，工资和部门编号
```mysql
SELECT ename, sal, deptno
FROM emp
WHERE deptno = 2
AND sal BETWEEN 1000 AND 2000;
```
3. 查询1号部门工资为800和1600员工信息
```mysql
SELECT * From emp
WHERE sal IN (800, 1600)
AND deptno = 1;
```


### 模糊查询`LIKE`
- `%`表示一个或多个字符
- `_`表示一个字符
1. 查询姓孙的员工信息
```mysql
SELECT * FROM emp
WHERE ename LIKE "孙%";
```
2. 查询工作中包含销售的员工姓名和工作
```mysql
SELECT ename, job FROM emp
WHERE job LIKE '%销售%'
```
3. 查询名字中以精结尾的员工姓名
```mysql
SELECT ename FROM emp
WHERE ename LIKE '%精';
```

## 排序 `ORDER BY`
- 格式： ` ORDER BY 字段名1 DESC/ASC, 字段名2 DESC/ASC`
- DESC: descending--降序
- ASC: ascending--升序
1. 查询员工姓名和工资信息，按照工资降序排序：
```mysql
SELECT ename, sal FROM emp
ORDER BY sal DESC;
```
2. 查询一号部门的员工信息，按照工资升序排序：
```mysql
SELECT * FROM emp
WHERE deptno = 1
ORDER BY sal ASC;
```
3. 查询员工姓名、工资和部门编号，按照部门编号升序排序，如果部门编号相同，则按照工资降序排序。
```mysql
SELECT ename, sal, deptno FROM emp
ORDER BY deptno ASC, sal DESC;
```

## 分页 `LIMIT`
- 格式： `LIMIT 跳过条数, 每页显示条数`.
1. 查询员工表中第一页的5条数据，按照工资升序排序：
```mysql
SELECT * FROM emp
ORDER BY sal ASC
LIMIT 0, 5;
```
2. 查询员工表中第2页的5条数据,按照工资升序排序
```mysql
SELECT * FROM emp
ORDER BY sal ASC
LIMIT 5, 5;
```
3. 查询员工表中工资最高的员工信息
```mysql
SELECT * FROM emp
ORDER BY sal DESC
LIMIT 1;
```
4. 查询员工表中工资降序的第三页的3条数据
```mysql
SELECT * FROM emp
ORDER BY sal
LIMIT 6, 3;
```
5. 查询工资在1000到5000的员工信息，每页两条数据，查看第四页的数据
```mysql
SELECT * FROM emp
WHERE sal BETWEEN 1000 AND 5000
LIMIT 6, 2;
```


## 数值计算 `+ - * /`
- 也正是因为`-`__是MySQL中的运算符__，所以创建数据或表时，`CHARACTER SET`或`CHAERSET`设置为`UTF8`，而不是~~`UTF-8`~~.
1. 查询每个员工的姓名，工资以及年终奖(5倍月薪)的工资
```mysql
SELECT ename, sal, sal*5 AS 年终奖 FROM emp;
```
2. 查询每个员工的姓名、工资、以及罚款你5块钱之后的工资
```mysql
SELECT ename, sal, sal-5 AS 实到工资 FROM emp;
```

# 聚合函数
- 对查询到的多条数据 进行统计，最大值、最小值、平均值、计数、求和等
1. 查询工资大于2000块的员工数量














































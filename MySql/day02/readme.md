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
SELECT ename,sal 
FROM emp
WHERE sal = 3000 
OR sal = 1500
OR sal = 5000;

SELECT ename,sal 
FROM emp
WHERE sal IN (3000, 1500, 5000);
```

#### 综合练习
1. 查询有上级领导并且是在3号部门的员工信息
```
SELECT * 
FROM emp
WHERE mgr IS NOT NULL
AND deptno = 3;
```
2. 查询2号部门工资在1000到2000之间的员工姓名，工资和部门编号
```
SELECT ename, sal, deptno
FROM emp
WHERE deptno = 2
AND sal BETWEEN 1000 AND 2000;
```
3. 查询1号部门工资为800和1600员工信息
```
SELECT * FROM emp
WHERE deptno = 1
AND sal IN (800, 1600);
```

### 模糊查询`LIKE`
+ %: 代表0或多个未知字符
+ _: 代表1个未知字符

1. 查询姓孙的员工信息
```
SELECT * FROM emp
WHERE ename LIKE '孙%';
```

2. 查询工作中包含销售的员工姓名和工作
```
SELECT * FROM emp
WHERE job LIKE '%销售%';
```
3. 查询名字中以精结尾的员工姓名
```
SELECT * FROM emp
WHERE ename LIKE '%精';
```

### 排序 `ORDER BY`
+ 格式: `ORDER BY 字段名 ASC/DESC;`
1. 查询员工姓名和工资，按照工资降序排列。
```
SELECT ename, sal 
FROM emp
ORDER BY sal;
```
2. 查询1号部门的员工信息，按照工资升序排序。
```
SELECT * 
FROM emp
WHERE deptno = 1
ORDER BY sal DESC;
```

+ 多字段排序格式: `ORDER BY 字段1, 字段2；`
1. 查询员工姓名，工资和部门编号， 按照部门编号升序排列，部门编号相同，按照工资降序排列
```
SELECT ename, sal, deptno 
FROM emp 
ORDER BY deptno ASC, sal DESC;
```


### 分页查询`LIMIT`
- 格式: `limit 跳过的条数，请求的条数`
1. 查询员工表中信息，按照工资升序排序，显示第一页前5条。
```
SELECT *
FROM emp
ORDER BY sal ASC
LIMIT 0, 5;
```

2. 查询员工表中第二页的五条数据，按照工资升序排序
```
SELECT *
FROM emp
ORDER BY sal ASC
LIMIT 5,5;
```

3. 查询员工表中工资最高的员工信息
```
SELECT * 
FROM emp
ORDER BY sal DESC
limit 0,1;
```
4. 查询员工表中工资降序的第三页的3条数据
```
SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 6,3;
```
5. 查询员工表中工资在1000到5000之间的第4页的2条数据
```
SELECT * 
FROM emp
WHERE sal BETWEEN 1000 AND 5000
LIMIT 6,2;
```

### 数值计算`+ - * /`
1. 查询每个员工的姓名，工资以及年终奖（5个月的工资）
```
SELECT ename, sal, sal*5 
FROM emp;
```
2. 查询每个员工的姓名, 工资及涨薪5块钱后的工资
```
SELECT ename, sal, sal+5
FROM emp;
```

### 聚合函数
- 对查询的多条数据进行统计查询。
#### 平均值 `avg(字段)`
1. 查询二号部门的平均工资
```
SELECT AVG(sal)
FROM emp
WHERE deptno = 2;
```
2. 查询销售的平均工资
```
SELECT AVG(sal)
FROM emp 
WHERE job LIKE '%销售%';
```

#### 最大值 `MAX(字段)`
- 查询员工表中工资最大值是多少
```
SELECT MAX(sal)
FROM emp;
```
- 查询1号部门最大奖金comm是多少
```
SELECT MAX(comm)
FROM emp
WHERE deptno = 1;
```

#### 最小值 `MIN(字段)`
- 查询一号部门的最低工资
```
SELECT MIN(sal)
FROM emp
WHERE deptno = 1;
```

#### 求和 `SUM(字段)`
- 查询二号部门的工资总和
```
SELECT SUM(sal)
FROM emp
WHERE deptno = 2;
```

### 计数 `COUNT(字段)`
- 查询工资大于2000块钱的员工数量
```
SELECT COUNT(*)
FROM emp
WHERE sal > 2000;
```


##### 练习题
1. 查询员工表中工资高于2000的员工姓名和工资，按照工资升序排列，查询第二页的两条数据
```
SELECT ename, sal 
FROM emp
WHERE sal > 2000
LIMIT 2, 2;
```

2. 查询和销售相关的工作的工资总和
```
SELECT SUM(sal)
FROM emp
WHERE job LIKE '%销售%';
```

3. 查询程序员人数
```
SELECT COUNT(*) 
FROM emp
WHERE job LIKE '程序员';
```

4. 查询1号部门中有领导的员工中的最高工资
```
SELECT MAX(sal)
FROM emp
WHERE deptno = 1 AND mgr IS NOT NULL;
```

5. 查询2号部门中的最高工资和最低工资，起别名
```
SELECT MAX(sal) 二号部门最高工资, MIN(sal) 二号部门最低工资
FROM emp
WHERE deptno = 2; 
```

6. 查询1号部门中名字中包含'空'字的员工姓名
```
SELECT ename FROM emp
WHERE deptno = 1
AND ename LIKE '%空%';
```


### 分组查询

1. 查询每个部门的平均工资
```
SELECT deptno, AVG(sal)
FROM emp
GROUP BY deptno;
```

2. 查询每个部门的最高工资
```
SELECT deptno, MAX(sal) 
FROM emp
GROUP BY deptno;
```

3. 查询每种工作的人数
```
SELECT job, COUNT(*)
FROM emp
GROUP BY job;
```

4. 查询每个部门工资高于1500的员工数量
```
SELECT deptno, COUNT(*) 
FROM emp
WHERE sal > 1500
GROUP BY deptno;
```

5. 查询一号部门和二号部门的最高工资
```
SELECT deptno, MAX(sal)
FROM emp
WHERE deptno IN (1, 2)
GROUP BY deptno;
```

### HAVING 
-  WHERE 后面只能写普通字段的条件，不能写聚合函数的条件
-  HAVING 结合GROUP BY使用，在HAVING后面写写聚合函数的条件
1. 查询平局工资大于2000的部门号和平均工资
```
SELECT deptno, AVG(sal) 
FROM emp
GROUP BY deptno
HAVING AVG(sal) > 2000;
```
2. 查询工作人数为1的 工作
```
SELECT job, COUNT(*) 人数
FROM emp
GROUP BY job
HAVING 人数 = 1;
```
3. 查询每个部门的平均工资，只查询工资在1000到3000之间的，并且过滤掉平均工资低于2000的部门。
```
SELECT deptno, AVG(sal) avgSal
FROM emp
WHERE sal BETWEEN 1000 AND 3000
GROUP BY deptno
HAVING avgSal >= 2000;
```



# 关键字顺序总结
```
SELECT 字段信息 
FROM 表名
WHERE 条件
HAVING 聚合条件
ORDER BY 排列字段
LIMIT x,y; 
```


### 练习题

1. 查询没有上级领导的员工编号empno，姓名，工资
```
SELECT empno, ename, sal
FROM emp
WHERE mgr IS NULL;
```
2. 查询有奖金的员工姓名和奖金
```
SELECT ename, comm
FROM emp
WHERE comm IS NOT NULL;
```
3. 查询名字中包含精的员工姓名和工资
```
SELECT ename, sal
FROM emp
WHERE ename LIKE '%精%';
```
4. 查询名字中第二个字是八的员工信息
```
SELECT * 
FROM emp
WHERE ename LIKE '_八%';
```
5. 查询1号部门工资大于2000的员工信息
```
SELECT * 
FROM emp
WHERE deptno = 2 
AND sal >= 2000;
```
6. 查询2号部门或者工资低于1500的员工信息
```
SELECT *
FROM emp
WHERE deptno = 2 OR sal < 1500;
```
7. 查询工资为3000，1500，5000的员工信息按照工资升序排序
```
SELECT *
FROM emp
WHERE sal IN (3000, 1500, 5000);
```
8. 查询3号部门的工资总和
```
SELECT SUM(sal)
FROM emp
WHERE deptno = 3;
```
9. 查询每个部门工资大于1000的员工人数，按照人数升序排序
```
SELECT deptno, count(*) count
FROM emp
WHERE sal > 1000
GROUP BY 
ORDER BY count;
```
10. 查询每种工作中有领导的员工人数按照人数降序排序
```
SELECT job, count(*) c
FROM emp
WHERE mgr IS NOT NULL
GROUP BY job
ORDER BY c DESC;
```
11. 查询所有员工信息，按照部门编号升序排序，如果部门编号一致则工资降序
```
SELECT * 
FROM emp
ORDER BY deptno ASC, sal DESC;
```
12. 查询有领导的员工，每个部门的编号和最高工资
```
SELECT deptno, MAX(sal)
FROM emp
WHERE mgr IS NOT NULL
GROUP BY deptno;
```
13. 查询有领导的员工，按照工资升序排序，第3页的2条数据
```
SELECT * 
FROM emp
ORDER BY sal ASC
LIMIT 4, 2;
```
14. 查询每个部门的工资总和，只查询有上级领导的员工并且要求工资总和大于5400，最后按照工资总和降序排序,只查询结果中的第一条数据
```
SELECT deptno, SUM(sal)
FROM emp
WHERE mgr IS NOT NULL
HAVING SUM(sal) > 5400
GROUP BY deptno
LIMIT 0,1;
```








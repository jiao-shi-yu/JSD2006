# 数据库
+ 之前通过io技术对数据进行增删改查，相当于自己写了一个数据库软件，只不过功能简单，执行效率低下。如果每个项目都自己开发数据操作相关代码，效率更低。互联网行业中凡事使用频繁且繁琐的工作，肯定会有一个通用的解决方案。
+ 学习数据库，就是学习如何和数据库软件进行交流。SQL语言就是程序员和数据库软件进行沟通的语言。
+ DBMS: DataBaseManagementSystem, 数据库管理软件。包括：MySql, Oracle, DB2, SQLServer等
+ 常见DBMS介绍：
  - MySQL: Oracle公司产品， 08年被Sun公司收购， 09年Sun公司被Oracle收购。MySQL是个开源软件。
  - Oracle: Oracle公司产品，性能最高，价格最贵，市场占有率第二。
  - SQLServer: 微软公司产品，闭源。主要应用于微软的整体解决方案中。
  - DB2: IBM公司产品，用在IBM整体解决方案中。
+ 网站整体解决方案： 开发语言 + 操作系统 + web服务软件 + 数据库语言

## SQL语言
- Structured Query Language: 结构化查询语言，用于程序员和DBMS进行交流
- 如何连接数据库软件  

## 使用MySql
安装完成后一定要重启电脑。
使用的话，直接在终端:
```
mysql -u root -p
```
输入密码，即可进入。`exit`退出。

## 数据库相关的SQL语句
+ 查看所有数据库:
```
SHOW DATABASES;
```
+ 创建数据库:
```
CREATE DATABASE db1;
CREATE DATABASE db2 CHARACTER SET utf8;
CREATE DATABASE db3 CHARACTER SET gbk;
```
+ 查看创建数据库时使用的SQL语句:
```
SHOW CREATE DATABASE db1;
```
+ 删除数据库:
```
DROP DATABASE db1;
```
+ 使用数据库:
```
USE db2;
```

## 表相关的SQL语句
执行表相关的SQL语句，必须先创建并使用一个数据库。
```
CREATE DATABASE db1 CHARACTER SET UTF8;
USE db1;
```
+ 创建表
```
CREATE TABLE t1(name varchar(3), age int) CHARSET=UTF8;
CREATE TABLE t2(name varchar(10), sal int);
```
+ 查询所有表
```
SHOW TABLES;
```
+ 查看创建表时使用的SQL语句
```
SHOW CREATE TABLE t1;
```
+ 查看表字段结构
```
DESC t1;
```
+ 删除表
```
DROP TABLE t2;
```
+ 修改表名
```
RENAME TABLE t1 TO person;
```
### 添加、删除和修改表字段

+ 添加表字段
```
ALTER TABLE person ADD gender VARCHAR(10); # 添加在最后面
ALTER TABLE person ADD id INT first;
ALTER TABLE person ADD salary INT AFTER name;
```
+ 删除表字段
```
ALTER TABLE person DROP id;
```
+ 修改表字段
```
ALTER TABLE person CHANGE salary sal INT;
ALTER TABLE person CHANGE age id INT;
```

## 数据相关SQL
必需使用了某一个数据库，并有对应的表。
```
CREATE DATABASE mydb1;
USE mydb1;
CRAETE TABLE person(name varchar(10), age int) CHARSET=UTF8;
```
+ 插入数据：
```
INSERT INTO person VALUES('Tom', 18);
INSERT INTO person(name) VALUES('Jerry');
INSERT INTO person VALUES('Lucy', 58), ('Lily', 59);
INSERT INTO person(name) VALUES('LiLei'),('HanMeimei');
```
`set names gbk`解决中文问题。

+ 查询数据
```
SELECT * FROM person;    # 查询表中所有数据
SELECT name FROM person; # 查询表中的名字
SELECT * FROM person WHERE age > 50; # 查询特定条件
```

+ 修改数据
```
UPDATE 表名 SET 字段名=新值 WHERE 字段名=原值；
UPDATE person SET age=59 WHERE age = 60;
UPDATE person SET age = 20 
WHERE age IS NULL;
```

+ 删除数据
```
DELETE FROM person WHERE age = 20;
DELETE FROM person WHERE name='Tom';
DELETE FROM person;
```
注意是`DELETE FROM`后面直接跟表名。








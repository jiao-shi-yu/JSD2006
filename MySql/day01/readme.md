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
使用的话，直接在终端
```
mysql -u root -p
```
输入密码，即可进入。`exit`退出。

## 数据库相关SQL
+ 查看所有数据库
```
show databases;
```
+ 创建数据库
```
create database db1;
create database db2 character set utf8;
create database db3 character set gbk;
```
+ 查看表详情
```
show create database db1;
```
+ 删除数据库
```
drop database db1;
```
+ 使用数据库
```
use db2;
```

## 表相关SQL
执行表相关的SQL语句，必须先创建并使用一个数据库。
```
create database db1 character set utf8;
use db1;
```
+ 创建表
```
create table t1(name varchar(3), age int) charset=utf8;
create table t2(name varchar(10), sal int);
```
+ 查询所有表
```
show tables;
```
+ 查看表详情
```
show create table t1;
```
+ 查看表字段
```
DESC t1;
```
+ 删除表
```
drop table t2;
```
+ 修改表名
```
rename table t1 to person;
```
+ 添加表字段
```
ALTER TABLE person ADD gender varchar(10); # 添加在最后面
ALTER TABLE person ADD id int first;
ALTER TABLE person ADD salary int AFTER name;
```
+ 删除表字段
```
ALTER TABLE person DROP id;
```
+ 修改表字段
```
ALTER TABLE person CHANGE salary sal int;
ALTER TABLE person CHANGE age id int;
```

## 数据相关SQL
必需使用了某一个数据库，并有对应的表。


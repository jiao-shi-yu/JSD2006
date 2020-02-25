### 子查询（嵌套查询）

1. 查询工资高于1号部门平均工资的员工信息
```
SELECT * 
FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp WHERE deptno = 1);
```
2. 查询工资最高的员工信息
```
SELECT * 
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);
```
3. 查询工资高于2号部门最低工资的员工信息
```
SELECT * 
FROM emp
WHERE sal > (SELECT MIN(sal) FROM emp WHERE deptno = 2);
```
4. 查询和孙悟空相同工作的其他员工信息
```
SELECT * 
FROM emp
WHERE job = (SELECT job FROM emp WHERE ename = '孙悟空')
AND ename <> '孙悟空';
```
5. 查询白骨精的部门信息(需要用到部门表dept)
```
SELECT *
FROM dept
WHERE deptno = (SELECT deptno FROM emp WHERE ename='白骨精');
```
6. 查询所有员工的部门信息
- 查询员工表中的部门编号 `DISTINCT`去重
```
SELECT deptno FROM emp;
SELECT DISTINCT deptno FROM emp;
```
- 通过得到的部门编号查询部门信息
```
SELECT * 
FROM dept 
WHERE deptno 
IN (SELECT DISTINCT deptno FROM emp);
```

#### 关联关系
- 创建表时，表与表之间存在的业务关系
- 有哪些关系？
    1. 一对一 商品表和商品详情表
    2. 一对多 员工和部门
    3. 多堆多 学生和老师

# 关联查询
- 同时查询多张表的数据的查询方式，成为关联查询
- 三种查询方式

## 等值查询
- 格式： `SELECT 字段信息 FROM A,B WHERE 关联关系 AND 其他条件`
- 关联查询必须写关联关系，如果不写会得到两张表的乘积，笛卡尔积。占用大量内存，切记不要出现。
1. 查询每个员工的姓名和对应的部门名
```
SELECT e.ename, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;
```
2. 查询工资高于2000的员工姓名，工资和部门所在地
```
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.sal > 2000;
```

## 内连接
- 格式： `SELE CT 字段信息 FROM A JOIN B ON 关联关系 WHERE 其他条件`
- 好处： 把关联关系和其他条件分来，清晰明了。
1. 查询每个员工的姓名和对应的部门名
```
SELECT e.ename, d.dname
FROM emp e
JOIN dept d
ON e.deptno = d.deptno;
```
2. 查询1号部门员工的姓名,工作,部门名和部门地址
```
SELECT e.ename, e.job, d.dname, d.loc
FROM emp e
JOIN dept d
ON e.deptno = d.deptno
WHERE e.deptno = 1;
```



## 外连接
- 等值连接和内连接查询到的是两张表的交集数据
- 外连接查询一张表的全部数据以及另一张表的交集数据
- 格式：`LEFT / RIGHT JOIN`

1. 查询所有部门名以及对应的员工姓名
```
SELECT d.dname, e.ename
FROM emp e 
RIGHT JOIN dept d
ON e.deptno = d.deptno;
```



















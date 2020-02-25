### 子查询（嵌套查询）

1. 查询工资高于1号部门平均工资的员工信息
```
SELECT AVG(sal)
FROM emp
WHERE deptno=1;

SELECT * 
FROM emp
WHERE sal>(SELECT AVG(sal) FROM emp WHERE deptno=1);
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
WHERE sal > (SELECT MIN(sal) FROM emp);
```
4. 查询和孙悟空相同工作的其他员工信息
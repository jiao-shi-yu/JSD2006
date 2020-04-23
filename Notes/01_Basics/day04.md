
先学一个 Scanner 扫描器类。

## Scanner接收用户输入的数据。
1. 导包
```java
import java.util.Scanner;
```

2. 实例化一个 scanner 对象。
```java
Scanner scanner = new Scanner(System.in);
```

3. 扫描用户输入
```java
System.out.println("请输入年龄:");
int age = scanner.nextInt();
System.out.println("请输入价格");
double price = scanner.nextDouble()
```

## 分支结构

### if 
### if-else
### if-elseif-else

### switch
### 嵌套使用

### break关键字


## 程序流程结构
- 顺序结构：从上到下，逐条执行
- 分支结构：根据条件，执行语句
- 循环结构：循环执行，某条语句

## 变量的作用域：从声明开始到包含它的大括号结束。

## 交换两个变量

```java
int a = 1, b = 2;
int temp = a;
a = b;
b = temp;
```
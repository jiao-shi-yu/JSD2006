# 循环

## 什么是循环？
循环：反复执行一段相同或相似的代码。

## 循环三要素
1. 循环变量的初始化
2. 循环的条件(以循环变量为基础)
3. 循环变量的改变（向着循环的结束变）

## 循环结构

### while 循环
- 语法：
```java
T 循环变量;
while (循环条件) {
    循环体
    更新循环变量;
}
```
- 执行过程：
    1. 先判断是否满足循环条件
    2. 是，则执行循环体
    3. 更新循环变量
    4. 再次判断条件
- 示例：
```java
public class WhileDemo {
    public static void main(String[] args) {
        /**
         * 输出 10 次“行动是成功的阶梯”
         */
        int times = 0;          // 1. 循环变量的初始化
        while (times < 10) {    // 2. 循环条件
            System.out.println("行动是成功的阶梯"+(++times));
            //times ++;             // 3. 循环变量的改变
        }
        System.out.println("Over");

        /**
         * 在控制台输出 9x9 乘法表
         */
        int a = 1, b;
        while (a <= 9) {
            b = 1;
            while (b <= a) {
                System.out.print(b + " * " + a + " = " + a*b + "\t");
                b ++;
            }
            System.out.println();
            a++;    
        }
    }
}
```

### do-while 循环
- 语法：
```java
T 循环变量;
do {
    循环体
    更新循环变量;
} while (循环条件);
```
- 执行过程：
    1. 先执行循环体
    2. 更新循环变量
    3. 然后判断条件
    4. 如果条件成立，则再次执行循环体
- 示例：
```java

```

### For Loop
for循环

### Enhanced For Loop 
增强型 for 循环，是 JDK 5 退出的，通常用于遍历集合或数组。
```java
package day05;

public class EnhancedForLoopDemo {
    public static void main(String[] args) {
        String[] array = {"Three", "Two", "One", "Ready~", "Go!"};
        for (String str : array) {
            System.out.println(str);
        }
    }
}
/**Output:
Three
Two
One
Ready~
Go!
*/
```
## 循环结束的情况有两种
- 循环条件为假
- 碰到 break 语句

## 生成随机数

`Math.random()`生成[0, 1)的一个随机数。


## 死循环：循环条件永远不为 false，将会一直执行下去的循环。会导致内存溢出，一定要避免。

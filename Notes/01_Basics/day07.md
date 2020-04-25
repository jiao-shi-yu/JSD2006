# 数组的复制

##  System.arraycopy
- 直接存内存复制，相较于使用 for 循环遍历寻址复制，要快很多。
- 线程不安全
- 浅复制
System.arraycopy()的 API
```java
public native static void arraycopy(
    Ojbect src,  //源数组
    int srcPos,  //源数组的起始位置
    Object dest, //目标数组
    int destPos, //目标数组的起始位置
    int length   //复制长度
)
```
- 该方法使用了 native 关键字，说明调用的是其他语言写的底层函数。

## Arrays.copyof

```java
public static <T, U> T[] copyof(U[] original, int newLength, Class<? extends T[]> newType) {
    @SuppressWarnings("unchecked")
    T[] copy =((Object)newType == (Object)Object[].class)?(T[]) new Object[newLength]:(T[])Array.newInstance(newType.getComponentType(), newLength);
    System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
    return copy;
}
```

- `original`: 原数组
- `newLength`: 新数组长度
- `newType`: 要返回的副本的类型

- 实际上也是调用`System.arraycopy`; 

- 发生的事情是这样的：
    + 首先它有一个三目运算表达式，根据新数组与原数组的类型是否相同，分别新建了一个相应类型的数组。新数组的类型是指定的类型，长度是指定的 newLength , 用相应类型的默认值填充。
    
    + 然后调用 System.arraycopy 从原数组和新数组的第 0 个位置，开始复制。
    
    + 长度 `Math.min(original.length, newLength)`
        - 如果指定的新长度比较大，那就只复制原数组的长度的元素，后面的元素已经用默认值填充了。这样就实现了一个数组的扩容。
        - 如果指定的新长度比较小，那就复制指定长度，把这个新数组给复制满就行。相当于对原数组进行了一个缩容。


## System.arraycopy()更灵活，功能强大。Arrays.copyof()在数组扩容缩容的时候，使用起来比较方便。




# 数组的排序

Arrays 类有一个`sort()`静态方法，是用来对数组元素进行排序的。

- 把需要排序的数组，作为参数，传入方法就行。
- 还可以通过指定 fromIndex 和 toIndex，实现对数组的一部分元素进行排序。
- 默认是由小到大排序，你可以自定义一个`Comparator`对象作为参数传进去。
- sort()方法是`public static void`修饰的，也就是说没有返回值，是对原数组进行的修改。


# 方法

又叫函数，可重用的代码块。
- 封装一段特定的业务逻辑。
- 方法尽可能独立，一个方法只干一件事。
- 方法可以别反复调用多次。
- 减少代码冗余，有利于代码维护，有利于团队协作。


## 方法的五要素
```java
修饰符 返回值类型 方法名(参数列表) {
    方法体
}
```
## 方法的调用
根据有无返回值：
1. 无返回值：`方法名(有参传参)`
2. 有返回值：`变量类型 变量名 = 方法名(有参传参)`


## return 关键字

两种形式：
1. `return 值;` - 用在有返回值的方法中
    - 结束方法的执行
    - 返回值
2. `return;`    - 用在无返回值的方法中
    - 结束方法的执行












# 数组
- 数组是一种引用数据类型
- 相同类型元素的集合

## 声明数组
`int[] arr = new int[10];` // 声明整形数组 arr, 包含 10 个元素，每个元素都是 int 类型。用 0 来填充。

## 初始化数组
初始化数组中的元素。

```java
int[] arr = new int[3];
int[] arr2 = {1, 4, 7};
int[] arr3 = new int[]{1, 4, 7};

int[] arr4;
// arr4 = {1, 4, 7}; // 编译错误，大括号这种，只能是在声明的同时，初始化。
// 可以写成这样
arr4 = new int[]{1, 4, 7};
```

## 使用数组

- 通过`数组名.length`获取数组长度（元素的个数）。
```java
int[] arr = new int[3];
System.out.println(arr.length);
```
- 通过索引来访问数组中的元素。
```java
int[] arr = new int[3];
arr[0] = 100; // 把 100 赋值给数组中的第一个元素
arr[3] = 400; // 数组下标越界异常
```

## 遍历数组

```java
int[] arr = new int[10];
for (int i = 0; i < arr.length; i++) {
    arr[i] = 100; // 给每个元素都赋值为 100.
}
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]); // 输出数组中的每个元素
}
```












# 正则表达式 Regular Expression

## 字符集合

|正则表达式|说明|
|:-|:-|
|[abc]|a、b、c 中任意一个字符|
|[^abc]|除了 a、b、c 的任意字符|
|[a-z]|a、b、c……、z 中的任意一个字符|
|[a-zA-Z0-9]|a-z,A-Z,0-9,中的任意一个字符|
|[a-z]&&[^bc]|a-z 中除了 bc|

## 预定义字符集合

|预定义字符|说明|
|:-|:-|
|.|任意一个字符|
|\d|任意一个数字字符，相当于[0-9]|
|\w|任意一个单词字符，相当于[a-zA-Z0-9]|
|\w|任意一个空白字符，相当于[\t\n\xOB\f\r]|
|\D|任意一个非数字字符|
|\W|任意一个非单词字符|
|\S|任意一个非空白字符|


## 数量词

|正则表达式|说明|
|:-|:-|
|X?|表示 0 或 1 个 X|
|X+|表示 1 个或多个 X|
|X*|表示 0 或任意多个 X|
|X{n}|表示 n 个X|
|x{n,}|表示 n 个到任意多个 X|
|x{n, m}|表示 n 到 m 个 X |

以邮政编码为例：
1. `[0-9][0-9][0-9][0-9][0-9][0-9]`
2. 使用预定义字符集后：`\d\d\d\d\d\d`
3. 使用数量词后：`\d{6}`

## 分组`()`

- 分组：`()`圆括号表示分组，可以将一系列正则表达式可看做一个__整体__，分组时可以用`|`表示“或”关系。
例如：匹配手机号码前面的区号：
`(\+86|0086)?\s?d{11}`

## 边界匹配`^`和`$`

- `^`表示字符串开始
- `$`表示字符串结束

例如：匹配用户名-从头到尾连续8~10个单词字符
- `\w{8,10}`
- `^\w{8,10}$`



# String 正则 API


## `boolean matches(正则表达式)`  --- 匹配

将一个字符串与正则表达式进行匹配，如果匹配成功就返回 true，否则返回 false。

## `String[] split(String regex)`  --- 拆分
String 的 split 方法可以将字符串按照特定的分隔符，拆分成字符串数组。





# Object 

- 在 Java 类继承结构中，`java.lang.Object`类位于顶端；
- 如果定义一个 Java 类时，没有使用 __extends__ 关键字声明其父类，则其父类默认为 java.lang.Object 类。
- Object 类型的引用 可以指向 任何类型的对象。


## toString()方法

toString()方法是 Object 类中的重要方法，用于返回对象值的字符串表示。



原则上建议重写，格式大多遵循`类名[字段值]`

- Java 语言中很多地方会默认调用对象的 toString() 方法：
    + 字符串 + 对象，自动调用对象的 toString() 方法
    + System.out.println(任意对象), 直接调用 toString() 方法
- 如果不重写 toString() 方法，将使用 Object 的 toString() 方法，其格式为`类名@散列码`
- toString 方法是非常有用的调试工具；
- JDK中的标准类库中，许多类都定义了 toString 方法，方便用户获得有关对象状态的必要信息。
- 强烈建议为自定义的每一个类增加 toString 方法。

## equals 方法
- Object 类中，还有一个 equals() 方法，作用是检测一个对象是否等于另外一个对象。
- 在 Object 类中，这个方法判断两个对象是够具有相同的引用，即是否为相同的对象。
- 在实际应用中，一般需要重写该方法，通过比较对象的成员属性，使该方法更有意义。


### equals 和 == 的区别

- == 用于比较变量的值，可以应用于任何类型，如果用于引用类型，比较的是两个引用变量中存储的值（地址信息）是否相等。即判断两个变量是否指相同的对象。
- equals 是 Object 的方法，重写以后，可以用于比较两个对象的内容是否相等。
- 需要注意的是，Object 默认的 equals 方法的比较规则与 == 相同。





# 包装类
包装类为基本类型添加了面向对象的功能。

- 在进行类型转换的范畴内，有一种搞特殊的转换，需要将 int 这样的基本数据类型转换为对象；
- 所有基本类型都有一个与之对应的类，即包装类(Wrapper)
- 包装类是不可变类，在构造了包装类的对象后，不允许更改其中的值。
- 包装类被 final 修饰，不允许被继承。

|基本类型|包装类|包装类的父类|
|:------|:----|:---------|
|byte|java.lang.Byte|java.lang.Number|
|short|java.lang.Short|java.lang.Number|
|int|java.lang.Integer|java.lang.Number|
|long|java.lang.Long|java.lang.Number|
|float|java.lang.Float|java.lang.Number|
|double|java.lang.Double|java.lang.Number|
|char|java.lang.Character|java.lang.Object|
|boolean|java.lang.Boolean|java.lang.Object|

数字类型有一个统一的包装类 Number. 布尔和字符的包装类则直接继承自 Object。

## Number 及其主要方法
- 抽象类 Number 是 Byte、Short、Integer、Long、Float、Double 的父类；
- Number 的子类必须提供将表示的数值转化为对应基本类型的方法：
```java
包装类的实例对象.xxxValue();
```
- 还提供了将基本类型转换为包装类的静态方法`XXX.parseXXX()`.
- Number 类型的包装类提供了最大值和最小值的静态常量
```java
static 包装类对应的基本类型 MAX_VALUE;
static 包装类对应的基本类型 MIN_VALUE;
```

## equals 比较的是 xxxValue()
```java
public boolean equals(Object obj) {
    if (obj instanceof Integer) {
        return value == ((Integer)obj).intValue();
    }
    return false;
}
```


## 自动装箱和拆箱

**自动拆装箱**是在 **基本数据类型**和其对应的 **包装类**之间，进行自动地类型转换。

是从 JDK 1.5 开始的。

**装箱和拆箱是编译器认可的，而不是虚拟机。**编译器在生成类的字节码文件时，插入必要的方法调用。
```java
Integer a = 100; // 自动装箱
/**
 * 编译器实际长会添加一些方法调用，实际上编译器，编译的是：
 */
Integer a = Integer.valueOf(100);
```



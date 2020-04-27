# 方法的重写(Override)

子类对父类的方法进行重写，进行不同的实现，要求方法名和参数列表必须相同。

## 遵循"两同两小一大"原则:

- 两同
    + 方法名相同
    + 参数列表相同
- 两小
    + 子类重写后的方法，返回值类型，小于或等于父类返回值类型
        * 父类方法返回值类型是 void 子类方法返回值必须相同
        * 父类方法返回值类型是 基本类型时，子类方法返回值必须相同
        * 父类方法返回值类型是 引用类型时，子类方法返回值类型与父类方法相同，或者是父类方法返回值类型的子类。
    + 子类重写后的方法，抛出异常的类型，小于或等于父类抛出异常的类型
- 一大
    + 子类重写的方法的访问控制权限，不能比父类更严格。

## 重写与重载的区别

### 重写(Override)

重写是子类方法对父类方法进行重新实现，在运行时，对方法进行动态绑定。返回值类型，方法名，参数列表都不能变。访问修饰符不能更严格。不能抛出父类方法没有的异常。


### 重载(Overload)

重载是一个类中有多个名称相同、参数列表不同的方法，在编译期，就进行了静态绑定。只要求方法名相同，参数列表不同，其他的就没有要求了。


# 访问修饰符

public 公共的，任何类都可访问
默认不写，包内可见。
protected 包内和其它包中的子类可见。
private 同一个类中可见



# final 关键字

final 最终的，不可变的。 final 可以修饰变量、定义常量、修饰方法和类。

## final 修饰变量
- final 修饰基本类型的变量。表示变量的值不可变。
```java
final int num = 1;
num = 2; // 报错
```
- final 修饰引用类型的变量，表示引用的地址不可变。但是对象的属性，只要未被 final 修饰，还是可以变的。
```java
class Person {
    String name;
}

public class Test {
    public static void main(String[] args) {
        final Person person = new Person("小明");
        System.out.println(person);
//      person = new Person("小红"); // 引用无法更改
        person.name = "小红"; // 对象的属性是可以更改的
        System.out.println(person);
    }
}
```

## final 定义常量

Java 中没有原生的常量，也没有一个关键字来定义常量。  
我们可以通过使用 static final 来修饰变量，达到常量的效果，间接地实现常量。
```java
public static final CONST_ONE = 1;
public static final CONST_TWO = 2;
```
> 常量名一般全部大写，中间用下划线分隔。


## final 修饰的变量必须被初始化

否则编译不通过，这样一来，就避免了空指针异常。


## final 修饰类和方法

被 final 修饰的类，不允许被继承。
被 final 修饰的方法，不允许被重写。




























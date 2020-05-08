# null 表示空，没有指向任何对象。
若引用的值为 null，则该引用不能再进行任何操作了，否则发生__ NullPointerException_。



# 引用类型数组


```java
Student[] stus = new Student[3];
stus[0] = new Student("zs", 16, "LF");
stus[1] = new Student("ls", 28, "JMS");
stus[2] = new Student("ww" ,27, "SD");

stus[0].age = 22;
```

```java
Student[] students = /*new Student[]*/ {
    new Student("zs", 16, "LF"),
    new Student("ls", 28, "JMS"),
    new Student("ww" ,27, "SD")
}
```

# 继承

## 作用：代码复用，便于组织维护。
## 实现：使用 extends 关键字。
## 父类中写共有的属性的行为，子类中写独有的属性和行为。
## 子类具有父类的属性和行为。
## 一个父类可以有多个子类。一个子类只能有一个直接父类。
## 继承具有传递性。
## 构造子类之前，必须先构造父类。
- 在子类的构造方法中，若没有调用父类的构造方法。 -- 则默认使用`super()`，即调用了父类的无参构造。
- 若子类自己调用了父类的某个构造方法，则不会提供默认的构造方法。
- 子类中是用`super()`调用父类的方法，必须写在子类构造方法中的第一行。

## super: 指代当前类的父类
1. super.成员变量名 ------ 访问超类的成员变量
2. super.方法名() -------- 调用父类的方法
3. super() -------------- 调用父类的无参构造







# 嵌套类和内部类

## 内部类基础



## 什么是内部类？什么是嵌套类？
内部类（InnerClass)，定义在类里面的类，称为内部类。

根据官方的说法，首先有一个嵌套类（NestClass）的概念。嵌套类就是类里面嵌套一个类。嵌套类分为静态嵌套类和非静态嵌套类。静态嵌套类完全可以独立存在，只是借外部类的壳儿用一下。非静态嵌套类就是俗称的内部类，必须依附于外部类的存在而存在。

嵌套类被 static 修饰时，称为静态嵌套类；--- Static Nested Classes
没有被 static 修饰时，称作内部类。     --- Inner Classes
内部类有分为局部内部类(Local Inner Classes)和匿名内部类（Anonymous Inner Class)。

所以，广泛意义上的内部类分为四种：

1. 静态嵌套类
2. 成员内部类
3. 局部内部类
4. 匿名内部类



### 1. 成员内部类 (Member Innner Classes)

成员内部类是最普通的内部类，它的定义位于另一个类的内部。

```java
class Circle {
    double radius = 0;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    class Draw {
        public void drawShape() {
            System.out.println("drawShape");
        }
    }
}
```
这样看起来，类 Draw 像是类 Circle 的一个成员，Circle 称为外部类。
**成员内部类**可以无条件地访问外部类的属性和方法。其中也包括了私有属性和静态方法。
```java
class Circle {
    private double radius = 0;
    public static int count = 0;
    public Circle(double radius) {
        this.radius = radius;
    }

    class Draw {
        public void drawShape() {
            System.out.println(radius); // 外部类的 private 成员
            System.out.println(count);  // 外部类的 static 成员
        }
    }
}
```
不过要注意的是，当__成员内部类__拥有和外部类同名的成员变量或者方法时，会发生隐藏现象。即，默认情况下访问的是成员内部类的成员。这个时候，如果要访问外部类的成员，就需要使用`外部类名.this.成员`的形式来访问。

虽然**成员内部类**可以无条件地访问外部类的成员，但是外部类想访问**成员内部类**的成员就没那么容易了。
在外部类中，如果想要访问成员内部类的成员，必须先创建一个成员内部类的对象，然后通过这个对象，访问内部类的成员。

```java
class Cirlce {

    private double radius = 0;

    public static int count = 0;

    public Circle(double radius) {
        this.radius = radius;
        // 外部类需要实例化一个内部类的对象，然后进行访问
        getDrawInstance().drawShape();
    }

    private getDrawInstance() {
        return new Draw();
    }

    class Draw {
        public void drawShape() {
            /**
             * 内部类可以任意访问外部类成员
             */
            System.out.println(radius); // 外部类的 private 成员
            System.out.println(count);  // 外部类的 static 成员
        }
    }
}
```
成员内部类是依附外部类而存在的，也就是说，如果要创建成员内部类的对象，前提是__必须存在一个外部类的对象__。
创建成员内部类对象的一般方式如下:
```java
    public static void main(String[] args) {
        Circle circle = new Circle(4); //自动类型转换
        Circle.Draw draw = new Circle(6).new Draw();
        // private 方法在当前类里面，是可见的。
        Circle.Draw draw2 = new Circle(7).getDrawInstance();
    }
```
内部类可以拥有四种访问权限。

### 2. 局部内部类 (Local Inner Classes)
局部内部类是作用在一个方法或者一个作用域里面的类。 
它和成员内部类的区别在于：局部内部类的访问权限仅限于方法内或者该作用域内。

```java
class People {
    public People() {

    }
}
/* 这个例子有点儿男权哦 */
class Man {
    public Man() {

    }

    public People getWoman() {
        class Woman extends People {
            int age = 16;
        }
        return new Woman();
    }
}
```
注意，局部内部类就像是方法里面的一个局部变量一样，是不能有`public`、`protected`、`private`、`static`修饰符的。



### 3. 匿名内部类(Anonymous Inner Classes)

匿名内部类这一语法适用于创建一次性使用的类。
语法格式为：
```java
new 实现接口() | 父类构造器(实参列表) 
{
    // 匿名内部类的 body
}
```
从定义中可以看出，使用匿名内部类需要注意两点。
- 匿名内部类不能为抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的实例。
- 匿名内部类无法定义构造器。匿名内部类不存在类名，也就无从定义构造器。不过可以通过定义构造器块，来完成构造器需要完成的工作。

**而最常见的匿名内部类的应用场合为：**

#### 通过实现接口，来创建匿名内部类

比如自己定义一个接口：
```java
interface ProductInformationList {
    int getNumber();
    String getName();
}

public class InterfaceAnonymousClassTest {
    
    public void test(ProductInformationList pil) {
        System.out.println("产品名称：" + pil.getName() + "，产品数量：" + pil.getNumber());
    }
    
    public static void main(String[] args) {
        InterfaceAnonymousClassTest ac = new InterfaceAnonymousClassTest();
        ac.test(new ProductInformationList() {
            
            @Override
            public int getNumber() {
                return 1;
            }
            
            @Override
            public String getName() {
                return "电脑";
            }
        });
    }
}
```
以上的例子中：
- `test()`方法需要传入一个`ProductInformationList`的实现类的对象作为参数。
- 如果这个接口的实现类的对象需要重复使用的话，可以将次实现类，独立地定义为一个类。
- 但是现在只需要使用一次，所以就采用上述方法。
- 定义一个匿名内部类，然后直接通过关键字`new`来实例化一个匿名内部类的对象。
注意两点：
- 匿名内部类是需要被实例化的，不能是抽象类。所以__必须实现抽象父类或者接口中的全部抽象方法__。
- 如果通过接口来创建匿名内部类，匿名内部类不能显式地创建构造器。所以__匿名内部类只能有一个显式的无参构造器__。也就是说，new 接口名后的括号里，不能传入参数。


#### 通过过继承抽象父类，来创建匿名内部类

**匿名内部类将拥有一个参数列表与父类型同的构造器**

举个例子：
```java
abstract class Person {
    private String name;
    public abstract double getHeight();
    public Person() {}
    public Person(String name) {
        this.name = name;
    }
    // getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
public class AbstractClassAnonymousClassTest {
    public void test(Person p) {
        System.out.printf("姓名为%s;%n身高为%.2f;%n", p.getName(), p.getHeight());
    }
    public static void main(String[] args) {
        AbstractClassAnonymousClassTest ac = new AbstractClassAnonymousClassTest();
        
        // 调用有参构造，实例化匿名类对象。
        ac.test(new Person("图灵") /*这边调用有参构造传入一个参数*/ 
                {
                    // 实现抽象方法
                    @Override
                    public double getHeight() {
                        return 1.80;
                    } 
                    
                }
        );
        
        ac.test(new Person() /* 这次使用的是无参构造*/ {
            // 实现抽象方法
            @Override
            public double getHeight() {
                // TODO Auto-generated method stub
                return 1.68;
            }
            // 重写父类方法
            @Override
            public String getName() {
                return "小明";
            }
        });
    }
}

```

再比如创建线程时，
如果使用继承 Thread 类的方式，就会耦合性太强。
更推荐的方式是：使用一个实现了 Runnable 接口的类来创建线程。
更进一步的说：实现了Runnable接口的匿名内部类。

```java
new Thread(new Runnable() {
    @Override 
    public void run() {
        int i = 0;
        while (true) {
            i++;
        }
    }
});
```
当然这个 Java 8 之后，我们一般使用 **Lambda 表达式**对匿名类进行一个替换。


### 4. 静态嵌套类 (Static Nested Classes)


什么是内部。内部就是我是你的一部分，我了解你，我知道你的全部。没有你就没有我。（所以内部类对象是以外部类对象存在为前提的。）

什么是嵌套？嵌套就是我跟你没关系，我只是借你的壳用一下，我完全可以自己独立存在。我不跟其他的类有关系，只跟你配合使用。


```java
public class Test {
    public static void main(String[] args) {
        Outter.Inner inner = new Outter.Inner();
    }
}

class Outter {
    public Outter() {
        System.out.println("Outter.Outter()");
    }
    static class Inner {
        public Inner() {
            System.out.println("Outter.Inner.Inner()");
        }
    }
}
```
执行 main() 方法，输出：
```
Outter.Inner.Inner()
```
可以看出静态嵌套类，是一个完全独立的类。根本不需要外部类的实例什么的，就是借它的壳用一下。

## 在编译之后，成员内部类的字节码文件中，有一个指向外部类的 fianl 引用。而静态嵌套类没有。




















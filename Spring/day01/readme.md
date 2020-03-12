### 课前准备
1. 新建Workspace, File -> Switch Workspace
2. 配置Maven, settings.xml

# 1.Srping框架
-------------
- 框架（Framework)：在Java开发领域中，约定了一些特殊的数据处理流程或编程方式，解决特定的问题。具体的表现为一系列的jar文件。

Spring框架主要解决的问题是：**创建对象，并管理对象**。

在传统开发模式下，当需要某个对象时，需要编写`User user = new User();`这样的代码来创建对象，需要通过`getter/setter`方法获取属性值或者为属性赋值。

而在`Spring`中不需要这么麻烦。通过配置文件和注解，就可以很方便的实现创建和管理对象了。


# 2.创建基于Maven的项目
---------------------

# 1. 新建Maven工程

1. `New -> Maven Project`,
2. 勾选`Create a simple Project`
3. 点选Next
    - `Group ld`为`cn.tedu`, 
    - `Artifact Id`为`spring01`，
    - `Packaging`选择`jar`即可。
4. Finish

# 2. 添加依赖:在`pom.xml`中添加`spring-context`的依赖

1. 在[Maven官网](https://mvnrepository.com/)搜索`spring-context`的依赖, 点击页面复制依赖。
2. 在项目的`pom.xml`文件中，添加`<dependencies></dependencies>`节点
3. 在刚刚添加的`<dependecies></dependencies`节点中，粘贴依赖描述。
```xml
    <dependencies>
        <dependency>
            <groupId>org. spr ingf ramework</groupId>
            <artif actId>spring-context</arti factId>
            <version>5.1.5.RELEASE</version>
        </dependency>
    </dependencies>
```

# 3.通过Spring框架获取对象
-----------------------

## 3.1 通过无参数构造方法创建对象

1. 从[达内开发文档服务](doc.canglaoshi.org)下载`Spring`的配置文件，__常用下载 -> 配置文件下载 -> spring-context.zip__.
2. 下载完成后，解压得到__applicationContext.xml__文件，将这个文件复制到项目的`src/main/resources`路径下.


可以自定义一个带main()方法的类，加载以上配置文件，就可以得到Spring容器，并从容器中获取所需的对象：
```
public class SpringTest {
​
  public static void main(String[] args) {
    // 加载Spring配置文件，获取Spring容器
    ClassPathXmlApplicationContext ac
      = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    // 从Spring容器中获取对象，调用getBean()方法时，参数就是配置文件中的Bean Id
    Date date = (Date) ac.getBean("date");
    
    // 测试
    System.out.println(date);
    
    // 关闭
    ac.close();
  }
​
}
```


## 3.2 通过静态工厂方法创建对象

```java
public static Calendar getInstance() {

}
```


## 3.3 通过实例工厂方法创建对象
只要有实例工厂方法，也是可以创建对象的。

另外一个勒种存在方法，可以创建所需要的类的对象。

例如`UserDao`类，`UserDao`不满足无参构造方法和静态工厂方法前提，
但是有一个`UserDaoFactory`


#### Eclipse 配置 jdk

#### Mac OS fn + f2 重命名


# 4. Spring管理的Bean的作用域与生命周期
由Spring管理的Bean，默认是单例的

`<bean>`节点中添加属性`scope="singlton"`或者`scope="prototype"`.

## 附：设计模式之单例模式
如果需要某个类是单例的，例如：
```
public class King {

}
```
其实，不同类肯定不是单例的
```
King k1 = new King();
King k2 = new King();
King k3 = ne2 King();
```
为了避免随意创建对象，会将类的构造方法私有化：
```
public class King {
    private King() {
    
    }
}
```
类的内部还是可以创建对象的，例如：
```
public class King {
    private King king = new King();
    private King() {
    }
    public King getInstance() {
        return king;
    }
}
```
所以在类的外部不可以通过new King()来创建对象。但是可以通过getInstance()方法获取对象。并且调用多少次，都只会得到同一个对象。
以上代码，存在一个巨大缺陷：
想要获得对象，通过`getInstance()`方法，getInstance()又需要一个对象。这就是个死循环。

为了解决这个缺陷，可以在getInstance()方法之前添加static关键字进行修饰。
```
public class King {
    private King king = new King();
    private King() {
    }
    public static King getInstance() {
        return king;
    }
}
```

又有了新的问题：由于static修饰的成员不可以直接访问非static成员。
所以 private King king 也需要用static来修饰。
```
public class King {
    private King king = new King();
    private King() {
    }
    public static King getInstance() {
        return king;
    }
}
```

以上代码是单例模式中的"饿汉式单例模式"
还有一种"懒汉式单例模式".

懒汉式单例模式的基础代码是:
```
public class King {
    private King king;
    private King() {
    }
    public static King getInstance() {
        if (king == null) {
            king = new King();
        }  
        return king;
    }
}
```
但是这样写，有线程安全问题，可能会出现多个实例。

需要加锁:
```
public class King {
    private King king;
    private static final Object lock = new Object();
    private King() {
    }
    public static King getInstance() {
        sychronized (lock) {
          if (king == null) {
            king = new King();
            }  
        }
        return king;
    }
}
```

当添加了锁之后，线程安全问题就解决了，但是: 每次尝试获取对象时，都需要加锁，就会导致getIntance()方法运行效率较低。

所以，并不是每次都需要加锁。改为：
```
public class King {
    private King king;
    private static final Object lock = new Object();
    private King() {
    }
    public static King getInstance() {
        if (king == null) { // 判断有没有必要锁
            sychronized (lock) {
                if (king == null) {  // 判断是否需要创建对象
                    king = new King();
                }  
            }
        }
        return king;
    }
}
```

在配置是，在单例的前提下，还可以在`<bean>`节点，添加属性`lazy-init="true"`就变成了懒汉式加载。

生命周期：

- 应该使用public权限
- 使用void表示返回值类型
- 方法名称可以自定义
- 参数列表为空
```
    public void init() {
        System.out.println("\tUser.init()");
    }
    public void destroy() {
        System.out.println("\tUser.destory()");
    }
```


    
















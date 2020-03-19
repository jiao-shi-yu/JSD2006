### 课前准备
1. 新建Workspace：File -> Switch Workspace
2. 配置Maven->UserSettings: settings.xml

# 1.Srping框架
-------------
- 框架（Framework)：在Java开发领域中，约定了一些特殊的数据处理流程或编程方式，解决特定的问题。具体的表现为一系列的jar文件。

Spring框架主要解决的问题是：**创建对象，并管理对象**。

在传统开发模式下，当需要某个对象时，需要编写`User user = new User();`这样的代码来创建对象，需要通过`getter/setter`方法获取属性值或者为属性赋值。

而在`Spring`中不需要这么麻烦。通过配置文件和注解，就可以很方便的实现创建和管理对象了。


# 2.创建基于Maven的Spring项目
---------------------

# 1. 新建Maven工程



# 2. 添加依赖:在`pom.xml`中添加`spring-context`的依赖

1. 在[Maven官网](https://mvnrepository.com/)搜索`spring-context`的依赖, 点击页面复制依赖。
2. 在项目的`pom.xml`文件中，添加`<dependencies></dependencies>`节点
3. 在刚刚添加的`<dependecies></dependencies>`节点中，粘贴依赖描述。
```xml
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.1.5.RELEASE</version>
        </dependency>
    </dependencies>
```

# 3.通过Spring框架获取对象
-----------------------

## 3.1 通过无参构造方法创建对象

1. 从[达内开发文档服务器](doc.canglaoshi.org)下载`Spring`的配置文件，__常用下载 -> 配置文件下载 -> spring-context.zip__.
2. 下载完成后，解压得到__applicationContext.xml__文件，将这个文件复制到项目的`src/main/resources`路径下.
3. 在配置文件中添加配置信息
```xml
<bean id="date" class="java.util.Date"></bean>
```
>一个<bean>就对应着一个java类，其中`id`属性是一个Bean的唯一标识，后续通过`id`属性获取对象。而`class`属性是需要获取的对象的java类。
4. 在java文件中通过Spring创建对象
准备一个Java测试类`cn.tedu.spring.SpingTest.java`，在`main()`方法中通过Spring容器获取对象。
具体分为四步：
    1. 加载Spring配置文件，获取Spring容器
    2. 调用Spring容器的`getBean()`方法，从容器中获取对象。
    3. 测试
    4. 关闭容器
```java
package cn.tedu.spring;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
        // 1. 加载Spring配置文件，获取容器
        ClassPathXmlApplicationContext appliactionContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 调用容器的getBean()方法，获取对象
        Date date = (Date) appliactionContext.getBean("date");
        // 3. 测试
        System.out.println(date);
        // 4. 关闭
        appliactionContext.close();
    }
}
```

## 3.2 通过静态工厂方法创建对象

静态工厂方法：某个类中存在`static`修饰的方法，该方法 __返回值__是当前类的实例。 
例如：`Calendar`类就就存在一个`getInstance()`的静态工厂方法。

```java
public static Calendar getInstance() {
    // ...
}
```
由于`Calendar`是一个抽象类，不可能通过`new Calendar()`这样的语法创建对象，只能通过`Calendar.getInstance()`这样的静态工厂方法获取实例对象。

Spring也支持通过静态工厂方法创建对象。只需在配置文件的`<bean>`节点下添加一个`factory-method`属性，指明工厂方法的名称。如下所示:
__在applicationContext中:__
```xml
<bean id="calendar" class="java.util.Calendar" factory-method="getInstance"></bean>
```
__在SpringTest.java中:__
```java
public class SpringTest {
    public static void main(String[] args) {
        // 1. 加载Spring配置文件，获取容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 调用容器的getBean()方法，获取对象
        Calendar calendar = (Calendar) applicationContext.getBean("calendar");
        // 3. 测试
        System.out.println(calendar);
        // 4. 关闭
        applicationContext.close();
    }
}
```
控制台中输出类似内容:
```
Thu Mar 12 19:45:33 CST 2020
java.util.GregorianCalendar[time=1584013533969, ......., DST_OFFSET=0]
```

## 3.3 通过实例工厂方法创建对象

如果某个类没有无参构造方法,也没有静态工厂方法,但是存在第二个类, 这个类中存在可以产生第一个类的实例对象的工厂方法.  那么Spring就可以利用这个实例工厂方法, 创建出第一个类的实例对象.

如下代码所示的两个类:
```java
public class UserDao {
    public UserDao(Object object) {

    }
}
```
```java
public class UserDaoFactory {
    public UserDao newDaoInstance() {
        return new UserDao(null);
    }
}
```

在Spring的配置文件中,需要先添加一个工厂类的`<bean>`,跟一个普通的`<bean>`没什么区别,只需要填写`id`和`class`属性.
然后,添加需要用到其实例对象的类的Bean,这个Bean需要额外配置两个属性:
`factory-bean`和`factory-method`,填写工厂类的bean的`id`和工厂类中的实例方法名.

代码如下所示:
```xml
<bean id="userDaoFactory" class="cn.tedu.spring.UserDaoFactory"></bean>
<bean id="userDao" class="cn.tedu.spring.UserDao"
    factory-bean="userDaoFactory" factory-method="newDaoInstance"></bean>
```
然后再测试文件中:
```java
public class SpringTest {
    public static void main(String[] args) {
        // 1. 加载Spring配置文件，获取容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. 调用容器的getBean()方法，获取对象
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        
        // 3. 测试
        System.out.println(userDao);    
        // 4. 关闭
        applicationContext.close();
    }
}
```
跟其它两种通过Spring获取对象的方法,没有什么区别.
控制台中的输出为:
```
Thu Mar 12 20:23:24 CST 2020
java.util.GregorianCalendar[time=1584015804634,......, DST_OFFSET=0]
cn.tedu.spring.UserDao@365c30cc
```


# 4. Spring管理的Bean的作用域与生命周期
-----------------------------------
## 单例 与 非单例
由Spring管理的Bean，默认是单例的. 也就是说,使用同一个Bean id获取到的对象,只有一个,是共用的.  
1. 可以在`<bean>`节点中添加`scope`属性,来指定是否为单例.
`scope="singlton"`为单例;`scope="prototype"`非单例.

比如说先创建一个`User`类:
```java
public class User {
    public User() {
        System.out.println("\tUser.User()"); //syst 快捷键生成打桩方法.
    }
}
```

**当配置为默认的`scope="singleton"`时:**

```xml
<bean id="user" class="cn.tedu.spring.User" scope="singleton"></bean>
```
从Spring容器多次获取同一个类的实例对象,
```java
public class SpringTest {
    public static void main(String[] args) {
        // 1. 加载Spring配置文件，获取容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2. 调用容器的getBean()方法，获取对象
        User user1 = (User) applicationContext.getBean("user");
        User user2 = (User) applicationContext.getBean("user");
        User user3 = (User) applicationContext.getBean("user");
        // 3. 测试
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        // 4. 关闭
        applicationContext.close();
    }
}
```
控制台输出:
```
    User.User()
cn.tedu.spring.User@799d4f69
cn.tedu.spring.User@799d4f69
cn.tedu.spring.User@799d4f69
```
得到的结果是同一个实例对象.

**当配置为`scope="prototype"`，原型，也就是非单例时:**

```xml
<bean id="user" class="cn.tedu.spring.User" scope="prototype"></bean>
```
运行同样的java代码,控制台中输出:
```
    User.User()
    User.User()
    User.User()
cn.tedu.spring.User@799d4f69
cn.tedu.spring.User@49c43f4e
cn.tedu.spring.User@290dbf45
```
可以看到：
此时通过Spring容器获取的多个对象，是不同的实例对象。  


## 作用域 与 生命周期

Spring框架决定对象何时创建何时销毁. 在创建和销毁对象时,如果需要执行特定的操作,就需要调用对应的生命周期方法.

在需要添加生命周期方法的类中,可以自定里两个方法,分别表示初始化方法和销毁方法.  
关于方法的声明,有几点需要注意:
- 应该使用`public`权限
- 返回值为`void`类型
- 方法名叫什么无所谓
- 参数列表必须为空
例如:
```java
public class User {
     public User() {
         //systrace 快捷键生成打桩方法.
         System.out.println("\tUser.User()");       
     }
     
     // 初始化方法
     public void init() {
         System.out.println("User.init()");
     }
     // 销毁方法
     public void destroy() {
         System.out.println("User.destroy()");
     }
}
```
同时,需要在`<bean>`节点中添加两个表示生命周期方法的的属性,`init-method`和`destroy-method`.  并指明对应的初始化方法名,和销毁方法名.
```xml
<bean id="user" class="cn.tedu.spring.User" scope="prototype" init-method="init" destroy-method="destroy"></bean>
```
执行SpringTest测试类,控制台中输出:
```
    User.User()
User.init()
    User.User()
User.init()
    User.User()
User.init()
cn.tedu.spring.User@799d4f69
cn.tedu.spring.User@49c43f4e
cn.tedu.spring.User@290dbf45
```
可以看到,是先执行构造方法,然后立即执行指定的初始化方法.

将`User`Bean改成单例模式:

```
<bean id="user" class="cn.tedu.spring.User" scope="singleton" init-method="init" destroy-method="destroy">
```

然后再运行测试类.

控制台输出:
```
    User.User()
User.init()
cn.tedu.spring.User@2d127a61
cn.tedu.spring.User@2d127a61
cn.tedu.spring.User@2d127a61
User.destroy()
```
可以看到, 单例模式下, 是先执行构造方法, 然后立即执行指定的`init-method`, 最后, 当这个对象用不到了, 在销毁前执行了`destroy-method`.  
总结就是:`创建 -> 执行init-method -> 使用 -> 执行destroy-method -> 销毁`  



# 5. Spring IoC 控制反转
- __IoC__: Inversion of control, 控制反转. 在传统开发模式下, 都是程序员new一个对象, 然后通过SETTER方法设置属性.可以理解为"程序员掌握了对象的控制权". 使用了Spring框架后, 






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


# 配置好了阿里云Maven仓库的settings.xml,复制到下面,便于日后使用:
```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
    http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <localRepository/>
    <interactiveMode/>
    <usePluginRegistry/>
    <offline/>
    <pluginGroups/>
    <servers/>
    <mirrors>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>阿里云公共仓库</name>
            <url>https://maven.aliyun.com/repository/public</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>阿里云谷歌仓库</name>
            <url>https://maven.aliyun.com/repository/google</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>阿里云阿帕奇仓库</name>
            <url>https://maven.aliyun.com/repository/apache-snapshots</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>阿里云spring仓库</name>
            <url>https://maven.aliyun.com/repository/spring</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>*</mirrorOf>
            <name>阿里云spring插件仓库</name>
            <url>https://maven.aliyun.com/repository/spring-plugin</url>
        </mirror>
    </mirrors>
    <proxies/>
    <profiles/>
    <activeProfiles/>
</settings>
```












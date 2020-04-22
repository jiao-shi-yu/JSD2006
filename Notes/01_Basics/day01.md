# Java 语言的特性
1. __面向对象__： 类、对象、接口、封装、继承、多态。
2. __平台无关性__：一次编写，到处运行。不同平台上有不同的JVM。
3. __简单性__：语法简单。没有指针。有垃圾回收。学起来简单，用起来简单。
4. __解释执行__：源代码编译成字节码，然后解释器对字节码进行解释，最后再执行。
5. __多线程__：Java 是支持多个线程同时执行的，并且提供了多个线程之间的同步机制。
6. __分布式__：可以把一个软件根据功能拆分到不同的服务器上，然后通过网络连接把这些功能集合起来。Java 支持各种层次的网络连接，常见的 API 比如说 Socket。
7. __健壮性__：Java 的强类型、异常处理和垃圾回收机制，保证了 Java 的健壮性。
8. __高性能__：Java 不断进行性能优化升级，运行速度还是比较快的。
9. __安全性__：Java 提供了很多的安全防范机制，尤其是针对网络安全这一块。

# 1. 下载安装 JDK 和 Eclipse
# 2. Java 开发环境
## 2.1 Java 编译运行过程
1. 编译期：javac 把`.java`源代码文件编译成`.class`字节码文件
2. 运行期：JVM加载并运行字节码文件。

## 2.2 JVM JRE JDK (面试常考)

- __JVM__：__J__ava __V__irtual __M__achine， Java 虚拟机，作用是加载和运行字节码文件。
- __JRE__：__J__ava __R__untime __E__nvironment，Java 运行时环境，JRE = JVM + 系统类库，运行 Java 程序的最小单元
- __JDK__：__J__ava __D__evelopment __K__it，Java 开发工具箱， JDK = JRE + 编译运行等工具，开发 Java 程序的最小单元

# 3. 配置环境变量

- `JAVA_HOME`: JDK的安装目录
- `CLASSPATH`: 类的搜索路径
- `PATH`: JDK下的 bin 目录



# 4. 集成开发环境 （Integrated Development Environment)

__Eclipse__： IBM，免费，开源

## Eclipse 代码组织形式

- __Project__：项目
- __package__：包
- __class__：类


# 5. 注释

解释性文本，编译时会忽略。

- 单行注释：`// balabala`
- 多行注释：
```java
/* 一行
 * 两行
 */
```
- 文档注释：
```java
/**
 * 这个类演示了文档注释
 * @author yuyu
 * @version 1.1
 */
```

# 写一个 HelloWorld 类

1. 新建项目 __Basics__
2. 新建包 __day01__
3. 新建类 __HelloWorld.java__
代码如下：
```java
package day01;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```


>说明：
    - main 方法为程序的主入口，从main 开始，从 main 结束。
    - 一条 Java 语句要以分号结束。
    - System.out.println() 向控制台换行输出语句。
    - 字符串表示文字信息，用`""`围起来。






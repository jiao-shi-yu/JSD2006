
# 1. 下载安装 JDK 和 Eclipse
# 2. Java 开发环境
## 2.1 Java 编译运行过程
1. 编译期：javac 把`.java`源代码文件编译成`.class`字节码文件
2. 运行期：JVM加载并运行字节码文件。

## 2.2 名词解释

- JVM ：__J__ava __V__irtual __M__achine， Java 虚拟机，作用是加载和运行字节码文件。
- JRE ：Java Runtime Environment，Java 运行时环境，JRE = JVM + 系统类库，运行 Java 程序的最小单元
- JDK ：Java Development Kit，Java 开发工具箱， JDK = JRE + 编译运行等工具，开发 Java 程序的最小单元

# 3. 配置环境变量

- `JAVA_HOME`: JDK的安装目录
- `CLASSPATH`: 类的搜索路径
- `PATH`: JDK下的 bin 目录



# 4. 集成开发环境 （Integrated Development Environment)

Eclipse ： IBM，免费，开源

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

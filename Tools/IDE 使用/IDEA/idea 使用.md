# IntelliJ IDEA 介绍

JetBrains 公司的产品。用于 Java 开发.

该公司还有其他的产品：
- WebStrom: 前端开发 HTML + CSS + JS
- PyCharm: python 开发
- PhpStorm: PHP 开发
- RubyMine: Ruby/Rails
- AppCode: Objective-C/Swift
- Clion: C/C++
- DataGrip: 开发数据库和 SQL
- Rider: .NET 开发
- GoLand: Go 语言开发


## Module
在 Eclipse 中有 Workspace（工作空间) 和 Project （工程）的概念。


# 下载安装
- Ultimate: 使用框架开发必须下载终极版。
- Community: 社区版本免费，功能少



# 使用 IntelliJ IEAD 创建你的第一个 Java 应用


+ Create New Project
    + Java: 
        - Project SDK：
            * 这里可以选择下载JDK，太他喵方便了叭。
            * 想想就好，还是老老实实使用本地的 JDK 吧
            `Mac/Library/Java/JavaVirtualMachines/jdk1.8.0_231.jdk`
            * open
            * Next
        - 不勾选 Create project from template, Next
        - Project Name: HelloWorld
        - Project localtion: 默认就好。Finish
+ Project Window:
        - 可以使用上下箭头移动，`↩`选中，进入文件夹或打开文件
            - Package 用来组织代码文件，相同类别或者相似功能的文件放在同一个包下。对于大型项目尤为重要。
            - 移动到 src, `⌘ + N`: 新建一个类。
            * 选中 Java Class, Enter
            * 可以简单的输入类名
            * 但是也可以输入包名.类名，这样一来，创建类的同时也会创建包
              * `com.example.helloworld.HelloWorld`
            * IntelliJ IDEA 可以创建多种类，
              * Class
              * Interface
              * Enum
              * Annotation
              * JavaFXApplication 等
            * 这个示例中我们选择 Class
+ Eidtor
    + ⇧ + ↩`：跳转到下一行
    + 输入`main`，IDEA 会自动提示**实时模板**代码，`↩ `就会写入模板代码。
    + **⌘ + J**会将当前上下文中所有可用的模板代码显示出来。
    + `Esc`始终会关闭下拉菜单或对话框而不进行更改
    + 一个标准的输出语句，也有对应的实时模板。
    
        + `sout`:  打印一个字符串到`System.out`输出流
        + `soutm`: 打印当前类和方法的名字
        + `soutp`: 输出方法的参数名和参数值
        + `soutv`: 输出一个变量的值。
    + 为了展示 IDEA 的**自动补全**的功能
    
        + 我们就手动敲一个`Sy`，
        + 就看到下拉菜单中出现了`System java.lang`这个类，`Enter`选中
        + `.o`选中
        + `.p`选中
        + 然后会弹出一个参数类型的列表，显示你当前的输入内容的参数类型
        + 如果你觉得他烦，可以`Esc`隐藏。
        + 输出`"Hello World!"`
+ 编译运行
  + IDEA 会把你的程序编译成**Byte Code**，并在**JVM**中运行。
  + 左边有一个**绿色的运行箭头**。也可以 Debug 什么的
  + 快捷键
    + **⌃ ⇧ R**un 运行
    + **⌃ ⇧ D** : Debug 除错
  + 控制台输出
    + 第一行可以看到 JVM 版本等信息
    + 中间是我们要他输出的**Hello World!**
    + 最后是 程序安全结束的意思
  + 可以看到**Project Window**中，IDEA为我们生成了一个
    + out
      + production
        + HelloWorld
          + com
            + excample
              + helloworld
                + HelloWorld.class
  + 字节码文件
  + **切换 Run Window 的快捷键** ：`⌘ 4`.
+ 生成 jar 包
    + `⌘ ;`进入 Project Structure
    + 点击 Artifacts ,  Add Jar From module with dependecies
      + 指定**Main Class**
      	+ Browse 
      	+ 下拉列表中选一个 OK
    	+ OK
	+ OK
	+ **以上步骤，只是设置好了如何生成  jar 包**
	+ 要生成 jar包，还需要构建。
	  + Build 
	    + Build Artifact
	      + Build
	+ 构建完成，可以看到**Project Window**中，生成了
	  + out
	    + artificts
	      + HelloWorld_jar
	        + HelloWorld.jar
+ 运行 jar 包

    + 右键 Run HelloWorld.jar
    + 输出是一样的

    + **自定义一个运行 jar包的配置**
      + **随处搜索** 
        + 快捷键：
          +  **⇧ ⇧ **调出
          +  **⇥ ** 切换
      + 搜索`edit config`
        + Add 
          + Jar Application
            +  Name: HelloWorldJar
            + Configuration
              + Path to Jar 
                + Browse 
                  +  选择 jar包路径
            + Before Lunch
              + Add
                + Build Artifacts
                  +  HelloWorld.jar
+ 更该代码查看配置是够有效

    +  `Hello IntelliJ IDEA!`
    +  Cool!




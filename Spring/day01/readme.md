### 课前准备
1. 新建Workspace, File -> Switch Workspace
2. 配置Maven, settings.xml

# 1.Srping框架
框架：在Java开发领域中，具体的表现为一系列的jar文件，它通常约定了一些特殊的数据处理流程或编程方式，以解决特定的问题。

Spring框架主要解决的问题是：创建对象，并管理对象。简单的说，在传统开发模式下，当需要某个对象时，可以在项目中编写
Spring框架主要解决的问题是:创建对象，并管理对象。简单的说，在传统开发模式下，当需要某个对象时，可以在项目中编写例如`User user = new Uepr();` 这样的代码来创建对象，也可以通过`user .setName("Alex" );`这样的方式来为其中的属性赋值，或者将其声明为`public static User user; `以添加static修饰符使之在内存中的存在时间更长等等，当使用Spring框架后，就不必再写以上这些代码了，相关的工作就可以交给Spring框架来完成，主要是通过配置文件或注解来解决这些问题。

# 2.创建基于Maven的项目
## 创建Maven Project.
1. 在创建过程中:
- 勾选`Create a simple Project`
- `Group ld`为`cn.tedu`, 
- `Artifact Id`为`spring01`，`Packaging`选择`jar`即可。
2. 创建完成之后:
- Spring项目需要在`pom.xml`中添加`spring-context`的依赖
- 关于依赖的代码，可以在[官网](https://mvnrepository.com/)搜索该依赖的名称， 确定所使用的依赖及版本
- 然后，在pom.xml中手动添加<dependencies>节点，粘贴从网站上搜索到的依赖的代码:
```
<dependencies>
<!-- https: / /mvnrepository。com/ arti fact/org . spr ingframework/ spr ing-context -->
<dependency>
<groupId>org. spr ingf ramework</groupId>
<artif actId>spring-context</arti factId>
<version>5.1.5. RELEASE</version>
</dependency>
</dependencies>
```
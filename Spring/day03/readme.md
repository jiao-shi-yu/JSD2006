# 8. Spring 注解
## 8.1 关于Spring注解的基本说明
在Spring框架的实际应用中，很少在XML文件中配置各个需要由Spring管理的Bean，
更多都是在各个类中使用各种注解来完成。

使用注解的有点在于： 便于阅读和理解代码！ 注解都是添加在类中的，所以，打开每个类后，
可以直接直接根据注解及类中的代码，理解其意义，而不必一边看类，一边看XML文件。


## 8.2 组件扫描与通用注解
首先，需要在Spring的配置文件中添加组件扫描的配置：
``` xml
<!-- 组件扫描 -->
    <!-- base-package属性：被扫描的包 -->
    <context:component-scan base-package="cn.tedu.spring"></context:>
```

然后，在需要被Spring管理的的类之前添加`@Component`注解：
``` java
import org.springframework.stereotype.Component;

@Component
public class User {

}
```

至此，Spring就可以创建以上`User`类对象了！
所以，如果要使得Spring框架创建并管理某个类的对象，需要做到：
- 该类在组件扫描的包下
- 该类添加了组件注解

在默认情况下，Spring创建对象时，会将类名的首字母转为小写，作为Bean Id,
例如类名是`User`是，就会使用`user`作为Bean Id.

>如果某个类的名称使用2个连续的大写字母开头，Bean Id就用完整的类名。

如果对自动使用的Bean Id不满意，也可以配置注解参数来自定义Bean Id.
``` java
@Component("user")
public class User {

}
```
在实现这种管理方式时，可以使用的注解有：
- `@Component`: 通用注解，凡不是以下三类组将，就用@Componnet
- `@Controller`: 控制器
- `@Servlet`: 业务组件
- `@Repository`: 持久化组件
以上者四个组件，在Spring框架的作用域中，是完全等效的，使用方式完全一样，只是语义不同。



## 8.3 通过注解管理对象的作用域与生命周期
在Spring管理类的对象的前提下，可以通过`@Scope`注解来配置该类的对象是否单例，
该注解可以配置参数为`singleton`或`protype`, 前者默认单例，后者非单例。
``` java
@Component("user")
@Scope("prototype")
public class User {
    public User() {
        System.out.println("\tUser().user()");
    }
}
```

>当某个类需要添加多个注解时，这些注解不区分先后顺序

实际使用时，单例不需要配置，非单例才配置。


### 在单例模式`@Scope("singleton")`的基本前提下：

添加`@Lazy`注解，就变成了 **懒加载**。
``` java
@Component("user")
@Scope("singleton")
@Lazy
public class User {
    public User() {
        System.out.println("\tUser().user()");
    }
}
```
`@Lazy`可以添加两个值 `true` 或 `false`, `true`为懒加载, `false`为饿汉式加载。
所以，懒加载的时候用`@Lazy`. 默认是饿汉式加载，不用写。




>Spring容器关闭，对象Destroy

>@PostConstruct 和 @PreDestroy 是javax.annotation包下的类，需要导入`javax`包。关联Tomcat就行。

## 8.4 关于自动装配的注解
为了更好的演示自动配置的效果，首先要准备一些类和接口
``` java
public interface UserDao {
    void login();
}
```

``` java
@Repository
public class UserJdbcDao implements UserDao {
    public void login() {
        System.out.println("\tUserJdbcDao.login()");
    }
}
```

``` java
@Repository
public class UserMyBatisDao implements UserDao {
    public void login() {
        System.out.println("\tUserMyBatis.login()");
    }
}
```
``` java
@Controller
public class UserLoginServlet {
    private UserDao userDao;
    public void doPost() {
        System.out.println("\tUserLoginServlet.doPost()");
        userDao.login();
    }
}
```

当需要实现自动装配时，在需要被装配的属性之前添加`@Autowired`注解即可，例如：

``` java
@Controller
public class UserLoginServlet {

    @Autowired
    private UserDao userDao;
    
    ......
    
}
```
该注解的装配机制是：
优先选用`ByType`
    - 找到0个，报错 `at least 1`
    - 找到1个，皆大欢喜
    - 找到2个，报错 `but found 2`

在自动装配的前提下，如果有多个匹配类型的对象，且名称都不匹配, 又不希望修改属性名称。
就可以结合`@Qualifier`注解一起使用：

``` java
@Controller
public class UserLoginServlet {
    @Autowired
    @Qualifier("userMyBatisDao")
    private UserDao userDao;
    
    ......
    
}
```
>注意`userMyBatisDao`首字母小写！

另外， 使用`@Resource`注解，也可以实现自动装配，例如：
```
@Resource
private UserDao userDao;
```

如果使用`@Resource`注解， 需要制定装配的Bean Id, 可以直接在注解中装配参数。
```
@Resource(name="userMyBatisDao")
private UserDao userDao;
```
关于`@Resource`注解的装配机制： 优先尝试`ByName`.

实际使用中更推荐`@Autowired`注解，另外在装配参数时，可能要使用`@Qualifier("")`.

# 9. 小结
- 理解Spring框架的作用：创建对象，管理对象；
- 理解Spring框架的优点：降低了对象的依赖关系，实现了解耦；
- 掌握`<bean>`节点的基本配置，包括其中的属性：`id`, `class`, `factory-method`, `factory-bean`, `scope`, `lazy-init`,`init-method`,`destroy-method`,`autowire`;
- 了解Spring管理的对象的作用域与生命周期;
- 理解Spring框架的IoC和DI;
- 掌握通过SET方式为属性注入值得做法，其中，注入结合类型的属性的做法可以仅了解
- 了解通过构造方法为属性注入值;
- 掌握Spring表达式的使用;
- 理解自动装配中的byName和byType这两种模式
- 了解通过XML配置实现自动装配
- 理解组件扫描并掌握配置
- 掌握`@Component` `@Controller` `@Servive` `@Reposity`注解;
- 了解`@Scope` `@Lazy` `@PostConstruct` `@PreDestroy` 注解;
- 掌握`@Autowired` `@Qualifier` `@Resource` 注解;
- 掌握`@Autowired` 与 `@Resource`的区别。
- 关于Spring AOP会在项目阶段的末期再讲。







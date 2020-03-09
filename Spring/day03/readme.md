# 8. Spring 注解
## 8.1 关于Spring注解的基本说明
在Spring框架的实际应用中，很少在XML文件中配置各个需要由Spring管理的Bean，
更多都是在各个类中使用各种注解来完成。

使用注解的有点在于： 便于阅读和理解代码！ 注解都是添加在类中的，所以，打开每个类后，
可以直接直接根据注解及类中的代码，理解其意义，而不必一边看类，一边看XML文件。


## 8.2 
首先，需要在Spring的配置文件中添加组件扫描的配置：
```
<!-- 组件扫描 -->
    <!-- base-package属性：被扫描的包 -->
    <context:component-scan base-package="cn.tedu.spring"></context:>
```

然后，在需要被Spring管理的的类之前添加`@Component`注解：
```
import org.springframework.stereotype.Component;

@Component
public class User {

}
```

至此，Spring就可以创建以上`User`类对象了！
所以，如果要使得Spring框架创建并管理某个类的对象，需要做到：
- 该类在组件扫描的包下
- 该类添加了组件注解


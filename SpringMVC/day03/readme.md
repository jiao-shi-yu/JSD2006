# 7. 在SpringMVC中使用Session



# 8. 拦截器(Interceptor)

## 8.1 拦截器基本概念
在SpringMVC框架中，可以自定义拦截器组件，并配置所对应的若干个请求，当客户端想这些路径发出
请求是，拦截器组件就会自动执行。在执行时，可以对该请求进行阻止，即：不运行向后执行；也可以选择放行，即正常通过。
## 8.2

## 8.3 配置拦截器
在spring.xml中,配置拦截器链

## 8.5 关于拦截器的详细配置
在配置拦截器时，在`mvc:interceptor`节点的子节点，通过`<mvc:mapping/>`节点配置拦截路径

可以配置多个拦截路径，例如:
```xml
<mvc:mapping path="index.do"/>
<mvc:mapping path="blog/addnew.do"/>
<mvc:mapping path="blog/edit.do">
<mvc:mapping path="blog/delete.do"/>
```
在表示路径时，也可已使用通配符，例如：
```xml
<mvc:mapping path="/index.do"/>
<mvc:mapping path="/blog/*"/>
```
- 以上配置生效后，/blog/路径下的资源，都会被拦截。
需要注意的是  `/blog/*`只会匹配向下一个层级的资源，像`blog/2020/list.do`这样的路径不会被拦截。
- 想要拦截的话，用`/blog/**`来配置。`/blog/**`可以匹配到`blog/`下面层级的所有资源。
- 使用通配符，会出现拦截范围过大的问题，例如：配置为`/user/**`时，`/user/login.do`、`/user/handle_login.do`、`/user/reg.do`、`/user/handle_reg.html`都会被拦截；而这几个路径是不应该被拦截的。

# 9. 过滤器(Filter)


### Systrace



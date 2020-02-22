## Servlet

### 什么是服务器
服务器就是一台高性能电脑，上面安装了各种软件。
- web服务器：安装了web服务软件的电脑。
- 邮件服务器：安装了邮件服务的软件。
- 数据库服务器：安装了数据库服务软件的电脑。
- ftp服务器： 安装了文件传输服务的软件。

### CS和BS网络架构
- CS： Client-Server: 客户端-服务器， 用户体验度更高，开发成本高
- BS： Browser-Server: 浏览器-服务器，跨平台，升级便利。

### web服务软件做了哪些事儿
- 建立底层连接
- 返回文件给客户端
- web服务软件又称web容器，里面装了处理各个业务的Servlet（每一种业务对应一个servlet），web服务软件负责根据请求的路径找到对应的servlet进行响应。

### Servlet
- 什么是Servlet： 用于扩展web服务软件业务功能的组件
- 每一种请求都需要对应一个单独的Servlet

### 如何使用Tomcat（web服务软件）
1. 下载tomcat和源代码
2. 在Eclipse中关联tomcat
```
Preferences -> Server -> Runtime Environments -> 然后添加就好了
```
3. create new server
4. 双击新建的server
```
Server Location 选择安装包的位置
cmd + s 保存设置
```
5. 开启服务
```
cmd opt r 或 右键start
```
6. 测试
```
浏览器中键入localhost:8080, 回车。
```
7. 成功

#### eclipse视图
```
Java EE

window -> show view -> Project Explorer
```

#### 新建maven工程
```
new maven project -> 勾选simple -> Group Id 和 Artifact Id
-> packaging 选 war
```

#### 可能会出错，调错
```
Deployment Descriptor -> 右键 -> Generate Deployment Descript Stub
```

#### 工程与TomCat关联
```
工程 -> Properties -> Target Runtimes -> 勾选TomCat -> apply and close
```

#### 新建servlet
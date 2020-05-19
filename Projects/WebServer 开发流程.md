# 项目概述：
WebServer 是一个网络容器，模拟 Tomcat 的基础功能。

网络容器的主要功能： 

1. 接收用户请求，调用 Servlet, 响应客户端。
2. 内部维护若干 servlet

## 1. 新建 Maven jar 工程

## 2. 新建`com.webserver.core`包

## 3. 创建 WebServer 类
- 启动服务器
- 获取 serverSocket 实例
- 获取 socket 实例
- 获取输出流


# 创建一个 ClientHandler
> 总体的思路 分三步：
> 1. 解析请求
> 2. 处理请求
> 3. 响应客户端



## 解析请求：
服务端应当可以接受多个客户端的请求，
所以用线程处理客户端的请求。
定义一个 ClientHandler 类。





> 设计一个 HttpRequest 类，用来封装一个请求
 - 创建一个 com.webserver.http 包
 - 定义一个 HttpRequest 类
    + 定义属性
    + 构造方法
    + 在 ClientHandler 中实例化 HTTPRequest， 完成解析请求的工作


### 解析请求行
1. 通过输入流获取第一行字符串
2. 将这行字符串按空格拆分为三部分。
3. 拆分后的字符串赋值给属性。

> 经常用到读取一行，索性将他封装为一个私有方法 readLine();




# 找 BUG， 哈哈哈
```java
    private String readLine() throws IOException {
        int d = -1; 
        StringBuilder builder = new StringBuilder();
        while ((d = in.read())!=-1) { // 一直读到 文件末尾 EOF
            char chr = (char)d;
            /* 如果读到行尾，就break; 
             * 一开始，是不会读到 crlf 的
             * 
             * 要确保 builder.length() - 1 >= 0
             */
        
            if(builder.length()!=0&&builder.charAt(builder.length()-1)==13&&chr==10) {
                break;
            }
            builder.append(d);
        }
        return builder.toString().trim();
    }
```

应该是是`builder.append(chr)`。



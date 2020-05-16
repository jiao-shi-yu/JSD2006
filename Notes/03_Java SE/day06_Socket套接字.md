# Socket 套接字

Socket 套接字，TCP/IP协议中，位于传输层和应用层之间的一个抽象层。他把传输层复杂的操作抽象为为几个简单的接口，供应用层调用。
使用 Socket 可以与远端计算机进行通讯。

# Socket
Socket 在`java.net`包下。

## Socket 构造方法:
```java
Socket(String host, int port);
```
- String host, 服务器的 IP 地址
- int port, 应用程序端口号
在实例化的时候就会尝试建立连接，连接成功则会实例化成功，连接失败则会抛出异常。

通过 IP 地址可以找到服务器，
通过端口号可以找到服务器上的服务应用程序。



## Socket 的`getOutputStream()`方法
`OutputStream getOutputStream()`方法，通过 socket 获取输出流。
这个**输出流**写出的字节会通过网络发送给远端计算机。


## Socket 的`getInputStream()`方法
`InputStream getInputStream()`方法，用于读取远端计算机发送过来的数据。

# ServerSocket

ServerSocket 是运行在服务器端的，主要有两个作用：
1. 向系统申请服务端口。客户端通过这个端口与服务器连接。
2. 监听服务端口。如果有一个客户端通过端口申请建立连接，服务器会立即创建一个 Socket。

## ServerSocket 构造方法：
```java
ServerSocket(int port);
```
向服务器申请一个端口。如果申请的端口已经被占用，会抛出一个异常。

## ServerSocket 的`accept()`方法

`Socket accept()`是一个阻塞方法，调用后等待客户端连接。
直到一个客户端连接时，该方法会立即返回一个 Socket，通过这个 Socket 与客户端进行交互。
多次调用该方法可以接受多个客户端的连接。


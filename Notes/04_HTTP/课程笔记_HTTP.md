# HTTP 协议
Hyper Text Transfer Protocal， 超文本传输协议。超文本转换协议。

由万维网制定

是浏览器与服务器通讯的应用层协议，规定了浏览器与服务器之间的交互规则，以及交互数据的信息格式。

HTTP 协议对于客户端与服务端之间的交互规则有以下定义：
## 一问一答
要求浏览器与服务端之间必须遵循一问一答的规则，即：浏览器与服务端简历 TCP 连接后需要**先发送一个请求**， 服务端接收到请求，处理后，再响应客户端。
注意：服务器永远不会给客户端发送信息。

## 使用 TCP 协议
HTTP 要求浏览器与服务端的传输层必须是可靠的传数，因此是使用 TCP 作为传输协议的。

## Request 和 Response
HTTP协议对于浏览器与服务器之间交互的数据格式内容，也有一定要求。
浏览器给服务端发送的内容称为请求 Request
服务器给浏览器发送的内容称为响应 Response

## ISO8859-1
请求和响应中大部分内容都是文本信息（字符串），并且这些文本信息使用的字符集为:ISO8859-1. 这是一个欧洲的字符集，里面是不支持中文的！！！。而实际上请求和响应中出现的字符也就是英文，数字，符号。

# HTTP 请求  
**请求是浏览器范送给客户端的内容**， HTTP 协议中一个请求由三部分构成：请求行，请求头，消息正文。

## 1.请求行
请求行是一行字符串，以连续的两个字符（回车符和换行符）作为结束这一行的标志。
请求行分为三部分：
**请求方式(SP)抽象路径(SP)协议版本(CRLF)** 注：SP 是空格
`GET /index.html HTTP/1.1`

> 回车符和换行符都是不可见字符。
> 回车符：对应 int 为 13, 用CR表示。
> 换行符：对应 int 为 10, 用LF表示。

## 2.消息头
消息头是浏览器给服务器发送的一些附加信息，有的用来说明浏览器自身内容，有的用来告知服务器交互细，有的告知消息正文详情等。

消息头由若干行组成，每行也是以 CRLF 结尾。
每个消息头的格式为 **消息头的名字:(SP)消息头的值(CRLF)
消息头整体以一个单独的(CRLF)结尾。
例如：
```
Host: localhost:8088(CRLF)
Connection: keep-alive(CRLF)
Upgrade-Insecure-Requests: 1(CRLF)
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36(CRLF)
Sec-Fetch-User: ?1(CRLF)
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9(CRLF)
Sec-Fetch-Site: none(CRLF)
Sec-Fetch-Mode: navigate(CRLF)
Accept-Encoding: gzip, deflate, br(CRLF)
Accept-Language: zh-CN,zh;q=0.9(CRLF)(CRLF)
```

## 3.消息正文
消息正文是 **2进制数据**，通常是用户上传的信息，比如：在页面输入的注册信息，上传的附件等内容。


# HTTP 响应

HTTP 响应是服务端发送给客户端的内容。
一个响应包含三部分：

- 状态行
- 响应头
- 响应正文

## 1.状态行
状态行是一行字符串（CRLF 结尾），
由三部分组成，格式为：
**protocol(SP)statusCode(SP)statusReason(CRLF)**  
协议版本 状态码 状态描述  
例如：`http/1.1 200 OK`

### 状态码
状态码，是一个三位数字，分为 5 类：
- `1xx`: 保留
- `2xx`: 成功，表示处理成功，并正常响应
- `3xx`: 重定向，表示处理成功，但需要浏览器进一步响应。
- `4xx`: 客户端错误，表示客户端请求错误导致服务器无法处理。
- `5xx`: 服务端错误，表示服务端处理请求过程中出现了错误。


## 2.响应头
响应头，与请求中的消息头格式一致，表示的是服务器发送给客户端的附加信息。

## 3.响应正文
二进制数据部分。包含的通常是客户端实际请求的资源内容。



## 响应的大致内容
```
HTTP/1.1 200 OK(CRLF)
Content-Type: text/html(CRLF)
Content-Length: 2546(CRLF)
101010101010101010101010……
```

- `Content-Type: text/html`： 告诉浏览器响应正文中的内容是什么类型。
- `Content-Size: 2546`: 告诉浏览器响应正文的大小。
- 浏览器根据响应头中的这两个信息，显示给用户看。



# MIME 类型 -- 媒体类型
Multipurpose Internet Mail Extension
多用途 互联网 邮件 扩展， 称为媒体类型。

是一种标准，用来表示文档、文件或字节流的性质和格式。


通用结构
> type/subtype
> 类型/子类型

mime 类型对大小写不敏感，但传统写法都是小写。

如：
```
text/plain
text/html
text/css
image/jpeg
image/png
audio/mpeg
audio/ogg
audio/wav
video/mp4
application/json
application/javascript
```




# 巧记 CRLF --> 1310

















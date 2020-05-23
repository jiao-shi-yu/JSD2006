> Maven Installations


Add Installation Home: 
`/Users/yuyu/java/apache-maven-3.6.3`

Finish ， Apply and Close.



# 使用 dom4j 解析 XML
步骤：
1. 创建 SAXReader 对象
2. 使用 SAXReader 对象读取 XML 文件，返回 Document 对象
3. 通过 Document 对象获取根元素
4. 通过根元素获取子元素集合


## 方法

### SAXReader 
`SAXReader(File file)`：构造方法，传入一个文件


### 






# 使用 dom4j 生成一个 .xml 文档

## 步骤：
1. 创建一个 Document 对象
2. 向 Document 中添加根元素
3. 向根元素中添加子元素
4. 创建 XMLWriter
5. 将 Document 对象用 XMLWriter 写出
6. 关闭 XMLWriter



## 方法：

### DocumentHelper:

- `static Document createDocument()`:创建一个 Document 文档。

### Document:

- `Element addElement(String name)`:添加一个元素节点，并返回节点的引用。

### Element:

- `Element addText(String text)`: 为当前节点元素添加文本，并返回当前节点元素的引用。
- `Element addAttribute(String name, String value)`: 添加指定的属性和属性值。如果属性已经存在，则是替换属性值。
- `Element addElement(String name)`:添加一个元素节点，并返回节点的引用。

> Document Element Attribute 都是 Bransh.class

### XMLWriter:

- 构造：`XMLWriter(OutputStream out)` 传入一个输出流，以创建一个 XMLWriter。有可能会抛出不支持的编码异常。
- 写出：`void write(Document doc)`:将文档对象写出。
- 关闭：`void close()`: 关闭当前 writer.

> XMLWriter 没有实现 Autocloseable 接口。需要在 fianlly 块中手动关闭。


**会发现，写出的 xml 文件内标签都是紧挨在一起的，不便于程序员的阅读。**
因此 XMLWriter 提供了一个重载的 *构造方法*，可以指定排版格式。
`XMLWriter(OutputStream out, OutputFormat format)`



### OuputFormat: 用来指定输出格式。

有两种输出格式可选：
- 一种紧凑的：`static OutputFormat createCompactPrint()`
- 一种美观的：`static OutputFormat createPrettyPrint()`




COOL!





















# 输入与输出

我们编写的程序，出了自身会定义一些数据信息外，经常还会引用外界的数据，或是将自身的数据发送到外界。

比如，我们编写的程序向读取一个文本文件，又或者我们想将程序中的某些数据，写入到一个文件中。这时我们就要使用到输入与输出。

- 输入：从外界读取数据
- 输出：向外界写出数据


# 流
文件与流的区别



# 输入流与输出流

- 输入流：数据从文件到内存的过程，超类是 InputStream。
- 输出流：数据从内存到文件的过程，超类是 OutputStream。

# 字节流的字符流

- 字节流：读写任何文件
- 字符流：读写文本文件

# 节点流与处理流

按照流是否与特定的地方（如磁盘，内存，设备等）相连，分为**节点流**和**处理流**两类。

- 节点流：可以从或向一个特定的地方（节点）读写数据。
- 处理流：是对一个已经存在的流的连接和封装，通过封装的流的**功能调用**实现数据读写。

处理流的构造方法总是要带一个其他的流对象做参数。
一个流经过其他流的多次包装，称为流的连接。

通常节点流，也称为低级流。
处理流也称为高级流或过滤流。

## 字节流与字符流

# InputStream 和 OutputStream （字节流）

InputStream是所有字节输入流的父类，其定义了基础的读取方法，常用的方法如下：
- `int read()` 读取一个字节， 以 int 形式返回，读取到的字节作为 int 返回值的“低八位”。若返回`-1`，则表示读取到了文件的末尾 EOF
- `int read(byte[] d)` 尝试读取数组长度的字节，并存到数组中。最终返回的是，实际读取到的字节长度。

OutputStream 是所有字节输出流的父类，其定义了基础的写出方法，常用的方法如下：
- `void write(int d)` 写出一个字节，写的是指定 int 的“低八位”。
- `void write(byte[] d)` 将字节数组中的所有字节全部写出。



# FileInputStream 和 FileOutputStream  (文件字节流)

## FileOutputStream 文件字节输出流
是文件的字节输出流，以字节为单位，将数据写出到文件。

### 构造方法：
- `FileOutputStream(File file)`：创建一个向指定 File 对象表示的文件中，写出对象的文件输出流。
- `FileOutputStream(String filename)`：创建一个向指定名称的文件写出数据的文件输出流。

> 这里需要注意：
> 若指定的文件中已经包含内容，那么当使用 FOS 对其写入数据时，会将该文件中原有的数据全部清除。

### 追加模式的构造方法

文件输出流，默认会将文件中的原数据覆盖。若想在原有文件的数据后面追加新数据，则需要一下构造方法创建 FOS。

- `FileOutputStream(File file, boolean append)`: 用追加模式，创建一个文件输出流，输出到指定文件。
- `FileOutputStream(String filename, boolean append`: 用追加模式，创建一个文件输出流，输出到文件名为指定字符串的文件。


### void write()方法

FileOutputStream 继承自 OutputStream，提供了以字节为单位，向文件中写数据的方法 write.

- `void write(int d)`： 将指定字节，写到此文件输出流，只写 int 的“低八位”。

也提供了批量写出字节数据的方法：
- `void write(byte[] bytes)`将 byte.length 长度的字节从数组中写入到文件输出流。



## FileInputStream 文件字节输入流

FileInputStream 是文件的字节输入流，以字节为单位从文件中读取数据。

### 文件输入流构造方法

- `FileInputStream(File file)`：创建一个从指定File对象读取数据的文件输入流。
- `FileInputStream(String name)`：使用给定的字符串，创建一个 File，然后再使用这个 File 创建一个 FileInputStream.

### int read() 方法
FileInputStream 继承自 InputStream，提供了`read()`方法，以字节为单位读取文件数据。

`int read()`：从此输入流中读取一个字节，将读到的字节转换为 int，一个字节表示 int 的范围就是 0-255；若返回-1 则表示EOF.

`int read(byte[] bytes)`从输入流中读取 b.length 个字节数据到数组中。


# 缓冲流 
缓冲流的继承结构：
```
java.lang.Object
    java.io.InputStream
        java.io.FilterInputStream
            java.io.BufferedInputStream
```
过滤流、缓冲流。
## BufferedOutputStream 缓冲输出流

在向应将设备做写出操作时，增加写出次数无疑会降低写出效率。
为此，我们可以使用缓冲输出流，批量写出若干数据，通过减少次数，提高写出效率。
BufferedOutputStream 缓冲输出流，内部维护着一个缓冲区。每当我们向该流写数据时，都会先将数据存入缓冲区。当缓冲区已满时，缓冲流会将数据一次性全部写出。

### BOS的flush()方法
使用缓冲输出流可以提高写出效率，却也存在着缺乏即时性的问题。
某些应用场景下，对于某些写出操作，我们希望立即将这些数据写出，而不是等到缓冲区满后才写出。这时，就可以调用缓冲流的一个方法 flush();（flush--直接的，紧接着）

`void flush()` 将缓冲区的数据强制写出。

## BufferedInputStream 缓冲输入流

在读取数据时，若以字节为单位读取数据。会导致读取次数过于频繁。
因此我们可以通过一次读取多个字节的数据的方式，来提高度去效率。


BufferedInputStream 是缓冲字节输入流。内部维护一个缓冲区（字节数组），在读取字节时，会一次性读取若干个字节，存入缓冲区。缓冲区满了之后，就会存到内存中，缓存区再次使用。

BufferedInputStream 是一个 处理流，该流为我们提供了缓冲功能。



# 对象流

## 对象序列化概念

对象是存在于内存中的。有时候我们需要将对象保存到硬盘上，又有时候，我们需要将对象传输到另一台计算机上。这是我们需要将对象转换为一个字节序列，而这个过程就称为对象的序列化。  

将这样一个字节序列转换为对应的对象的过程称为反序列化。

对象 ----序列化---> 字节序列
对象 <---反序列化-- 字节序列

## ObjectOutputStream

ObjectOutputStream 是用来把对象进行序列化的输出流。

实现对象序列化的方法为：
`void writeObject(Object object)`

该方法可以将对象转换为一个字节序列后写出。

## ObjectInputStream

ObjectInputStream 是用来将对象字节进行反序列化的输入流。

反序列化的方法为：
`Object readObject()`
该方法可以从流中读取字节并转换为对应的对象。

## Serializable 接口

ObjectOutputStream在对象进行序列化是有一个要求。
就是需要序列化的对象所属的类必须实现 Serializable 接口。

实现接口不需要重写任何方法。只是作为可以被序列化的一个标志。

实现了该接口的类，通常需要提供一个常量 serialVersionUID
来表示该类的版本。不显式地声明，也会提供默认的 serialVersionUID.
不同平台编译器实现有所不同，所以若想跨平台，就应该显式地声明serialVersionUID.

如果声明的类的对象序列化存到硬盘上，之后随着需求的变化，更改了类的属性（添加或减少或改名），当反序列化是就会出现 InvalidClassException.

但只要 serialVersionUID 是相同的。这时候他就会将不一样的 field 
设置为默认值，这样就提高了兼容性。

### transient 关键字

对象在序列化后得到的字节序列往往比较大，有时我们在序列化一个对象时，可以忽略默写不必要的属性，从而对序列化后得到的字节序列“瘦身”。

使用关键字 transient 忽略不必要的属性。






























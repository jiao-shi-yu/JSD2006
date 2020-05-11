# File 

- java.io.File 用于表示文件(目录)，可以通过 File 类在程序中操作硬盘上的文件和目录。
- File类只用于表示文件的信息，不能对文件的内容进行访问。

## 构造方法
### File(String pathname)
- 通过 给定路径名字符串 转换成 抽象路径来创建一个新 File 实例。
- 抽象路径应尽量使用相对路径，并且目录的层级分隔符不要直接写`/`或`\`, 应该使用`File.separator`这个常量表示，以避免不同系统带来的差异。

### File(File parent, String Child)

File 还提供了另一个构造方法：
根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。


## 其他方法

### isFile()方法

- File 的 isFile方法 判断当前 File 对象所表示的是否为一个文件。


### length()方法
File 的 length 方法返回文件的长度，即文件所占的字节量。

long length();

### createNewFile()方法
File的 createNewFile()方法，当不存在这个文件时，就创建这个文件。
成功创建返回 true.


### delete()方法
File 的 delete 方法用于删除 此抽象路径名表示的文件或目录。

成功删除，返回 true.

删除目录时，要确保删除的目录为一个空目录。

### isDirectory()方法

File 的 isDirectory()方法，用来判断当前 File 表示的是否为一个目录。

## 当 File 为一个目录时

### mkdir()
创建一个目录


### mkdirs()
创建指定路径的目录，即便他的父目录不存在。

### delete() 
删除目录

### listFiles()方法
File的 listFiles 方法用于返回一个抽象路径名数组，这些抽象路径为路径名的子项。子项有可能是个文件也有可能是个目录。

- File[] listFiles()
- 如果目录下面是空的，就返回一个空数组
- 如果目录不存在，就返回一个 null.
- 如果发生了 I/O 错误，也返回 null.


# FileFilter 接口
- 路径名的过滤器
- 此接口的实例对象可以作为参数，传入`File listFiles()`方法。用来过滤子级文件。





# RandomAccessFile

Java 提供了一个可以对文件随机访问的操作，访问包括读和写操作。该类型为 RandomAccessFile.该类的读写，是基于指针的操作

构造器里面传入一个 File 对象。

需要注意的是 RandomAccessFile 无论读取还是写入数据，都是从指针处开始的。

## 模式
RandomAccessFile 在堆文件进行随机访问操作时，有两个模式，分别为只读模糊(只读取文件数据), 和读写模式(对文件数据进行读写)。

- 只读模式：在创建 RandomAccessFile 时，其提供的构造方法要求我们传入访问模式。
    + `RandomAccessFile(File file, String mode)`
    + `RandomAccessFile(String fileName, String mode);`
    + 第一个参数是文件或文件路径名。第二个参数就是读写模式。
- 读写模式：第二个参数传入`rw`.


## 读写字节
`write(int d)`在当前指针所在位置处写入一个字节，将 int 的"低8位"写出。

`int read();`：该方法会从文件中读取一个 byte 填充到 int 的低8位。一个 int 是32位，前面的24位，用0填充。所以返回的数值是 0 到 255的 int 型数值。如果返回-1，表示读取到了文件末尾。


`write(byte[] d)`：参数是字节的数组，作用是把数组中的每个字节，都写出。

与之类似的还有一个常用方法`write(byte[] d, int offset, int len)`
该方法会把字节数组的一部分字节写到文件中，这一部分是从 offset 位置开始，长度为 len 的一段字节。

`read(byte[] b)`方法：
会从指针处开始，读取字节，将读取到的字节放到`byte[] b`数组中，返回值是 读取到的字节长度。


## 文件指针操作

- `long getFilePointer()` 获取文件指针位置
- `void seek(long position)` 将指针移动到指定位置 
- `skipBytes()` 跳过字节


## 关闭
close() 关闭，以释放系统资源。










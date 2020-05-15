# 字符流 Reader 和 Writer

Reader 是字符输入流的父类；Writer 是字符输出流的父类。

**字符流是以字符(char)为单位读写数据的。一次处理一个 unicode**

字符流的底层，仍然是基本的字节流。一个 Reader 可以连接一个 InputStream。

字符流封装了字符的编解码算法。

## Reader 常用方法
- `int read()`:读取一个字符，将字符的 unicode 编码存到 int 返回值的“低 16 位”。
- `int read(char[] chs)`：从流中读取数组长度的字符，并将读到的字符存入 `char[]`数组。返回值为 实际读取到的字符量。


## Writer 常用方法
- `void write(int c)`: 写出一个字符，写出给定 int 值“低 16位”表示的字符。
- `void write(char[] chs)`: 将给定字符数组中所有字符写出。
- `void write(String str)`: 将给定的字符串写出。
- `void write(char[] chs, int offset, int len)`: 根据起始位置和长度，把字符数组中的部分字符写出。


# 字符转换流

## 字符输入流 InputStreamReader
使用该流可以设置字符集，并按照指定的字符集从流中按照该编码把字节转换为字符并读取。
- `InputStreamReader(InputStream in, String charsetName);`: 可以看到字符流，封装了一个字节流。
- `InputStreamReader(InputStream in)`：不指定字符集，会用系统默认的字符集，创建一个字符输入流。

## 字符输出流

### 字符输出流 OutputStreamWriter

可以设置字符集，按照设置的字符集将字符转换为字节，并写出。  

- `OutputStreamWriter(OutputStream out, String charsetName)`

不写的话，就按照系统默认的字符集来转换。

- `OutputStreamWriter(OutputStream out)`

# PrintWriter
PrintWriter 是具有自动行刷新的字符输出流。其提供了比较丰富的构造方法。

- PrintWriter(File file)
- PrintWriter(String fileName)
- PrintWriter(OutputStream out)
- `PrintWriter(OutputStream out, boolean autoFlush)`
- PrintWriter(Writer writer)
- PrintWriter(Writer writer, boolean autoFlush)

其中，
参数为字节流 OutputStream 和 字符流 Writer 的构造方法有一个 boolean 参数，该参数表示 PrintWriter 是否为__自动行刷新__。


## print 与 println 方法

PrintWriter 提供了丰富的重载 print 与 println 方法。
其中 println 方法会在输出目标数据后自动输出一个系统支持的换行符。

若该流是具有自动行刷新的，那么每当使用 println 方法写出数据时，写出的内容都会被实际写出，而不是进行缓存。

常用方法：
- void print(int i )：打印整数
- void print(char c)：打印字符
- void print(boolean b)：打印布尔值
- void print(char[] c)：打印字符数组
- void print(double d)：打印double 值
- float
- long 
- String

# BufferedReader 

BufferedReader 是缓冲字符串输入流，其内部提供了缓冲区。可以提高读取效率。

## BufferedReader(Reader reader);



## String readLine()

使用 BufferedReader 读取字符串

BufferedReader 提供了一个可以便于读取一行字符的方法：
- String readLine()：该方法会连续读取一行字符串，直到读取到换行符为止。返回的字符串中不包含换行符。



# 简易记事本

* 程序启动后要求用户在控制台先输入文件名，然后对该文件写操作。
* 之后用户在控制台输入的每一行字符串都按行写入到该文件。
* 输出 q ，退出程序。

```java
package io.readerWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 简易记事本工具
 * 程序启动后要求用户在控制台先输入文件名，然后对该文件写操作。
 * 之后用户在控制台输入的每一行字符串都按行写入到该文件。
 * @author yuyu
 *
 */
public class Note {
    public static void main(String[] args) throws IOException {
        System.out.print("请输入文件名：\n> ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        
        PrintWriter pw = new PrintWriter(fileName);
        int i = 1;
        System.out.print("第" + i + "行> ");
        String line = null;
        while(!(line = scanner.nextLine()).equals("q")) {
            pw.println(line);
            i ++;
            System.out.print("第" + i + "行> ");
        };
        scanner.close();
        pw.close();
        System.out.println("保存成功！");
    }
}
```
```
请输入文件名：
> 小明的日记.text
第1行> 我喜欢小红，
第2行> 嘻嘻
第3行> 哈哈哈
第4行> 哈哈哈哈
第5行> 啦啦啦啦啦
第6行> 醒醒
第7行> q
保存成功！

```






##  `Throwable`, `Error` 和 `Exception`
- Throwable 可抛出的，是 Java 异常体系中的最高父类，有两个派生类 Erorr 和 Exception.
- Error 系统级别的错误，虚拟机相关，比如系统崩溃，内存泄漏等。编译器不会对这类错误进行检测，程序中也不应该捕获错误。出现了我们拿他也没办法，程序会被终止运行。
- Exception 程序级别的异常，可以在程序中进行捕获，处理完后，程序还是能跑的。
「
Exception 像是人生中遇到的挫折，跌倒了，爬起来，人生道路还是可以继续的。Error 则像是彗星撞地球，除了 Go Die， 别无选择。
」

## 受查异常和非受查异常

- 受查异常：编译器会进行检查。
    + 如果一个方法中的代码可能会抛出受查异常，我们
        * 要么自己 try-catch 捕获处理
        * 要么在方法签名中使用 throws 声明自己有可能抛出异常，交给别人处理
    + 如果一个段代码不会抛出某一类型的受查异常，而你捕获了该类型的受查异常。编译器也会报错。
- 非受查异常：编译器不会进行检查。Error 和 RuntimeException 都是非受查异常。
    + 常见的 RuntimeException:
        * ClassCastException
        * IndexOutOfBoundsException
        * NullPointerException
        * IllegalArgumentException
        * NumberFormatException
# 异常的抛出与捕获

## try-catch捕获处理
```java
package exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String str = "";
            System.out.println(str.length());
            System.out.println(str.charAt(9));
            System.out.println("一切正常");
        } catch (NullPointerException e) {
            System.out.println("发生了空指针异常");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("字符串索引超出边界异常");
        }
        System.out.println("程序结束");
    }
}
```

```
程序开始了
0
字符串索引超出边界异常
程序结束
```
## try-catch-finally
1. 只要程序走到了 try, finally 中的代码一定执行。
```java
public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        String str = "";
        try {
            System.out.println(str.length());
        } catch (Exception e) {
            System.out.println("出错了");
        } finally {
            System.out.println("finally中的代码块执行了");
        }
        System.out.println("程序结束");
    
    }
}
```
```
程序开始
0
finally中的代码块执行了
程序结束
```
只要程序走到了 try, finally中的代码必定执行：
```java
public class TryCatchFinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始");
        String str = "";
        try {
            System.out.println(str.length());
            return;
        } catch (Exception e) {
            System.out.println("出错了");
        } finally {
            System.out.println("finally中的代码块执行了");
        }
        System.out.println("程序结束");
    
    }
}
```
```
程序开始
0
finally中的代码块执行了
```

2. finally 经常用于关闭资源。
```java
package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class TryCatchFinllayDemo2 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos.dat");
            fos.write(1);
            System.out.println("成功写了一个 1 对应的 二进制低八位");
        } catch (IOException e) {
            System.out.println("出错了！");
        } finally {
            try {
                if (fos!=null) {                    
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

3. JDK 1.7 开始，AutoCloseable 的实现类类，可以写在括号中，自动关闭。不需要 finally.
```java
package exception;

import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("fos.dat");) {
            fos.write(0);
        } catch (IOException e) { 
            e.printStackTrace();
        } // ! 不需要 finally.
    }
}
```

## 主动抛出
throw 用来抛出一个异常。
```java
package exception;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>100) {
            throw new RuntimeException("年龄不合法");
        }
        this.age = age;
    }
    
}
```
## try-catch
```java
package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        // 满足语法但是不满足业务逻辑
        try {
            p.setAge(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(p.getAge());
    }
}
```

## 声明为可能抛出异常的方法
throws 声明方法有可能抛出异常。
```java
package exception;

public class ThrowsDemo {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        // 满足语法但是不满足业务逻辑
        p.setAge(10000);
        System.out.println(p.getAge());
    }
}
```

# 异常 API

1. printStackTrace() 打印异常位置和原因。
```java
package exception;

public class ExceptionAPIDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String str = "a";
            System.out.println(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("程序结束了");
    }
}
```
控制台输出：
```
程序开始了
java.lang.NumberFormatException: For input string: "a"
程序结束了
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:580)
    at java.lang.Integer.parseInt(Integer.java:615)
    at exception.ExceptionAPIDemo.main(ExceptionAPIDemo.java:8)
```


# 自定义异常
自定义异常通常用于定义 业务逻辑错误。

Source -> Generate Constructors from SuperClass.

```java
package exception;

public class IllegalAgeException extends Exception {
    
    private static final long serialVersionUID = 1L;
    
    public IllegalAgeException() {
        super();
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }


}
```
异常实现了序列化接口。
```java
public class Exception extends Throwable {}
public class Throwable implements Serializable {}
```

Person.java 中更改抛出异常的类型。
```java
package exception;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if(age<0 || age>100) {
            throw new IllegalAgeException("年龄不合法");
        }
        this.age = age;
    }
    
}
```
ThrowDemo.java 中 捕获`IllegalAgeException`.
```java
package exception;

public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        // 满足语法但是不满足业务逻辑
        try {
            p.setAge(10000);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
        
        System.out.println(p.getAge());
    }
}
```
控制台输出：
```java
exception.IllegalAgeException: 年龄不合法
0
    at exception.Person.setAge(Person.java:12)
    at exception.ThrowDemo.main(ThrowDemo.java:8)

```










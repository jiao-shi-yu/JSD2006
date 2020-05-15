# 进程、线程与多线程
- 什么是进程？
    + 已经运行的一个程序，操作系统为其分配内存。
- 什么是线程？
    + 程序中一个单一的顺序执行流程。
- 什么是多线程？
    + 软件或硬件上实现多个线程并发同步执行。

# 并发与并行

- 并发原理
    + CPU 一次只能执行一条指令。 操作系统将时间分为多个时间片。多个线程之间切换，宏观上像是同时执行的。
- 并行：
    + 多核 CPU 同时执行，微观与宏观都是同时运行的。

# 线程调度器

#  线程是如何创建的？

## 继承 Thread 类

```java
package thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread th1 = new MyThread1();
        Thread th2 = new MyThread2();
        // 将两个线程跑起来
        th1.start();
        th2.start();
        
    }
}
class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {            
            System.out.println("hello~ 姐");
        }
    }
}
class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("来了，老弟");
        }
    }
}
```
优点：简单直接。
缺点:
1. Java 是单继承的，继承了 Thread 类，就无法继承其他类，这就很不方便。
2. 定义线程的同时，使用 run() 方法定义任务，这就导致线程与任务之间存在耦合关系，不利于线程的重用。


## 实现 Runnable 接口
```java
package thread;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r1 = new MyRunnable1();
        Runnable r2 = new MyRunnable2();
        
        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r2);
        th1.start();
        th2.start();
    }
}

class MyRunnable1 implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是谁啊?");
        }
    }
}

class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("我是查水表的!");
        }
    }
}
```

## 使用匿名内部类
```java
package thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread th1 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("你好骚啊~");
                }
            }
        };
        
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("听我的");
                }
            }
        };
        
        Thread th2 = new Thread(r1);
        th1.start();
        th2.start();
        
    }
}
```

           
# 线程 API
                                                                                                        

## Thread currentThread()
获取当前线程示例。
```java
package thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread);
        dosome();
        Thread th = new Thread() {
            public void run() {
                System.out.println(Thread.currentThread());
            }
        };
        th.start();
    }
    public static void dosome() {
        System.out.println(Thread.currentThread());
    }
    
}
```

```java
Thread[main,5,main]
Thread[main,5,main]
Thread[Thread-0,5,main]

```




# 线程状态

















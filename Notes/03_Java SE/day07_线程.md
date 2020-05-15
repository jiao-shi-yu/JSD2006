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
## String getName(); long getId(); int getPrioriity()
获取线程名称，获取唯一标识，获取线程优先级。

### 3. 线程优先级
- 线程有 1 - 10 表示的 10 个优先级。理论上讲，数字越大，优先级越高，获取 CPU 时间片的几率越大。
```java
package thread;

public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread() {
            public void run() {
                for (int i = 0; i < 99999; i++) {
                    System.out.println("MIN");
                }
            };
        };
        
        Thread norm = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 99999; i++) {
                    System.out.println("NORM");
                }
            }
        };
        
        Thread max = new Thread() {
            public void run() {
                for (int i = 0; i < 99999; i++) {
                    System.out.println("MAX");
                }
            }
        };
        
        
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        
        min.start();
        norm.start();
        max.start();
    }
}
```

## boolean isAlive(); boolean isDaemon(); boolean isInterrupted();
判断线程是否活着，是否为守护线程，是否被打断。
```java
package thread;

public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        // 获取线程名字
        String name =  main.getName();
        System.out.println("name:"+name);
        // 获取线程的唯一标识
        long id = main.getId();
        System.out.println(id);
        // 获取线程优先级
        int priority = main.getPriority();
        System.out.println("优先级："+priority);
        
        boolean isAlive = main.isAlive();
        boolean isDaemon = main.isDaemon();
        boolean isInterrupted = main.isInterrupted();
        System.out.println("isAlive:" + isAlive);
        System.out.println("isDaemon:" + isDaemon);
        System.out.println("isInterrupeted:" + isInterrupted);
    }
}
```
output:
```
name:main
1
优先级：5
isAlive:true
isDaemon:false
isInterrupeted:false

```


# 线程状态

## 1. 初始状态 NEW
通过 new 关键字，创建了一个线程，还没有调用 start() 方法。
## 2. 运行状态 RUNNABLE
包括 Ready 就绪 和 Running 运行中两个状态。‘
### 2.1 就绪状态 Ready
1. 就绪状态是指一个线程准备好了，等待线程调度器调度。
2. 调用线程的 start() 方法，线程就进入了就绪状态。
3. 当前线程 sleep()方法**结束**，其他线程 join()**结束**，等待用户输入**完毕**，某个线程拿到对象锁，这些线程也将进入就绪状态。
4. 当前线程的时间片用完了，或者一个运行中的线程调动 yield() 方法，主动让出时间片，就进入到就绪状态。


### 2.2 运行中状态 Running
线程调度器从选择一个线程，分配给它 CPU 时间片，在该时间片内执行它的代码。

## 3. 阻塞状态 Blocked

阻塞状态是线程阻塞在 synchronized 方法修饰的代码块的状态。

## 4. 等待状态
处于这种状态的线程不会被分配 CPU 执行时间。他们要等待被显示地唤醒。否则会处在无限期的等待状态

## 5. 超时等待
处于这种状态的线程也不会被分配 CPU 执行时间。在到达一定时间后会自动唤醒。

## 6. 终止状态
1. 当线程的 run() 方法完成时，或者主线程的 main() 方法完成时，就认为这个线程是终止了的。线程对象也许是活的，但是他已经不再运行了。
2. 在一个终止了的线程上调用 start() 方法，会抛出 java.lang.IllegalThreadStateException 异常。非法线程状态。




# 线程 API 2
## void start()
启动一个线程。

## static void sleep(long ms)
sleep 静态方法，可以让调用这个方法的线程，阻塞指定毫秒数。超时后，自动回到 runnable 状态。

示例：实现一个计时器
```java
package thread;

import java.util.Scanner;

public class SleepDemo {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        System.out.println("计时开始");
        try {
            /**
             * 完成倒计时程序，程序启动后，输入一个数字。
             * 然后从该数字开始计时
             * 
             */
            for (int i = seconds; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1 * 1000);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("计时结束");
    }
}
```
一个线程正在 sleep 的过程中，调用 interrupet 方法会导致抛出中断异常。





# 进程、线程与多线程
- 什么是进程？
    + 已经运行的一个程序，操作系统为其分配内存。
- 什么是线程？
    + 程序中一个单一的顺序执行流程。
- 什么是多线程？
    + 软件或硬件上实现多个线程并发同步执行。

# 并发与并行

- 并发原理 Concurrent
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
```java
package thread;

public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread() {
            public void run() {
                System.out.println("林：刚美完容，睡一会儿吧...");
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    System.err.println("林：干嘛呢！干嘛呢！都破了相了！");
                }
                System.out.println("林：醒了。");
            }
        };
        Thread huang = new Thread() {
            public void run() {
                System.out.println("黄：开始砸墙：");
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1 * 1000);
                        System.out.println("80~");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("咣当！");
                System.out.println("搞定！");
                lin.interrupt();
            }
        };
        lin.start();
        huang.start();
        
    }
}
```
Output:
```
林：刚美完容，睡一会儿吧...
黄：开始砸墙：
80~
80~
80~
80~
80~
咣当！
搞定！
林：干嘛呢！干嘛呢！都破了相了！
林：醒了。
```

## final setDaemon(boolean on)
用户线程：我们平常创建的普通线程。
守护线程：用来服务于用户线程。可以通过 setDaemon() 来设置。
**当线程只剩下守护线程的时候，JVM 就会退出**。
观察下面代码和输出：
```java
package thread;

public class SetDaemonDemo {
    public static void main(String[] args) {
        Thread rose = new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Rose:let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Rose: Ahhhhh~");
                System.out.println("噗通！");
            }
        };
        
        Thread jack = new Thread() {
            public void run() {
                while(true) {
                    try {                       
                        System.out.println("Jack: You jump! I jump!");
                        Thread.sleep(1*1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        rose.start();
        jack.start();
    }
}
```
```
Rose:let me go!
Jack: You jump! I jump!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose: Ahhhhh~
噗通！
Jack: You jump! I jump!
Jack: You jump! I jump!
Jack: You jump! I jump!
Jack: You jump! I jump!
Jack: You jump! I jump!
Jack: You jump! I jump!
Jack: You jump! I jump!
```
可以看到 jack 线程的死循环会一直执行下去。像是个渣男，哈哈哈哈。

当把 jack 线程设置为守护线程时，则会看到不一样的结果。
```java
package thread;

public class SetDaemonDemo {
    public static void main(String[] args) {
        Thread rose = new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Rose:let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Rose: Ahhhhh~");
                System.out.println("噗通！");
            }
        };
        
        Thread jack = new Thread() {
            public void run() {
                while(true) {
                    try {                       
                        System.out.println("Jack: You jump! I jump!");
                        Thread.sleep(1*1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        rose.start();
        jack.setDaemon(true);
        jack.start();
    }
}
```
控制台输出：
```
Rose:let me go!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Jack: You jump! I jump!
Rose:let me go!
Jack: You jump! I jump!
Rose: Ahhhhh~
噗通！
```
可以看到 rose 线程结束。 守护线程也结束了。

> 注意要在线程启动之前，将其设置为守护线程。


## join()

调用 join() 方法的线程在执行完 run()方法之前会一直阻塞在 join 方法处。run() 执行完成后，才会执行后面的代码。这就实现了线程同步。

多个线程执行存在先后顺序，称为同步运行。
多个线程执行，没有先后顺序，称为异步运行。


下面的示例，模拟下载一张图片
```java
package thread;

public class JoinDemo {
    public static boolean isFinish = false;
    public static void main(String[] args) {
        
        Thread download = new Thread() {
            public void run() {
                System.out.println("download：开始下载图片");
                for (int i = 0; i <= 100; i++) {
                    System.out.println("download: 已下载" + i + "%...");
                    try {                       
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("下载完成！");
                isFinish = true;
            }
        };
        
        download.start();
        
    }
}
```
控制台输出：
```
download：开始下载图片
download: 已下载0%...
download: 已下载1%...
(中间省略)
download: 已下载93%...
download: 已下载94%...
download: 已下载95%...
download: 已下载96%...
download: 已下载97%...
download: 已下载98%...
download: 已下载99%...
download: 已下载100%...
下载完成！
```
下面这个进程模拟显示图片和文字。
```java

        
        Thread show = new Thread() {
            public void run() {
                try {
                    System.out.println("开始显示文字");
                    Thread.sleep(5000);
                    System.out.println("完成显示文字");
                    
                    System.out.println("开始显示图片");
                    if (!isFinish) {
                        throw new RuntimeException("图片加载失败");
                    }           
                    System.out.println("完成显示图片");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        };
        show.start();

```
控制台输出：
```
开始显示文字
download：开始下载图片
download: 已下载0%...
download: 已下载1%...
download: 已下载92%...
download: 已下载93%...
download: 已下载94%...
完成显示文字
开始显示图片
java.lang.RuntimeException: 图片加载失败
    at thread.JoinDemo$2.run(JoinDemo.java:41)
download: 已下载95%...
download: 已下载96%...
download: 已下载97%...
download: 已下载98%...
download: 已下载99%...
download: 已下载100%...
下载完成！

```
调用 join() 的线程执行完成后，后面的代码才会执行。
```java
        Thread show = new Thread() {
            public void run() {
                try {
                    System.out.println("开始显示文字");
                    Thread.sleep(5000);
                    System.out.println("完成显示文字");
                    
                    download.join(); // <-----
                    
                    System.out.println("开始显示图片");
                    if (!isFinish) {
                        throw new RuntimeException("图片加载失败");
                    }           
                    System.out.println("完成显示图片");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        };
        show.start();
```
控制台输出：
```
download: 已下载93%...
download: 已下载94%...
完成显示文字
download: 已下载95%...
download: 已下载96%...
download: 已下载97%...
download: 已下载98%...
download: 已下载99%...
download: 已下载100%...
下载完成！
开始显示图片
完成显示图片
```
可以看到 download线程执行完成之后，才开始执行后面的代码。

> 语法上有一个小小的注意点。
> 方法的局部内部类引用方法的其他局部变量，要求这个局部变量是 final 修饰的。
> 这就是用一个属性`boolean isFinish`的原因。
> JDK 8 之后，局部内部类引用方法的局部变量，如果只是用他的值，而不给他重新赋值的话。就不需要用 final 修饰。但是，上面这个示例中 isFinish 是要被更改为 true 的。因此并不适用。还是要用一个属性来写。

# 多线程
同时干几件事情，各干各的，怕就怕抢一个资源。

```java
package thread;

public class BeansDemo {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t2.start();
    }
}


class Table {
    // 桌子上有20个豆子
    private int beans = 20;
    public int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        // yield() 主动让出 CPU 时间
        Thread.yield(); // 模拟到这里没有时间了。
        return beans --; 
    }
}
```
这段代码模拟两个线程抢豆子。
有一定几率会出现：
```
Thread-0:-313389
Thread-1:-313390
Thread-0:-313391
Thread-1:-313392
Thread-0:-313393
Thread-1:-313394
Thread-1:-313395
Thread-0:-313396
Thread-1:-313397
Thread-0:-313398
Thread-1:-313399
Thread-0:-313400
Thread-1:-313401
```
#### 过程分析
举个例子。
当还剩一颗豆子的时候，比如线程 1 执行到
```java
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
```
然后`Thread.yield()`让给线程 2 执行。
线程 2 刚好也是执行到
```java
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        // yield() 主动让出 CPU 时间
```
让给线程 1，
然后线程 1 运行
```java
return beans --;
```
线程 1 return 1, beans == 0;

如果这个时候，线程 1 让给线程 2.
线程 2 也会执行
```java
return beans --;
```
线程 2 return 的是 0， beans == -1;
然后后面就精彩了。
一直循环到 -21亿， 然后溢出到 正21亿，再次减到 0，才有可能结束。


# 上个锁——————把抢这件事儿变成排队干
## 同步方法
上面那个例子中，只需要在访问临界资源的方法那里加一个`synchronized`关键字即可。

```java
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        // yield() 主动让出 CPU 时间
        Thread.yield(); // 模拟到这里没有时间了。
        return beans --; 
    }
```
控制台输出：
```
Thread-0:3
Thread-1:2
Thread-0:1
Exception in thread "Thread-1" Exception in thread "Thread-0" java.lang.RuntimeException: 没有豆子了
    at thread.Table.getBean(BeansDemo.java:33)
    at thread.BeansDemo$2.run(BeansDemo.java:18)
java.lang.RuntimeException: 没有豆子了
    at thread.Table.getBean(BeansDemo.java:33)
    at thread.BeansDemo$1.run(BeansDemo.java:9)
```

#### 过程分析
举个例子。
当还剩一颗豆子的时候，比如线程 1 执行到
```java
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        // yield() 主动让出 CPU 时间
        Thread.yield(); // 模拟到这里没有时间了。
        return beans --; 
    }
```
**线程 1 就会给这段代码上个锁**。

执行到`Thread.yield()`，把 CPU 时间片让给线程 2 执行。

线程 2 执行这段代码，
```java
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        // yield() 主动让出 CPU 时间
        Thread.yield(); // 模拟到这里没有时间了。
        return beans --; 
    }
```
发现已经被线程 1 上了锁，他进不去，只有在外面等着。这段 CPU 时间片段消耗完成后。运行时间有交给了线程 1.

线程1，接着上次的任务运行。
```java
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
        // yield() 主动让出 CPU 时间
        Thread.yield(); // 模拟到这里没有时间了。
        return beans --; 
    }
```
`return beans --` 得到的结果是：
return 1, beans == 0;

线程 1，接着运行到:
```java
    public synchronized int getBean() {
        if (beans == 0) {
            throw new RuntimeException("没有豆子了");
        }
```
就会抛出一个异常，说没有豆子了。


被 sychronized 修饰的方法称为同步方法。多个线程不能同时访问。可以有效解决线程安全问题。


## 同步块

同步是一种高开销的操作，通常没有必要同步整个方法。使用 sychronized 代码块同步关键代码即可。
语法：
```java
synchronized(同步监视器对象) {
    需要同步运行的代码块
}
```


### 使用同步方法：
```java
package thread;

public class ShoppingDemo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop {
    public synchronized void buy () {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"：正在挑衣服");
            Thread.sleep(5000);
            System.out.println(t.getName()+"：正在试衣服");
            Thread.sleep(5000);
            System.out.println("结算离开");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
```
控制台输出：
```
Thread-0：正在挑衣服
Thread-0：正在试衣服
结算离开
Thread-1：正在挑衣服
Thread-1：正在试衣服
结算离开
```
### 使用同步块
只在真正需要同步的地方，上锁。
```java
package thread;

public class ShoppingDemo {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Thread t1 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop {
    public void buy () {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"：正在挑衣服");
            Thread.sleep(5000);
            synchronized(this) {
                System.out.println(t.getName()+"：正在试衣服");
                Thread.sleep(5000);
            }
            System.out.println("结算离开");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
```
控制台输出：
```
Thread-0：正在挑衣服
Thread-1：正在挑衣服
Thread-0：正在试衣服
结算离开
Thread-1：正在试衣服
结算离开
```
这就很 Nice~


### 对象锁
Java 每个对象都有一个内置锁。
需要同步的两个线程，确保对应的是同一个对象锁。
以下代码无法达到同步效果。
```java
synchronized (new Object()) {
    
}
```
相当于两个试衣间。

## 类锁
Synchronized修饰静态方法，实际上是对类对象上锁。

```java
package thread;

public class SynchronizedStaticMethodDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                Foo.dosome();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                Foo.dosome();
            }
        };
        t1.start();
        t2.start();
    }
}

class Foo {
    public synchronized static void dosome() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "：正在执行");
            Thread.sleep(5000);
            System.out.println(t.getName() + "：完成执行");
        } catch (Exception e) {
            
        }
    }
}
```
控制台输出：
```
Thread-0：正在执行
Thread-0：完成执行
Thread-1：正在执行
Thread-1：完成执行

```

### 也可以使用同步块指定类锁
```java
package thread;

public class SynchronizedStaticMethodDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                Foo.dosome();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                Foo.dosome();
            }
        };
        t1.start();
        t2.start();
    }
}

class Foo {
    public static void dosome() {
        try {
            synchronized(Foo.class) {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + "：正在执行");
                Thread.sleep(5000);
                System.out.println(t.getName() + "：完成执行");
            }
        } catch (Exception e) {
            
        }
    }
}
```
效果是一样的。
```
Thread-0：正在执行
Thread-0：完成执行
Thread-1：正在执行
Thread-1：完成执行

```

# 互斥与同步
- 互斥：同一时刻，只允许一个线程对临界资源进行访问。
    - A 线程对临界资源进行操作时，B 线程必须等待。 
- 同步：同步是在互斥的基础上，实现进程间的有序访问。
    - A 线程对读的时候，B 线程不能写。
```java
package thread;

public class HuChiDemo {
    public static void main(String[] args) {
        File file = new File();
        Thread t1 = new Thread() {
            public void run() {
                file.read();
            }
        };
        
        Thread t2 = new Thread() {
            public void run() {
                file.write();
            }
        };
        t1.start();
        t2.start();
    }
}


class File {
    public synchronized void read() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+": reading......");
            Thread.sleep(5000);
            System.out.println(t.getName()+": Done!");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public synchronized void write() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+": writing......");
            Thread.sleep(5000);
            System.out.println(t.getName()+": Done!");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
```
控制台输出：
```
Thread-0: reading......
Thread-0: Done!
Thread-1: writing......
Thread-1: Done!

```
上面示例中的 read() 方法 和 write() 方法就是互斥的关系。读的时候不应当写，写的时候不应当读。他俩对应到同一个对象锁。
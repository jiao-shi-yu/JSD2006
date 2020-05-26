线程池是管理线程的一套解决方案。
主要工作：
1. 控制线程数量
    - 线程数量过多会消耗大量内存，有可能引起内存溢出崩溃。
    - 线程数量过多会导致过度切换，从而降低整体并发性能。
2. 重用线程
    - 线程不应当与任务的生命周期一致
    - 重复使用线程可以减少线程调度器的不必要开销


## ExecutorService
```java
public class ThreadPoolDemo {
    public static void main(String[] args) {
        
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        
        
        for (int i = 0; i < 5; i ++) {
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + "执行完成\n");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(run);
            System.out.println("指派了一个任务给线程池");
        }
    }
}
```


控制台输出：
```
指派了一个任务给线程池
pool-1-thread-1开始执行
指派了一个任务给线程池
指派了一个任务给线程池
指派了一个任务给线程池
pool-1-thread-2开始执行
指派了一个任务给线程池
pool-1-thread-2执行完成

pool-1-thread-1执行完成

pool-1-thread-1开始执行
pool-1-thread-2开始执行
pool-1-thread-1执行完成

pool-1-thread-1开始执行
pool-1-thread-2执行完成

pool-1-thread-1执行完成
```

- 线程是两个两个执行的。
- 线程 1 和线程 2 是重用的。
- 任务都执行完了，线程池里的线程还是存在的。

### execute 执行
### shutdown 停止
### shutdownNow 现在停止













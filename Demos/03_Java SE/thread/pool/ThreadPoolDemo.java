package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		threadPool.shutdown();
		System.out.println("停止线程");
	}
}

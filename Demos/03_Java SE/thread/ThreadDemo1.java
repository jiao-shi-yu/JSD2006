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
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

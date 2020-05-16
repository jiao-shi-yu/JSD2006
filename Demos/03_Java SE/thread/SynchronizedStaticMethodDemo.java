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
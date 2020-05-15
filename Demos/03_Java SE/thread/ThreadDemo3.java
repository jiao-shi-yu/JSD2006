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

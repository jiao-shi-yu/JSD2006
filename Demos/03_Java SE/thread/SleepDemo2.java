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

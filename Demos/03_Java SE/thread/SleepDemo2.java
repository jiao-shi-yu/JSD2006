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
				System.out.println("林：睡醒了。");
			}
		};
		Thread huang = new Thread() {
			public void run() {
				System.out.println("开始砸墙：");
				
				System.out.println("80~");
			}
		};
	}
}

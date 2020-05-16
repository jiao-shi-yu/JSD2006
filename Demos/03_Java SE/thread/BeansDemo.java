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
	public synchronized int getBean() {
		if (beans == 0) {
			throw new RuntimeException("没有豆子了");
		}
		// yield() 主动让出 CPU 时间
		Thread.yield(); // 模拟到这里没有时间了。
		return beans --; 
	}
}
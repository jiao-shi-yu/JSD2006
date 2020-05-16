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
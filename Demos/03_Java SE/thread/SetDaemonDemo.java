package thread;

public class SetDaemonDemo {
	public static void main(String[] args) {
		Thread rose = new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Rose: Ahhhhh~");
				System.out.println("噗通！");
			}
		};
		
		Thread jack = new Thread() {
			public void run() {
				while(true) {
					try {						
						System.out.println("Jack: You jump! I jump!");
						Thread.sleep(1*1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		rose.start();
		jack.setDaemon(true);
		jack.start();
	}
}

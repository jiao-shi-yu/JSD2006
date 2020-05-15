package thread;

public class PriorityDemo {
	public static void main(String[] args) {
		Thread min = new Thread() {
			public void run() {
				for (int i = 0; i < 99999; i++) {
					System.out.println("MIN");
				}
			};
		};
		
		Thread norm = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 99999; i++) {
					System.out.println("NORM");
				}
			}
		};
		
		Thread max = new Thread() {
			public void run() {
				for (int i = 0; i < 99999; i++) {
					System.out.println("MAX");
				}
			}
		};
		
		
		min.setPriority(Thread.MIN_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		
		min.start();
		norm.start();
		max.start();
	}
}

package day07.innerClasses.anonymous;

public class RunableDemo {
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				while (true) {
					i++;
					System.out.println(i);
				}
				
			}
			
		});
		thread.start();

	}
}

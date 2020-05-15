package thread;



public class JoinDemo {
	public static boolean isFinish = false;
	public static void main(String[] args) {
		
		Thread download = new Thread() {
			public void run() {
				System.out.println("download：开始下载图片");
				for (int i = 0; i <= 100; i++) {
					System.out.println("download: 已下载" + i + "%...");
					try {						
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("下载完成！");
				isFinish = true;
			}
		};
		
		download.start();
		
		Thread show = new Thread() {
			public void run() {
				try {
					System.out.println("开始显示文字");
					Thread.sleep(5000);
					System.out.println("完成显示文字");
					
					download.join();
					
					System.out.println("开始显示图片");
					if (!isFinish) {
						throw new RuntimeException("图片加载失败");
					}			
					System.out.println("完成显示图片");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		};
		show.start();
	}
}

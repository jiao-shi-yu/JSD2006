package thread;

public class ThreadInfoDemo {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		// 获取线程名字
		String name =  main.getName();
		System.out.println("name:"+name);
		// 获取线程的唯一标识
		long id = main.getId();
		System.out.println(id);
		// 获取线程优先级
		int priority = main.getPriority();
	 	System.out.println("优先级："+priority);
		
		boolean isAlive = main.isAlive();
		boolean isDaemon = main.isDaemon();
		boolean isInterrupted = main.isInterrupted();
		System.out.println("isAlive:" + isAlive);
		System.out.println("isDaemon:" + isDaemon);
		System.out.println("isInterrupeted:" + isInterrupted);
	}
}

package thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread);
        dosome();
        Thread th = new Thread() {
            public void run() {
                System.out.println(Thread.currentThread());
            }
        };
        th.start();
    }
    public static void dosome() {
        System.out.println(Thread.currentThread());
    }
    
}

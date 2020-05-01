package day06;

public class StaticDemo {
	public static void main(String[] args) {
		Coo o1 = new Coo();
		Coo o2 = new Coo();
	}
}
class Coo {
	static {
		System.out.println("静态块");
	}
	Coo() {
		System.out.println("构造方法");
	}
}
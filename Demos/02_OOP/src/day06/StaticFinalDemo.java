package day06;

public class StaticFinalDemo {
	public static void main(String[] args) {
		System.out.println(Eoo.num);
		System.out.println(Doo.PI);
	}
}

class Eoo {
	
	public static int num = 5;
	static {
		System.out.println("num="+num);
		num =  6;
		System.out.println("静态块执行完毕");
	}
}


class Doo {
	public static final double PI;
	static {
		PI = 3.14; // 在静态块中初始化
	}
}
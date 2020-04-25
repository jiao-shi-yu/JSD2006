package day03;

public class SuperDemo {
	public static void main(String[] args) {
		Boo boo = new Boo();
	}
}


class Aoo {
	Aoo() {
		System.out.println("Aoo.Aoo()");
	}
}

class Boo extends Aoo {
	Boo() {
		//super(); // 默认的，不写也会调用这个，父类的构造有多个的话，也可以选择别的。
		System.out.println("Boo.Boo()");
	}
}

class Coo {
	Coo(int a) {
		
	}
}

class Doo extends Coo{

	Doo() {
		super(5);
		
	}
	
}
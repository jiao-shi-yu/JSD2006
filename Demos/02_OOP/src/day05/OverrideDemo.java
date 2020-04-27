package day05;

public class OverrideDemo {
	public static void main(String[] args) {
		
	}
}

class Aoo {
	void show() { }
	double test() { return 0.0; }
	Boo say() {return null;};
	Aoo SayHi() {return null;};
}

class Boo extends Aoo {
//	int show() {return 1;} //父类方法返回值类型是 void 子类方法返回值必须相同
//	int test() {return 0;} //父类方法返回值类型是 基本类型时，子类方法返回值必须相同
//	Aoo say() {return null;} //父类方法返回值类型是 基本类型时，子类方法返回值类型与父类方法相同，或者是父类方法返回值类型的子类。
	Boo sayHi() {return null;}; // OK 
}
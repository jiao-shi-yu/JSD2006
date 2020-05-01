package day07.NestedClasses.staticNestedClass;

public class Test {
	public static void main(String[] args) {
		Outter.Inner inner = new Outter.Inner();
	}
}

class Outter {
	public Outter() {
		System.out.println("Outter.Outter()");
	}
	static class Inner {
		public Inner() {
			System.out.println("Outter.Inner.Inner()");
		}
	}
}
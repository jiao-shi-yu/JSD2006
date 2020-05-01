package day07.innerClasses.local;

public class People {
	public People() {
		
	}
}
/* 这个例子有点儿男权哦 */
class Man {
	public Man() {
		
	}
	public People getWoman() {
		class Woman extends People {
			int age = 16;
		}
		return new Woman();
	}
}
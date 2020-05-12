package exception;

public class ExceptionAPIDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "a";
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("程序结束了");
	}
}

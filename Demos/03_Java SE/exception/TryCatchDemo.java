package exception;

public class TryCatchDemo {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = "";
			System.out.println(str.length());
			System.out.println(str.charAt(9));
			System.out.println("一切正常");
		} catch (NullPointerException e) {
			System.out.println("发生了空指针异常");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("字符串索引超出边界异常");
		}
		System.out.println("程序结束");
	}
}

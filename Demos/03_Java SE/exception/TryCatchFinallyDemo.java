package exception;

/**
 * 异常处理格式：
 * 
 * @author yuyu
 *
 */
public class TryCatchFinallyDemo {
	public static void main(String[] args) {
		System.out.println("程序开始");
		String str = "";
		try {
			System.out.println(str.length());
			return;
		} catch (Exception e) {
			System.out.println("出错了");
		} finally {
			System.out.println("finally中的代码块执行了");
		}
		System.out.println("程序结束");
	
	}
}

package string;

public class StartsWithDemo {
	public static void main(String[] args) {
		String str = "www.tedu.cn";
		boolean starts = str.startsWith("www");
		System.out.println("starts="+starts);
		
		boolean ends = str.endsWith(".cn");
		System.out.println("ends="+ends);
	}
}

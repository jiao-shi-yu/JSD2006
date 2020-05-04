package string;

public class Test {
	public static void main(String[] args) {
		String s1 = getHostName("www.baidu.com");
		System.out.println(s1);
		
		String s2 = getHostName("http://www.tedu.cn");
		System.out.println(s2);
		
		String s3 = getHostName("doc.canglaoshi.org");
		System.out.println(s3);
	}

	private static String getHostName(String url) {
		int beginIndex = url.indexOf(".") + 1;
		int endIndex = url.indexOf(".", beginIndex);
		String hostName = url.substring(beginIndex, endIndex);
		return hostName;
	}
}

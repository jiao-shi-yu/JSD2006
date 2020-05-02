package apidoc;
/**
 * 文档注释是功能级注释，用来说明类、方法、常量的作用
 * @author jiao_ ------------作者
 * @version 1.2 -------------版本
 * @see java.lang.String  ---参考
 * @since JDK 1.7 -----------从JDK1.7加入了这个功能
 */
public class DocDemo {
	/**
	 * sayHello() 中的问候语
	 */
	public static final String INFO = "您好";
	/**
	 * 为特定的用户添加问候语
	 * @param name 给定的用户名
	 * @return 带有问候语的字符串
	 */
	public String sayHello(String name) {
		return INFO + name;
	}
}
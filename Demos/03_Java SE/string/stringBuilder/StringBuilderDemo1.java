package string.stringBuilder;
/**
 * StringBuilder 是用来解决字符串修改的性能问题，
 * 并且提供了修改字符创的相关操作方法。
 * @author yuyu
 *
 */
public class StringBuilderDemo1 {
	public static void main(String[] args) {
		String str = "好好学习java";
		// 默认空串
//		StringBuilder builder = new StringBuilder();
		StringBuilder builder = new StringBuilder(str);
		System.out.println(builder);
		
		/**
		 * 增
		 * append()方法：在字符串末尾追加内容
		 * 好好学习java，为了找个好工作!
		 * 
		 */
		
		builder.append("，为了找个好工作!");
		String str1 = builder.toString();
		System.out.println(str1);
		
		/**
		 * 改
		 * replace(start, end, str1);
		 * 替换字符串内容
		 * 好好学习java，为了找个好工作!
		 * 好好学习java，为了改变世界！
		 */
		builder.replace(9, 16, "就是为了改变世界");
		System.out.println(builder);
		System.out.println(builder.getClass().getName());
		System.out.println(builder.toString().getClass().getName())
		;
		
		/**
		 * 删
		 * delete(int start, int end):删除指定范围内的字符串
		 */
		
		builder.delete(0, 9);
		System.out.println(builder);
		
		/**
		 * 插
		 * insert(offset, str1)
		 */
		builder.insert(6, "我们的");
		System.out.println(builder);
		builder.insert(0, "活着");
		System.out.println(builder);
	}
}

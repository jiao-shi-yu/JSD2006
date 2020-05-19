package collection.list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合的工具类 java.util.Collections 提供了一个静态方法 sort()， 可以对 List 集合进行自然排序，即：从小到大。
 * @author yuyu
 *
 */
public class SortListDemo1 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		
		
	}
}

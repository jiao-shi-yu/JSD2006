package map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		System.out.println(map);
		map.put("语文", 100);
		System.out.println(map);
		
		int mathScore = map.get("数学");
		System.out.println("math score: " + mathScore);
		
		Integer peScore = map.get("体育");
		System.out.println("pe score: " + peScore);
		
		boolean containsPE = map.containsKey("体育");
		System.out.println("contains key P.E.: " + containsPE);
		boolean contains100 = map.containsValue(100);
		System.out.println("contains value 100: " + contains100);
	}
}

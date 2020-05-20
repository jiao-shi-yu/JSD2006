package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IterateMapDemo {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("语文", 99);
		map.put("数学", 98);
		map.put("英语", 97);
		map.put("物理", 96);
		map.put("化学", 95);
		
		Set<String> keys = map.keySet();
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		Collection<Integer> values = map.values();
		
		for (String key : keys) {
			System.out.print(key + ",\t");
		}
		System.out.println();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "-->" +  entry.getValue());
		}
		for (Integer value: values) {
			System.out.print(value+",\t");
		}
	}
}

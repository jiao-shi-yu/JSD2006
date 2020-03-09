package cn.tedu.spring;

import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionTest {
	
	public static void main(String[] args) {
		
		// HashSet TreeSet LinkedHashSet
		Set<String> cities = new LinkedHashSet<String>();
		cities.add("Beijing");
		cities.add("Shanghai");
		cities.add("Guangzhou");
		cities.add("Shenzhen");
		cities.add("Nanjing");
		cities.add("Hangzhou");
		cities.add("TianJin");
		cities.add("ChongQing");
		for (String city : cities) {
			System.out.println(city);
		}
	}
}

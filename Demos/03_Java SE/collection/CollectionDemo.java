package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
		System.out.println("size:" + collection.size());
		System.out.println("isEmpty:" + collection.isEmpty());
		collection.add("one");
		System.out.println("collection:" + collection);
		Collection<String> collection2 = new ArrayList<>();
		collection2.add("two");
		collection2.add("three");
		System.out.println("collection2:"+collection2);
		collection.addAll(collection2);
		System.out.println("collection:" + collection);
		
		collection.remove("one");
		System.out.println("collection:"+collection);
		
		collection.removeAll(collection2);
		System.out.println("collection:"+collection);
		
		
		
		collection.add("one");
		collection.add("two");
		collection.add("three");
		
		boolean containsOne = collection.contains("one");
		boolean containsAll = collection.containsAll(collection2);
		System.out.println("collection contains \"one\":" + containsOne);
		System.out.println("collection contains All collection2:" + containsAll);
		
		System.out.println("collection: "+collection);
		System.out.println("collection2: "+collection2);
		
		collection.retainAll(collection2);
		System.out.println("collection: "+collection);
		
		collection.clear();
		System.out.println("collection:" + collection);
	}
}

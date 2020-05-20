package collection.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
	public static void main(String[] args) {
		Deque<String> deque = new LinkedList<>();
		
		deque.offerFirst("one");
		System.out.println(deque);
		deque.offerFirst("two");
		System.out.println(deque);
		deque.offerLast("three");
		System.out.println(deque);
		
		System.out.println("pollFirst: " + deque.pollFirst());
		System.out.println("pollLast: " + deque.pollLast());
	}
}

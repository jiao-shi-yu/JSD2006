package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		queue.offer("five");
		
		System.out.println("queue:" + queue);
		
		String head = queue.poll();
		System.out.println("head:" + head);
		System.out.println("queue after poll:" + queue);
		String newHead = queue.peek();
		System.out.println("newHead:" + newHead);
		System.out.println("queue after peek:" + queue);
		
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}
}
 
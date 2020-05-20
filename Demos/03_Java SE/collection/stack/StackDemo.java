package collection.stack;

import java.util.Deque;
import java.util.LinkedList;

public class StackDemo {
	public static void main(String[] args) {
		Deque<String> stack = new LinkedList<>();
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.push("four");
		stack.push("five");
		System.out.println(stack);
		while(stack.size()>0) {
			System.out.println(stack.pop());
		}
		System.out.println(stack.pollFirst());
		stack.pop();
	}
}

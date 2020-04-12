package Stacks;

import java.util.Stack;

public class StackInCollection {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.add(20);
		System.out.println(stack.pop());
		System.out.println(stack.peek());

	}

}

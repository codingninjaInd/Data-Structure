package StackUsingQueue;

public class StackUsingQueueUse {

	public static void main(String[] args) throws Exception {
		StackUsingQueue<Integer> stack = new StackUsingQueue<>();
		
		stack.push(3);
		stack.push(4);
		stack.push(63);
		stack.push(21);
		stack.push(9);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		stack.push(7);
		System.out.println(stack.top());
		
		

	}

}

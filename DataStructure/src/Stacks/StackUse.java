package Stacks;

public class StackUse {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		
//		StackUsingArray f = new StackUsingArray();
//		
//		f.pop();
//		
		StackUsingLL  stack = new StackUsingLL();
		
		stack.push(30);
		stack.push(20);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		
		
		
	}

}

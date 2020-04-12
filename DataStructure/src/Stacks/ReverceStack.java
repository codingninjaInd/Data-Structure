package Stacks;

import java.util.Stack;

public class ReverceStack {
	
	 private static void reverce(Stack<Integer> s1)
		{
			if(s1.isEmpty())
			{
				return s1;
			}
			
			int temp = s1.pop();
			
			reverce(s1);
			
			s1.push(temp);
			
			return s1;
			
	}

	
	
	
	public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2)
	{
		
		
		
	}

	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		reverseStack(s1,s2);
		
		
		
	

	}

}

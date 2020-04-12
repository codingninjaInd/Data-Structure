package Stacks;

import java.util.Stack;

public class Checkredundantbrackets {
	
	
	public static int countBracketReversals(String input)
	{
		
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		if(input.length() % 2 != 0) // If string length is odd that can not be redundent
		{
			return -1;
		}
		
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)=='{')
			{
				stack.push(input.charAt(i));
			}
			else if(input.charAt(i)=='}')
			{
				if(stack.isEmpty() || stack.peek()=='}')
				{
					stack.push(input.charAt(i));
				}
				else if(!stack.isEmpty() && stack.peek()=='{')
				{
					stack.pop();
				}
				
			}
			
		}
		
		// After comming out of the loop
		
		if(stack.isEmpty())
		{
			return 0;
		}
		else{
			
			char c1,c2;

			while(!stack.isEmpty())
			{
				c1 = stack.pop();
				c2 = stack.pop();
				if(c1 == c2)
				{
					count= count+1;
				}
				else if(c1=='{' && c2 == '}' )
				{
					count = count+2;
				}
				
			}
			
		}
		return count;
	}
	

	public static void main(String[] args) {
		
		String str = new String("}}}{");
		
		System.out.println(countBracketReversals(str));
		

	}

}

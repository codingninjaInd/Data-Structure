package Stacks;

import java.util.Stack;

public class Solution {
	
	
	public static boolean checkBalanced(String exp)
	{
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<exp.length();i++)
		{
			if(exp.charAt(i)=='{' || exp.charAt(i)=='(' || exp.charAt(i)=='[')
			{
				stack.push(exp.charAt(i));
			}
			else if(exp.charAt(i)=='}' || exp.charAt(i)==')' || exp.charAt(i)==']')
			{
				if(stack.isEmpty())
				{
					return false;
				}
				
				char ch = stack.pop();
				
				if(exp.charAt(i)==')' && ch == '(')
				{
					continue;
				}
				else if(exp.charAt(i)=='}' && ch == '{')
				{
					continue;
				}
				else if(exp.charAt(i)==']' && ch == '[')
				{
					continue;
				}
				else
				{
					return false;
				}
				
			}
		}
		if(stack.isEmpty())
		{
			return true;
		}
		else{
			return false;
		}
	}

	public static void main(String[] args) {
		
		String str = new String("{ a + [ b - c } ]");
		
		System.out.println(checkBalanced(str));
		
		

	}

}

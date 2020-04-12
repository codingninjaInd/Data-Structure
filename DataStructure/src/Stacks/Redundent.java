package Stacks;

import java.util.Stack;

public class Redundent {
	
	
	
	public static boolean checkRedundantBrackets(String input)
	{

		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i) != ')' )
			{
				stack.push(input.charAt(i));
			}
            else if(input.charAt(i)==')')
            {
                int count =0;
                while(stack.peek() != '(')
                {
                    stack.pop();
                    count++;
                }
                
                if(count == 0)
                {
                    return true;
        
                }
                
                stack.pop();
                
            }
			
			
		}
		return false;

		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = new String("((a + b))");
		
		checkRedundantBrackets(str);

	}

}

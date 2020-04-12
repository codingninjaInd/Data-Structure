package Stacks;

public class ReverceStac {
	
	 public static void reverseStack(Stack<Integer> s1, Stack<Integer> s2) {
	        if(s1.size()<=1){
	            return;
	        }
	        int last = s1.pop();
	        reverseStack(s1,s2);
	        while(!s1.isEmpty()){
	            int a = s1.pop();
	            s2.push(a);
	        }
	        s2.push(last);
	        
	        while(!s2.isEmpty()){
	            int b = s2.pop();
	            s1.push(b);
	        }
	 }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

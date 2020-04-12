package StackUsingQueue;

import java.util.*;
//import java.util.LinkedList;
//import java.util.Queue;

public class ReverceQueue {
	
	
	public static Queue<Integer> reverseKElements(Queue<Integer> input,int k)
	{
		int size = input.size();
		Stack<Integer> stack = new Stack<>();
		
		for(int i=1;i<=k;i++)
		{
			stack.push(input.poll());
		}
		while(! stack.isEmpty())
		{
			input.add(stack.pop());
		}
		for(int i=1;i<=size-k;i++)
		{
			int temp = input.poll();
			input.add(temp);
		}
		
		return input;
		
	}
	
	public static void reverseQueue(Queue<Integer> q)
	{
		if(q.isEmpty())
		{
			return;
		}
		
	int temp = q.poll();
	
	reverseQueue(q);
	
	q.add(temp);
	System.out.println(q.poll());
	
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		
		q = reverseKElements(q,3);
		while(! q.isEmpty())
		{
			System.out.println(q.poll());
		}
		
		
		

	}

}

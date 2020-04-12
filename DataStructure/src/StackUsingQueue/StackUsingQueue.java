

package StackUsingQueue;

import java.util.Queue;
import java.util.LinkedList;



public class StackUsingQueue<T> {
	
	private Queue<T> q1;
	private Queue<T> q2;
	private int size;
	
	
	//Now we will make a constractor
	
	StackUsingQueue()
	{
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}
	
	//Now we will make a function for push()
	
	public void push(T element)
	{
		size++;
		q1.add(element);
		
		
	}
	
	//Now we will make a function for pull
	
	public T pop() throws Exception
	{
		if(q1.isEmpty())
		{
			throw new Exception();
		}
		for(int i =0 ;i<size-1;i++)
		{
			q2.add(q1.poll());
		}
		
		T temp = q1.poll();
		
		while(! q2.isEmpty())
		{
			q1.add(q2.poll());
		}
		size--;
		return temp;
	}
	
	public int size()
	{
		return size;
	}
	
	public T top() throws Exception
	{
		if(q1.isEmpty())
		{
			throw new Exception();
		}
		for(int i =0 ;i<size-1;i++)
		{
			q2.add(q1.poll());
		}
		
		T temp = q1.peek();
		q2.add(q1.poll());
		
		while(! q2.isEmpty())
		{
			q1.add(q2.poll());
		}
		return temp;
		
	}
	 public boolean isEmpty()
	 {
		 return size==0;
	 }
	
	

}

package Queue;

import java.util.Stack;

public class QueueUsingStack<T> {
	
	Stack<T> s1;
	Stack<T> s2;
	int size;
	
	//Now we will make a constractor 
	
	QueueUsingStack()
	{
		s1 = new Stack<>();
		s2 = new Stack<>();
		 size =0;
	}
	
	
	public void enqueue(T element)
	{
		size++;
	
		s1.push(element);
	}
	
	// Now we will thick about the dequeue operation it should follow the FIFO rule for that we will use our second stack

	
	public T dequeue() throws QueueIsEmptyException
	{
		while(! s1.isEmpty())
		{
			s2.push(s1.pop());
		}
		 T temp = s2.pop();
		 
		while(! s2.isEmpty())
		{
			s1.push(s2.pop());
		}
		size--;
		return temp;
	
	}
	
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
}

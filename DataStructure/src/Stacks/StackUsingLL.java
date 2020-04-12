package Stacks;

import linkedLIst.Node;



public class StackUsingLL<T> {
	
	Node<T> head;
	int size = 0;
	
	public StackUsingLL()
	{
		
	}
	
	public void  push(int element)
	{
		Node<T> current = new Node(element);
		
		current.next = head;
		head = current;
		size++;
		
	
	}
	
	public T top() throws Exception
	{
		if(head == null)
		{
			throw new Exception();
		}
		return head.data;
	}
	
	
	
	public T pop() throws Exception
	{
	{  if(head==null)
		throw new Exception()	;
	}
	T data = head.data ;
	head=head.next;
	size--;
	return data;
	}
	
	
}
	

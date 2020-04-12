package Queue;

import linkedLIst.Node;



public class QueueUsingLinkList<T> {
	
    Node<T> front;
	Node<T> rear;
	int size;
	
	 public QueueUsingLinkList()
	 {
		 front = null;
		 rear = null;
		 size =0;

	 }
	 
	 public int size()
	 {
		 return size;
	 }
	 
	 public void enqueue(T element)
	 {
		 Node<T> node = new Node<>(element);
		 size++;
		 
		 if(rear == null)
		 {
			 front = node;
			 rear =node;
		 }
		 else
		 {
		 rear.next = node;
		 rear = node;
		 }
		
	 }
	 
	 public T front() throws QueueIsEmptyException
	 {
		 if(front == null)
		 {
			 throw new QueueIsEmptyException();
		 }
		 return front.data;
	 }
	 
	 public boolean isEmpty()
	 {
		 return size==0;
	 }
	 
	 public T dequeue() throws QueueIsEmptyException
	 {
		 if(front == null)
		 {
			 throw new QueueIsEmptyException();
		 }
		 
		
		 T temp = front.data;
		 front = front.next;
		 
		 if(front==null)
		 {
			 rear = null;
		 }
		 size--;
		 return temp;
	 }
	 
	
	

}

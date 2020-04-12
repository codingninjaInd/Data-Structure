package Queue;

public class QueueUsingArray {
	
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray()
	{
		data = new int[5];
		front = -1;
		rear = -1;
			
	}
	
	//If you want to give the capacity of Queue the use this arhument constarctor
	
	public QueueUsingArray(int capacity)
	{
		data = new int[capacity];
		front = -1;
		rear = -1;
		
		
	}
	
	public int size()  //for finding the size of queue
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	//Now we will make a function to insert the element in queue that is enqueue
	
	public void enqueue(int element)
	{
		if(size == data.length)
		{
			doublecapacity();
			//throw new QueueIsFullException();
		}
		if(size==0)
		{
			front=0;
		}
		rear++;
		if(rear==data.length) //For making the cercular insertion fine way of writing this is rear = rear+1%data.length;
		{
			rear = 0;
		}
		
		data[rear] = element;
		size++;
		
		
	}
	
	private void doublecapacity() {
		
		int temp[] = data;
		data = new int[2*temp.length];
		int index = 0;
		for(int i=front;i<temp.length;i++)
		{
			data[index++] = temp[i];
		}
		for(int i=0;i<front;i++)
		{
			data[index++] = temp[i];
		}
		front =0;
		rear = temp.length-1;
	
		
	}

	public int dequeue() throws QueueIsEmptyException
	{
		if(size==0)
		{
			throw new QueueIsEmptyException();
		}
	
		int temp = data[front];
		front++;
		if(front== data.length)//for making cercular;
		{
			front=0;
		}
		size--;
		if(size==0)
		{
			front=-1;
			rear = -1;
		}
		return temp;
	}
	
	public int front() throws QueueIsEmptyException
	{
		if(size==0)
		{
			throw new  QueueIsEmptyException();
		}
		return data[front];
		
	}

}

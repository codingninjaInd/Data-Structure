package Queue;

public class QueueUsingStackUse {

	

	public static void main(String[] args) throws QueueIsEmptyException {
		
		QueueUsingStack<Integer> queue = new QueueUsingStack<>();
		
		int arr[] = {10,20,30,40};
		for(int item:arr)
		{
			queue.enqueue(item);
			
		}
		
	while(! queue.isEmpty())
	{
			
		
		System.out.println(queue.dequeue());
	}
	

	}

}

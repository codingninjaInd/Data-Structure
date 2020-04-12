package Queue;

public class QueueArrayUse {

	public static void main(String[] args) {
		QueueUsingLinkList<Integer> queue = new QueueUsingLinkList<>();
		
		int arr[] = {10,20,30,40,50,60,70,80,90};
		for(int ele:arr)
		{
			
				queue.enqueue(ele);
			
		}		
		
		while( ! queue.isEmpty())
		{
			try {
				System.out.println(queue.dequeue());
			} catch (QueueIsEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

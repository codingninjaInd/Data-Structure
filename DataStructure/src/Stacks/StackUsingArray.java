package Stacks;

public class StackUsingArray {
	
	private int data[];
	
	private int topIndex=-1;

	
	
	
	
	StackUsingArray()
	{
		data = new int[2];
	}
	
	private void size()  //for increcing the size of array data
	{
		int temp[] = data;
		
		data = new int[2*temp.length];
		for(int i=0;i<temp.length;i++)
		{
			data[i] = temp[i];
		}
		}
	
	
	
	public void push(int element)   //for putting the element in data type array
	{
		if(topIndex == data.length-1)
		{
			size();
		}
		topIndex++;
		data[topIndex] = element;
		
	}
	
	public void pop() throws stackIsEmpty  //pop function for stack
	{
		if(topIndex == -1)
		{
			
			throw new stackIsEmpty();
		}
		topIndex--;
	}
	
	public void  top()  ///
	{
		System.out.println(data[topIndex]);
	}

}

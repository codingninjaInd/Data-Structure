package linkedLIst;

import java.util.Scanner;

public class Revision1 {
	
	//Fuction for ptinting the element of link list
	public static void print(Node<Integer> head)
	{
		if(head == null)
		{
			return;
		}
		System.out.print(head.data+" ");
		
		print(head.next);	
	}
	
	//Now we will make a funcrtion for taking the element in link list
	
	public static Node<Integer> takeIP()
	{
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;
		
		while(data != -1)
		{
			Node<Integer> current = new Node(data);
			
			if(head == null)
			{
				head = current;
				tail = current;
			}
			tail.next =current;
			tail = tail.next;
			
			data = sc.nextInt();
		}
		
		return head;
	}
	
	/////////Now we will make a function to find length of linkedlist
	
	public static int length(Node<Integer> head)
	{
		int count = 0;
		while(head != null)
		{
			count++;
			head = head.next;
		}
		return count;
		
		
	}
	
	////Now we will make a function to insert node in i thhn position
	
public static Node<Integer> insert(Node<Integer> head,int pos,int data)
{
	Node<Integer> temp = head;
	Node<Integer> prev = null;
	Node<Integer> c = null;
	
	Node<Integer> current = new Node(data);
	int j=0;
	if(pos==0)
	{
		current.next = head;
		head = current;
	}
	else
	{
		while(j != pos && temp!= null)
		{
			prev = temp;
			temp = temp.next;
			j++;
			
		}
		
		if(temp == null)
		{
			return head;
		}
		else
		{
			prev.next =current;
			current.next = temp;
		}
		
		
	}
	return head;
		
	
	
}

public static Node<Integer> delete(Node<Integer> head,int i)
{
	int j = 0;
	Node<Integer> temp = head;
	Node<Integer> pre = null;
	if(i==0)
	{
		head = head.next;
		return head;
	}
	else
	{
		while(j != i && temp != null)
		{
			j++;
			pre = temp;
			temp = temp.next;
			
		}
		if(temp != null)
		pre.next = temp.next;
	}
	return head;
}


//////////////////////////////////Now we will make a function for remove duplicate from LL

public static Node<Integer> removeDuplicates(Node<Integer> head)
{
	Node<Integer> temp1 = head;
	Node<Integer> temp2 = head.next;
	while(temp2 != null)
	{
		if(temp1.data != temp2.data)
		{
			temp1.next = temp2;
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		else
		{
			temp2 = temp2.next;
		}
	}
	return head;
	
	
}

//////Now we will make a function to reverce the link list

public static Node<Integer> reverce(Node<Integer> head)
{
	if(head.next == null)
	{
		return head;
	}
	
	Node<Integer> smallA = reverce(head.next);
	Node<Integer> tail = head.next;
	tail.next = head;
	head.next=null;
	return smallA;
	
 }

///////Now we will make a function forcheckPali

public static boolean palin(Node<Integer> head)
{
	Node<Integer> temp1 = head;
	Node<Integer> temp2 = reverce(head);
	while(temp1 != null)
	{
		if(temp1.data != temp2.data)
			return false;
		
		temp1 = temp1.next;
		temp2 = temp2.next;
	}
	return true;
}

public static void printMid(Node<Integer> head)
{
	Node<Integer> slow = head;
	Node<Integer> fast = head;
	while(fast.next != null && fast.next.next != null)
	{
		slow = slow.next;
		fast = fast.next.next;
	}
	System.out.println(slow.data);
}


//Now we willn make a function for even odd

public static Node<Integer> oddEven(Node<Integer> head)
{
	Node<Integer> temp1 = head;
	Node<Integer> oddHead=null;
	Node<Integer> oddtail = null;
	Node<Integer> evenHead=null;
	Node<Integer> eventail = null;
	
	//Now we will sperate a link list of Odd element
	while(temp1 != null)
	{
		Node<Integer> current = new Node<>(temp1.data);
		if(temp1.data % 2 != 0)
		{
			
			if(oddHead==null)
			{
				oddHead = current;
				oddtail = current;
			}
			else
			{
				oddtail.next =current;
				oddtail = oddtail.next;
			}
		}
		else{  //for dealing to even case
			if(evenHead == null)
			{
				evenHead = current;
				eventail = current;
			}
			else
			{
				eventail.next = current;
				eventail = eventail.next;
			}
			
		}
		temp1 = temp1.next;
		
	}
	oddtail.next = evenHead;
	return oddHead;
}

public static Node<Integer> addR(Node<Integer> head,int data,int pos)
{
	if(head == null)
		return head;
	if(pos == 0)
	{
	Node<Integer> current = new Node<>(data);
	 current.next = head;
	 return current;
	}
	head.next = addR(head.next,10,pos-1);
	
	return head;
}


public static Node<Integer> bubbleSort(Node<Integer> head)
{
	Node<Integer> c1 = null;
	Node<Integer> c2 = null;
	Node<Integer> pre = null;
	
	for(int i=0;i<length(head)-1;i++)
	{
		c1 = head;
		c2 =head.next;
		pre = null;
		while(c2 != null)
		{
			if(c1.data > c2.data)
			{
				if(pre == null)
				{
					Node<Integer> t = c2.next;
					c2.next = c1;
					c1.next = t;
					
					
					pre = c2;
					head = pre;
					c2 = c1.next;
				}
				else{
					Node<Integer> t = c2.next;
					pre.next = c2;
					c2.next =c1;
					c1.next = t;
					
					pre = c2;
					c2 = c1.next;
				
				}
			}
			else
			{
				pre = c1;
				c1 = c2;
				c2 = c2.next;
			}
		}
			
	}
	return head;
	
	
	
}

public static Node<Integer> nextLargeNumber(Node<Integer> head)
{
	Node<Integer> temp = head;
	int l= length(head);
	int c = 0;
	for(int i = 0;i<l;i++)
	{
		temp = head;
		for(int j=0;j<l-1-i;j++)
		{
			temp = temp.next;
		}
		if(i==0)
		{
			temp.data = temp.data+1;
			int t = temp.data;
			 t = t/10;
			temp.data = temp.data%10;
			c = t;
		}

		else{
			temp.data = temp.data+c;
			int t = temp.data;
			 t = t/10;
			temp.data = temp.data%10;
			c = t;
			}
	}
	
	if(c != 0)
	{
		Node<Integer> current = new Node<>(c);
		current.next = head;
		head = current;
	}
	return head;
	
}

	public static void main(String[] args) {
		
		Node<Integer> head = takeIP();
		print(head);
		//System.out.println(length(head));
		System.out.println();
		//print(insert(head,3,100));
		//print(delete(head,7));
		// print(removeDuplicates(head));
		//print( reverce(head));
		//System.out.println(palin(head));
		
		//printMid(head);
		
		//print(oddEven(head));
		
		//print(addR(head,10,7));
		//print(bubbleSort(head));
		
		print(nextLargeNumber(head));
		
		
		
		

	}

}

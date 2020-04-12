package linkedLIst;

import java.util.Scanner;
import java.util.LinkedList;

class DoubleNode{  // this is a for using reverce recursivly better

	Node<Integer> head;
	Node<Integer> tail;
	
	DoubleNode()
	{
		
	}
	
	DoubleNode(Node<Integer> head,Node<Integer> tail)
	{
		this.head = head;
		this.tail = tail;
	}
	
	
}

public class Use2 {
	
	public static Node<Integer> take()
	{
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		if(data==-1)
		{
			return null;
		}
		
		Node<Integer> head = new Node<>(data);
		
		Node<Integer>  tail= take();
		
		head.next = tail;
		
		return head;
		
	}
	
	
	public static Node<Integer> takeInput()
	{
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail =null;
		int n =0;
		while(data != -1)
		{
			n++;
			Node<Integer> current = new Node(data);
			if(n==1)
			{
				tail = current;
				head = current;
			}
			else
			{
				tail.next = current;
				tail = tail.next;
			}
			data = sc.nextInt();
		}
		return head;
	}
	
	public static void print(Node<Integer> head)
	 {
		 while(head != null)
		 {
			 System.out.print(head.data+" ");
			 head = head.next;
		 }
	 }
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////
	// In this finction we will print linklist recursivly
	
	public static void printRecursive(Node<Integer> head)
	{
		if(head == null)
		{
			return;
		}
		
		System.out.print(head.data+" ");
		printRecursive(head.next);
	}
	
	///////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	//Now we will make function for insert node recusivly
	
	public static Node<Integer> insertR(Node<Integer> head , int element, int pos)
	{
		if(pos == 0)
		{
			Node<Integer> current = new Node(element);
			current.next = head;
			return current;
		}
		else
		{
			
			head.next = insertR(head.next,element,pos-1);
			return head;
		}
	}
	
	// Now we will make function to delete the node recursivly
	
	public static Node<Integer> deleteIthNodeRec(Node<Integer> head, int i)
	{
		if(head.next == null && i != 0)
		{
			return head;
		}
		
		if(i==0)
		{
			return head.next;
		}
		

		if(i == 1)
		{
			head.next = head.next.next;
			
			return head;
		}
		
		
		else
		{
			
			
			  deleteIthNodeRec(head.next,i-1);
			  
			
		}
		
		return head;
		
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////
	///Now we weill make function for reverce linked list recurcivly 
	/////////////////////////////////////////////////////////////////////////////
	
	public static Node<Integer> reverse_R(Node<Integer> head)
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		
		Node<Integer> smallhead = reverse_R(head.next);
		
		Node<Integer> tail = smallhead;
		
		
		while(tail.next != null)
		{
			tail = tail.next;	
		}
		tail.next = head;
		head.next = null;
		return smallhead;
		
	}
	
	
	/*
	  Now we will make a function to make link list reverce 
	//////////////////////////////////////////////*/
	
public static DoubleNode reverseBetter(Node<Integer> head)
{
	DoubleNode ans;
	if( head == null || head.next == null)
	{
		ans = new DoubleNode();
		ans.head = head;
		ans.tail = head;
		return ans;
		
	}
	
	DoubleNode smallAns = reverseBetter(head.next);
	smallAns.tail.next = head;
	head.next = null;
	ans = new DoubleNode();
	ans.head = smallAns.head;
	ans.tail = head;
	return ans;
	
		
}


/////////////////////////////////////////////////////////////////////////////////
            //Now we will make function to reverce link list better choice
/////////////////////////////////////////////////////////////////////////////////////

public static Node<Integer> reverseBest(Node<Integer> head)
{
	if(head == null || head.next == null)
	{
		return head;
	}
	
 Node<Integer> smallHead = reverseBest(head.next);
 Node<Integer> tail = head.next;
 
 tail.next = head;
	head.next = null;
	return smallHead;
 
 
		
}

////////////////////////////////////////////////////////////////////////////////////////
                   // Now we will make function to calculate mid point of link list
// And you can not calculate length of list;
////////////////////////////////////////////////////////////////////////////////////////
	
public static int printMiddel(Node<Integer> head)
{
	Node<Integer> slow  = head;
	Node<Integer> fast =head;
	while(fast.next != null && fast.next.next != null)
	{
		fast = fast.next.next;
		slow = slow.next;
	}
	return slow.data;
	
}

//////////////////////////////////////////////////////////////////////////////////
// Now we will make function to merge two shorted linked list

//////////////////////////////////////////////////////////////////////////////////////

public static Node<Integer> mergeTwoList(Node<Integer> head1, Node<Integer> head2)
{
	Node<Integer> t1 = head1;
	Node<Integer> t2 = head2;
	Node<Integer> head = null;
	Node<Integer> tail = null;
	if(t1.data <= t2.data)
	{
		head = t1;
		tail = t1;
		t1 = t1.next;
	}
	else
	{
		head = t2;
		tail = t2;
		t2 = t2.next;
	}
	
	while( t1 != null && t2 != null)
	{
		if(t1.data <= t2.data)
		{
			tail.next = t1;
			tail = t1;
			t1 = t1.next;
		}
		else
		{
			tail.next = t2;
			tail = t2;
			t2 = t2.next;
			
		}
	}
	// one list is end
	if(t1 != null)
	{
		tail.next = t1;
	}
	else
	{
		tail.next = t2;
	}
		
	
	return head;
}

//////////////////////////////////////////////////////////////////////////////////
  //Now we will make a function to find n element in link list
/////////////////////////////////////////////////////////////////////////////////

public static int indexOfNRec(Node<Integer> head, int n)
{
	return find(head,n,0);
}


	private static int find(Node<Integer> head, int n, int i) {
		if(head == null)
		{
			return -1;
		}
		
		if(head.data == n)
		{
			return i;
		}
		
		
		
	int j =	find(head.next,n,i+1);
	return j;		
	
}
	
////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
	
	public static Node<Integer> oddEven(Node<Integer> head)
	{
		Node<Integer> evenHead = null;
		Node<Integer> eventail = null;
		Node<Integer> oddHead = null;
		Node<Integer> oddtail = null;
		Node<Integer> t1 = head;
	    Node<Integer> t2= head;
		
		//Now we will sprate odd 
		
		
		while(t1 != null)
		{
			if(t1.data % 2 != 0)
			{
				if(oddHead==null)
				{
					oddHead = new Node<>(t1.data);
					oddtail = oddHead;
				}
				else
				{
					oddtail.next = new Node<>(t1.data);
					oddtail = oddtail.next;
				}
			}
			t1 = t1.next;
		}
		
		while(t2 != null)
		{
			if(t2.data % 2 == 0)
			{
				if(evenHead==null)
				{
					evenHead = new Node<>(t2.data);;
					eventail = evenHead;
				}
				else
				{
					eventail.next = new Node<>(t2.data);;
					eventail = eventail.next;
				}
			}
			t2 = t2.next;
		}
        if(oddHead == null){
            return evenHead;
        }
        if(eventail!=null)
            eventail.next = null;
        if(oddtail != null)
            oddtail.next = null;
		oddtail.next = evenHead;
		return oddHead;		
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	/////////////////////////////////////////////////////////////////////////////////
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N)
	{
		Node<Integer> temp1 = head;
		Node<Integer> temp2 = head;
		int c1 = 1;
		int c2 = 1;
		while(temp1 != null && temp2 != null)
		{
			if(c1 == M  )
			{ 
				temp2 = temp1;
				while(c2 <= N && temp2 != null)
				{
					
					temp2 = temp2.next;
					c2++;
				}
				
				
				c2 = 1;
				c1 = 1;
				if( temp1.next != null && temp2.next != null)
				{
					temp1.next = temp2.next;
					temp1 = temp1.next;
					
					}
				else
				{
					return head;
				}
				}
			
			
			temp1 = temp1.next;
			
			c1++;
			
			}
		return head;
		
		
		}
	public static Node<Integer> swap(Node<Integer> head ,int i ,int j)
	{
		Node<Integer> p1 = null;
		Node<Integer> c1 = null;
		Node<Integer> p2 = null;
		Node<Integer> c2 = null;
		Node<Integer> prv = null;
		Node<Integer> temp = head;
		int k = 0;
		while(temp != null)
		{
			if(k == i)
			{
				p1 = prv;
				c1 = temp;
			}
			else if(k == j)
			{
				p2 = prv;
				c2 = temp;
				
			}
			
			prv = temp;
			temp = temp.next;
			k++;
		}
		
		if(p1 != null)  //Ddeling for when i =0;
		{
			p1.next = c2;
			
		}
		else
		{
			head = c2;
		}
		
		if(p2 != null)
		{
			p2.next = c1;
		}
		else
		{
			head = c1;
		}
		Node<Integer> temp1 = c2.next;
		c2.next = c1.next;
		c1.next = temp1;
		return head;
		}
	
	/////////////////Now this function we will use in Bubbele sort
	
	 public static int length(Node<Integer> head)
	 {
		 Node<Integer> temp = head;
		 int count =0;
		 while(temp != null)
		 {
			 
			count++;
			temp = temp.next;
		 }
		 return count;
	 }
	 
	 public static Node<Integer> bubbleSort(Node<Integer> head)
	 {
		 Node<Integer> prev = null;
		 Node<Integer> c = null;
		 Node<Integer> temp = head;
		 Node<Integer> c2 = null;  // we will use for next of c2;
		 
			 for(int j=0; j<length(head);j++)
			 {
				 prev =null;
				 temp = head;
				 c = head;
				 c2 = c.next;
						 
				 while(c2 != null)
				 {
					 if(c.data > c2.data)
					 {
						 if(prev == null)
						 {
							 c.next = c2.next;
							 c2.next = c;
							 
							 prev = c2;
							 head = prev;
							 c2 = c.next;
							 
						 }
						 else{
						 
						 prev.next =c2;
						 c.next = c2.next;
						 c2.next = c;
						 
						 
						 prev = prev.next;
						 c2 = c.next;
						 }
					 }
					 else
					 {
						 prev = temp;
						 temp = temp.next;
						 c = temp;
						 c2 = temp.next;
					 }
				 }
			 }
			 return head;
		 
		 
	 }
	 
	 
	 
	 
	 ////////////////////////////////////////////////////////////////////////////////////
	    //Now we will make a function for k rerverce
	 ////////////////////////////////////////////////////////////////////////////////////////
	public static  Node<Integer> reverse(Node<Integer> head, int k) 
	    { 
	       Node<Integer> current = head; 
	       Node<Integer> next = null; 
	       Node<Integer> prev = null; 
	         
	       int count = 0; 
	  
	       
	       while (count < k && current != null)  
	       { 
	           next = current.next; 
	           current.next = prev; 
	           prev = current; 
	           current = next; 
	           count++; 
	       } 
	  
	      
	       if (next != null)  
	          head.next = reverse(next, k); 
	  
	       
	       return prev; 
	    }  
	
	public static Node<Integer> rever(Node<Integer> head)
	{
		Node<Integer> temp = head;
		int j=0;
		
		
		while(temp != null)
		{
			if(j==0)
			{
				Node<Integer> p1 = temp;
				Node<Integer> pre = null;
				while(temp.data % 2 ==0)
				{
					pre = temp;
					temp = temp.next;
				}
				pre.next = null;
				head = reverseBest(p1);
				Node<Integer> tem = head;
				while(tem.next != null)
				{
					tem = tem.next;
				}
				tem.next = temp;
				}
			else
			{
			if(temp.data%2==0)
			{
				Node<Integer> p1 = temp;
				Node<Integer> pre = null;
				while(temp.data % 2 ==0)
				{
					pre = temp;
					temp = temp.next;
				}
				Node<Integer> p2 = head;
				while(p2.next != p1)
				{
					p2 = p2.next;
				}
				p2.next = null;
				pre.next = null;
				//Now p1 is a head of even String;
			Node<Integer> h1 = reverseBest(p1);	//this will contain the head of reverce ll
			Node<Integer> tem = h1;
			while(tem.next != null)
			{
				tem = tem.next;
			}
			tem.next = temp;
			p2.next = h1;
			
			
			}
			}
			j++;
			temp = temp.next;
		}
		return head;
		
	}
	
	
	public static Node<Integer> addNumbers(Node<Integer> head1,Node<Integer> head2)
	{
		if(head1==null)
		{
			
			return head2;
			
		}
		
		if(head2==null)
		{
			return head1;
		}
		
		Node<Integer> temp1 = reverseBest(head1);
		
		Node<Integer> temp2 = reverseBest(head2);
		int sum,c=0;
		Node<Integer> head = null;
		Node<Integer> pre = null;
		
		while(temp1 != null && temp2 != null)
		{
			sum = temp1.data+temp2.data+c;
			int data=sum%10;
			c = sum/10;
			Node<Integer> temp = new Node<>(data);
			
			if(head==null)
			{
				head = temp;
				pre = temp;
			}
			else{
				pre.next= temp;
				pre= temp;
				
			}
			
			
			temp1 = temp1.next;
			temp2 = temp2.next;
	}
		if(temp1 == null && temp2 !=null)
		{
			while(temp2 != null)
			{
				sum = temp2.data+c;
				int data=sum%10;
				c = sum/10;
				Node<Integer> temp = new Node<>(data);
			       
				   pre.next= temp;
					pre= temp;
				   temp2 = temp2.next;
				
			}
		}
		
		if(temp2 == null && temp1 !=null)
		{
			while(temp1 != null)
			{
				sum = temp1.data+c;
				int data=sum%10;
				c = sum/10;
				Node<Integer> temp = new Node<>(data);
			       
				   pre.next= temp;
					pre= temp;
				   temp1 = temp1.next;
				
			}
		}
		
		if(c!=0)
		{
			Node<Integer> temp = new Node<>(c);
		       
			   pre.next= temp;
				pre= temp;
			
		}
		
		
		
		
		
		
		
		
		
		head = reverseBest(head);
		return head;
		
		
	}

	
	


	public static void main(String[] args) {
		
		Node<Integer> head = take();
		
	// Now we will call print recursive function
		//insertR(head,20,2);
		//
		// we will call the function for delete the node
		//System.out.println();
		
		
		//printRecursive(deleteIthNodeRec(head,6));
		
		/*DoubleNode ans = reverseBetter(head);
		print(ans.head);*/
		
		//print(reverseBest(head));
		//System.out.println(printMiddel(head));
		
		// now we will call for function for merge sort
		
		//Node<Integer> head1 = takeInput();
		
		
		
		//print(mergeTwoList(head,head1));
		//print(head);
		//print(head1);
		//System.out.println(indexOfNRec(head,5));
		//print(head);
		//System.out.println();
		
//		print(oddEven(head));
		
		//print(skipMdeleteN(head,2,2));
		////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////
		//print(swap(head,0,3));
		
		///////////////////////////////////////////////////////////////////////////
		
		////////////////////////////////////////////////////////////////////////////
		
		//print(bubbleSort(head));
		
		/////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		//print( reverse(head,3));
		//print(head);
		//System.out.println();
		Node<Integer> head1 = take();
		
		System.out.println();
		print(head);
		
		System.out.println();
		print(head1);
		
		System.out.println();
		print(addNumbers(head,head1));
		
		
 		

	}

}

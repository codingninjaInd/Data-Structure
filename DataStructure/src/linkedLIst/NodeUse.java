package linkedLIst;

import java.util.Scanner;

public class NodeUse {
	
	//Now we will make a lincked list
	 public static Node<Integer> createLinkedList()
	 {
		 Node<Integer> n1 = new Node(10);
		 Node<Integer> n2 = new Node(20);
		 Node<Integer> n3 = new Node(30);
		 Node<Integer> n4 = new Node(40);
		 
		 n1.next = n2;
		 n2.next = n3;
		 n3.next =n4;
		 return n1;
	 }
	 
	 //Now we will make a function for printing Linked list
	 
	 public static void print(Node<Integer> head)
	 {
		 while(head != null)
		 {
			 System.out.print(head.data+" ");
			 head = head.next;
		 }
	 }
	 
	 // Now we will make a function for printing ith node
	 
	 public static void printIth(Node<Integer> head, int i)
	 {
		 int j =0;
		 Node<Integer> temp = head;
		 while(j<i && temp != null)
		 {
			 temp = temp.next;
			 j++;
		 }
		 if(temp != null)
		 System.out.println(temp.data);
		 
	 }
		 // this is a function for finding the length of node;	 

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
	 
	 //////////////////////////////////////////////////////////////////////////////////////////////
	 //////////////////////////////////////////////////////////////////////////////////////
	 //now we will make function for taking input;
	 
	 public static Node<Integer> takeInput()
	 {
		 Scanner sc = new Scanner(System.in);
		 int data = sc.nextInt();
		 
		 Node<Integer> head = null;
		 
		 while( data != -1)
		 {
			 Node<Integer> currentnode = new Node(data);
			 
			 if(head == null)
			 {
				 head = currentnode;
				 
			 }
			 else
			 {
				 Node<Integer> tail = head;
				 
				while( tail.next != null)
				{
					tail = tail.next;
				}
				// now tail will refer to last node;
				
				tail.next = currentnode;
			 }
			 data = sc.nextInt();
		 }
		 return head;
	 }
	 
	 
	 ////////////////////////////////////////////////////////
	 ///////////////////////////////////////////////////////
	 //now we will make same takeInput function 
	 //with complexity o(n);
	 
	 public static Node<Integer> takeInpu()
	 {
		 Scanner sc = new Scanner(System.in);
		 int data = sc.nextInt();
		 
		 Node<Integer> head = null, tail = null;
		 
		 while( data != -1)
		 {
			 Node<Integer> currentnode = new Node(data);
			 
			 if(head == null)
			 {
				 head = currentnode;
				 tail = head;
				 
			 }
			 else
			 {
				 
				 tail.next =currentnode;
				 tail = currentnode;  //this is very important task in this 
			 data = sc.nextInt();
		 }
		 }
		 return head;
		 
	 }
	 
	 
	 
	 /////////////////////////////////////////////////////////
	 /////////////////////////////////////////////////////////////
	 
	 public static Node<Integer> insert(Node<Integer> head, int data, int pos)
	 {
		
		 
		 
		 int i=0;
		 Node<Integer> current = new Node(data);
		 Node<Integer> temp = head;
		 
		 if(pos ==0)
		 {
			 current.next = head;
			 head = current;
			 return head;
		 }
		 else
		 {
		 while(i<pos-1)
		 {
			 i++;
			 temp = temp.next;
		 }
		 Node<Integer> tail = temp.next;
		 current.next = tail;
		 temp.next = current;
		 return head;
		 }
		 
	 }
	 
	 //////////////////////////////////////////////////////////////////
	 //////////////////////////////////////////////////////////////////////
	 //Now we will make fn for deletev the node
	 
	 public static Node<Integer> deleteIthNode(Node<Integer> head, int i)
	 {
		 int j=0;
		 Node<Integer> temp = head;
		 
		 if(i==0)
		 {
			 head = head.next;
			 return head;
		 }
		 while(j<i-1)
		 {
			 j++;
			 temp = temp.next;

		 }
		 if(temp.next != null)
		 {
		 Node<Integer> target = temp.next.next;
		 temp.next = target;
		 return head;
		 }
		 return head;
	 }
	 
	 ///////////////////////////////////////////////////////////////////
	 //////////////////////////////////////////////////////////////////
	 //Find a node in LL
	 
	 public static int indexOfNIter(Node<Integer> head, int n)
	 {
		 int count =0;
		 Node<Integer> temp = head;
		 while(temp != null)
		 {
			 if(temp.data == n)
			 {
				 return count;
			 }
			 else
			 {
				 temp = temp.next;
				 count++;
			 }
		 }
		 return -1;
	 }
	 
	 
	 
	 public static Node<Integer>  append(Node<Integer> root, int n)
	 {
		 Node<Integer> temp = root;
		 int j=1;
		 while(temp.next != null)
		 {
			 j++;
			 temp = temp.next;
		 }
		  int l=1;
		  Node<Integer> temp1 = root;
		  while(l< n-1)
		  {
			  temp1= temp1.next;
			  l++;
		  }
		  Node<Integer> head = temp1.next;
		  temp1.next = null;
		  Node<Integer> temp3 = head;
		  int i = 0;
		  while(i<j-n)
		  {
			  temp3 = temp3.next;
			  i++;
		  }
		  temp3.next = root;
		  return  head;
				 
		   }
	 
	 /////////////////////////////////////////////////////////////////////////
	 ////////////////////////////////////////////////////////////////////////////
	 public static Node<Integer> removeDuplicates(Node<Integer> head)
	 {
		 Node<Integer> temp1=head;
		 Node<Integer> temp2 = head.next;
	
		
		 while(temp2 != null)
		 {
			 if(temp1.data.equals(temp2.data))
			 {
				 temp2 = temp2.next;
			 }
			 else
			 {
				 temp1.next = temp2;
				 temp1 = temp2;
				 temp2 = temp2.next;
			 }
			
		 }
			return head; 

	 }
		 
	 
	 /////////////////////////////////////////////////////////////////////
	 ///////////////////////////////////////////////////////////////////////
	 // we will solve this plroblem by recursion
	 
//	 static void printReverse(Node<Integer> root)
//	 {
//		 printReverse(root = root.next)
//	 }
			 
			 
	
	 
	 public static void printReverseRecursive(Node<Integer> root)
	 {

			if(root== null)
			{
			
				return;
			}
			
			
			 
			 printReverseRecursive(root = root.next);
			 
			 System.out.print(root.data+" ");
		 
		 
	 }
	 
	 
	 ////////////////////////////////////////////////
	 //////////////////////////////////////////////////////////////////
	 public static boolean isPalindrome(Node<Integer> head)
	 {
		 Node<Integer> temp1 = head;
		 Node<Integer> temp2 = head;
		 int j=1;
		 
		 while(temp1.next != null)
		 {
			 j++;
			 temp1 = temp1.next;
		 }
		 for(int i=1;i<=j-i;i++)
		 {
			 Node<Integer> temp3 = head;
			 int k=1;
			 while(k<=j-i)
			 {
				 temp3 = temp3.next;
				 k++;
			 }
			 if(temp2.data != temp3.data)
			 {
				 return false;
			 }
			 temp2 =temp2.next;
		 }
		 return true;
		 
	 }
	 
	 public static Node<Integer> hackir1(Node<Integer> head)
	 {
		 Node<Integer> temp = head;
		// Node<Integer> pre = null;
		while(temp != null)
		{
			if(temp.data % 2==0)
			{
				Node<Integer> c1 = temp;
				Node<Integer> pre = null;
				
				while(temp.data %2 ==0)
				{
					pre = temp;
					temp = temp.next;
				}
				
				pre.next = null;
				
				Node<Integer> head1 = 
			}
		}
	 }
	 
	 
	 

	public static void main(String[] args) {
		
		 Node<Integer> head = takeInput();  //createLinkedList();
//		Node<Integer> n1 = new Node(10);
//		System.out.println(n1.data);
//		System.out.println(n1.next);
		 
		// print(head);
		// System.out.println(length(head));
		// printIth(head,);
		 
		// System.out.println();
		// print(deleteIthNode(head,4));
		 
		//System.out.println(indexOfNIter(head,10));
		
		//print(append(head,2));
		//System.out.println(append(head,3));
		
		
		//print( removeDuplicates(head));
		//printReverseRecursive(head); 
		//System.out.println(isPalindrome(head));
		 print(head);
		 System.out.println();
		 
		 print(hackir1(head));
		 
		 
		 
		

	}

}

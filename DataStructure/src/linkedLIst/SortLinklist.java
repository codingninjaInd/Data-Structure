package linkedLIst;

import java.util.Scanner;

public class SortLinklist {
	
	
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
	
	public static Node<Integer> sort(Node<Integer> head)
	{
		if(head.next == null)
		{
			return head;
		}
		
		Node<Integer> small = sort(head.next);
		
		Node<Integer> temp = small;
		if(head.data > temp.data)
		{
			while(temp != null)
			{
				if(head.data < temp.data)
				{
					
				}
			}
		}
	}

	public static void main(String[] args) {
		

	}

}

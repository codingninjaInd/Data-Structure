package Binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeUse2 {
	
	
	public static String  logest(BinaryTreeNode<Integer>root,String s)
	{
		if(root==null)
		{
			return null;
		}
		
		s = s+root.data;
		
		
		int left = height(root.left);
		
		int right = height(root.right);
		
		if(left>right)
		{
			logest(root.left,s);
		}
		else
		{
			logest(root.right,s);
		}
		
		logest(root.left,s);
		
		logest(root.right,s);
		
		return s;
	
	}
	
	//Now we will make a function to print root to node path in BST
	
	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data)
	{
		if(root == null)
		{
			return null;
		}
		
		if(root.data==data)
		{
			ArrayList<Integer> output = new ArrayList<>();
			
			output.add(root.data);
			
			return output;
		}
		
		
		
	}
	
	//Now we will make a function to print root to Node path in binary Tree
	
	public static ArrayList<Integer> rootToNode(BinaryTreeNode<Integer> root,int x)
	{
		if(root==null)
		{
			return null;
		}
		
		if(root.data==x)
		{
			ArrayList<Integer> output = new ArrayList<>();
			
			output.add(root.data);
			
			return output;
		}
		
		ArrayList<Integer> left = rootToNode(root.left,x);
		
		if(left != null)
		{
			left.add(root.data);
			return left;
		}
		
		ArrayList<Integer> right = rootToNode(root.right,x);
		
		if(right != null)
		{
			right.add(root.data);
			return right;
		}
		
		return null;
	}
	
	
	//Now we will make a function to make a link list by bsy
	
	public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return null;
		}
		
		LinkedListNode<Integer> leftLL = BSTToSortedLL(root.left);
		
		int data = root.data;
		LinkedListNode<Integer> Node = new LinkedListNode<>(data);
		
		LinkedListNode<Integer> temp= leftLL;
		while(temp.next != null)
		{
			temp=temp.next;
		}
		
		temp.next = Node;
		
		LinkedListNode<Integer> rightLL = BSTToSortedLL(root.right);
		
		Node.next =rightLL;
		
		return leftLL;
		
		
				
		
			
		
	}
	
	//Now we will make a ameging functon to checlk is bst
	
	public static boolean isBst3(BinaryTreeNode<Integer> root,int minRange,int maxRange)
	{
		if(root==null)
		{
			return true;
		}
		
		if(root.data<minRange || root.data >maxRange)
		{
			return false;
		}
		
		boolean isLeftwithinRange = isBst3(root.left,minRange,root.data-1);
		
		boolean isRightwithinRange = isBst3(root.right,root.data,maxRange);
		
		return isLeftwithinRange && isRightwithinRange;
	}
	
	//Now we will make a function to check isbst in detail and improved
	
	public static isBstReturn isBst2(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			isBstReturn ans = new isBstReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
			
			return ans;
		}
		
		isBstReturn left = isBst2(root.left);
		
		isBstReturn right = isBst2(root.right);
		
		int min = Math.min(root.data,Math.min(left.min,right.min));
		
		int max = Math.max(root.data,Math.max(left.max,right.max));
		
		boolean isBst = true;
		
		if(left.max>=root.data)
		{
			isBst = false;
		}
		
		if(right.min<root.data)
		{
			isBst = false;
		}
		
		if(!left.isBst)
		{
			isBst = false;
		}
		if(!right.isBst)
		{
			isBst = false;
		}
	
		
		isBstReturn ans = new isBstReturn(min,max,isBst);
		return ans;
				
				
	}
	
	
	
	
	//Now we will make a function to check is binary Tree is Bst Or Nort
	
	public static boolean isBst(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return true;
		}
		
		int leftMax = maximum(root.left);
		if(leftMax>=root.data)
		{
			return false;
		}
		
		int rightMin = minimum(root.right);
		
		if(rightMin<root.data)
		{
			return false;
		}
		
		boolean isLeftisBst = isBst(root.left);
		boolean isRightisBst = isBst(root.right);
		
		return isLeftisBst&&isRightisBst;
	}
	
	//Now we will make a function that will print all node that are distance from a perticular node
	
	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k)
	{
		if(root==null)
		{
			return ;
		}
		
		if(root.data==node)
		{
			int d = k;
			printDepthK(root,k,d);
			
			return;
		}
		nodesAtDistanceK(root.left,node,k);
		nodesAtDistanceK(root.right,node,k);
		
		
	}
	
	private static void printDepthK(BinaryTreeNode<Integer> root,int k,int d) {
		if(root==null)
		{
			return;
		}
		
		if(d==0)
		{
			System.out.println(root.data);
			d=k;
		}
		
		printDepthK(root.left,k,d-1);
		
		printDepthK(root.right,k,d-1);
		
		
	}

	private static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null)
		{
			return Integer.MAX_VALUE;
		}
		
		int leftMin = minimum(root.left);
		int rightMin = minimum(root.right);
		
		return Math.min(root.data, Math.min(leftMin,rightMin));
	}

	private static int maximum(BinaryTreeNode<Integer> root) {
		if(root==null)
		{
			return Integer.MIN_VALUE;
		}
		
		int left = maximum(root.left);
		
		int right = maximum(root.right);
		
		return Math.max(root.data,Math.max(left, right));
		
		
		
	}

	//Now we will make a function to make a binary Search Tree if you have sorted array
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr)
	{
		int start = 0;
		int end = arr.length-1;
		
		return makeBstFromSortedArray(arr,start,end);
	}
	
	private static BinaryTreeNode<Integer> makeBstFromSortedArray(int[] arr,int start, int end) {
		
		if(start>end)
		{
			return null;
		}
		
		
		int mid = (start+end)/2;
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		
		//Now we will make left side of Bst
		
		BinaryTreeNode<Integer> left = makeBstFromSortedArray(arr,start,mid-1);
		
		//Now we will make right sider of binary search tree 
		
		BinaryTreeNode<Integer> right = makeBstFromSortedArray(arr,mid+1,end);
		
		root.left = left;
		root.right = right;
		return root;
		
		
		
				
				
				
		
	}

	//Now we will make a function to print the elemnt in tree bitween a range of k 1 and k2 when we are knowing that this is a BST
	
	//the time comlexity will be O(N)
	public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2)
	{
		if(root==null)
		{
			return;
		}
		
		
		
		
		
		
		if(root.data<k1)
		{
			printNodeFromK1ToK2(root.right,k1,k2);
		}
		
		else if(root.data>k2)
		{
			printNodeFromK1ToK2(root.left,k1,k2);
			
		}
		else
		{
			//System.out.print(root.data+" ");
			
			printNodeFromK1ToK2(root.left,k1,k2);
			System.out.print(root.data+" ");
			
			printNodeFromK1ToK2(root.right,k1,k2);
			//System.out.print(root.data+" ");
			
		}
		
		
		
		
		
		
		
	}
	
	//Now we will make a program for searching the data in binary search Tree
	
	public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k)
	{
		if(root==null)
		{
			return null;
		}
		
		if(root.data==k)
		{
			return root;
		}
		
		
		if(k<root.data)
		{
			return searchInBST(root.left ,k);
			
		}
		

			return searchInBST(root.right ,k);
			
		
	}
	
	//Now we will ,make a tree uing inorder and post order taravaersal
	
	public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorde(int[] post,int[] in){
		int n = in.length;
		
		PostIndex rootIndex = new PostIndex();
		
		rootIndex.index = n-1;
		
		return helper(in,post,0,n-1,rootIndex);
	
	}
	
	private static BinaryTreeNode<Integer> helper(int[] in, int[] post, int inStart, int inEnd,PostIndex rootIndex) {
		
		if(inStart>inEnd)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(post[rootIndex.index]);
		rootIndex.index = rootIndex.index-1;
		
		int index = find(in,inStart,inEnd,root.data);
		
		root.right =  helper(in,post,index+1,inEnd,rootIndex);
		root.left =  helper(in,post,inStart,index-1,rootIndex);
		
		return root;
		
		
	}

	//Now we will make a function to print the path of tree at leaf if sum to k
	
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) 
	{
		printPath(root,k,"");
	}
	
	
private static void printPath(BinaryTreeNode<Integer> root, int k,String s) {
	
	if(root==null)
	{
		return;
	}
	
	s =s+root.data+" ";
	k = k-root.data;
	if(k == 0 && root.left==null && root.right==null)
	{
		System.out.println(s);
		s ="";
		
	}
	
	
	printPath(root.left,k,s) ;
	
	printPath(root.right,k,s) ;
	
		
		
	}


public static void print(BinaryTreeNode<Integer> root)
{
	if(root==null)
	{
		return;
	}
	
	
	Queue<BinaryTreeNode<Integer>> pending = new LinkedList<BinaryTreeNode<Integer>>();
	
	pending.add(root);
	
	BinaryTreeNode<Integer> nl = new BinaryTreeNode<Integer>(-1);
	
	pending.add(nl);
	
	while(!pending.isEmpty())
	{
		BinaryTreeNode<Integer> front = pending.poll();
		if(front.data != -1)
		{
			System.out.print(front.data+" ");
		}
		else{
			System.out.println();
		}
		
		if(front.data != -1)
		{
			if(front.left != null)
			{
				pending.add(front.left);
				
			}
			if(front.right != null)
			{
				pending.add(front.right);
				
			}
			BinaryTreeNode<Integer> nextLine = new BinaryTreeNode<Integer>(-1);
			pending.add(nextLine);
		}
	}

}
	
		
		
		
		
	
		
		
		



	//Now we will make a function to create Duplicate of each Node and incert into its left
	
	
	public static BinaryTreeNode<Integer> insertDuplicateNode(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return null;
			
		}

		
		
		 insertDuplicateNode(root.left);
		
		insertDuplicateNode(root.right);
		
		
		BinaryTreeNode<Integer> temp = root.left;
		
		BinaryTreeNode<Integer> duplicate = new BinaryTreeNode<>(root.data);
		
		
		
		root.left = duplicate;
		
		duplicate.left = temp;
		
		return root;

	}
	
	//Now we will make a function to MAKE  a tree by using postorder and in order taraversal
	
	 public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int in[], int post[]) 
	    { 
		 int n = in.length;
	        Index pIndex = new Index(); 
	        pIndex.index = n - 1; 
	        return buildUtil(in, post, 0, n - 1, pIndex); 
	    } 

	private static BinaryTreeNode<Integer> buildUtil(int[] in, int[] post,int inStart, int inEnd, Binarytree.Index pIndex) {
		
		if(inStart>inEnd)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(post[pIndex.index]);
		
		(pIndex.index)--;
		
		if(inStart==inEnd)
		{
			return root;
		}
		
		int Index = find(in,inStart,inEnd,root.data);
		
		root.right = buildUtil(in,post,Index+1,inEnd,pIndex);
		
		root.left = buildUtil(in,post,inStart,Index-1,pIndex);
		return root;
		
		
		
		
		
		
		
	}

	//Now we will make a function to build tree rfron inorder and preOrder
	
	
	
	private static int find(int arr[],int start,int end,int value)
	{
		int i;
		
		for(i=start;i<=end;i++)
		{
			if(arr[i]==value)
			{
				return i;
			}
		}
		return i;
	}
	
	public static int Index =0;
	
	public static BinaryTreeNode<Integer> build(int inOrder[],int[] preOrder,int start,int end)
	{
		if(start>end)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[Index++]);
		
		
		int IndexinOrder = find(inOrder,start,end,root.data);
		
		root.left = build(inOrder,preOrder,start,IndexinOrder-1);
		
		root.right = build(inOrder,preOrder,IndexinOrder+1,end);
		
		return root;
	}
	
	
	//Now we will make a function to print the tree inlevel wise
	
	public static void printLevelWise(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<BinaryTreeNode<Integer>>();
		
		pendingChild.add(root);
		
		while(!pendingChild.isEmpty())
		{
			BinaryTreeNode<Integer> front = pendingChild.poll();
			System.out.print(front.data+":");
			
			if(front.left != null)
			{
				BinaryTreeNode<Integer> left = front.left;
				System.out.print("L:"+left.data+",");
				pendingChild.add(left);
			}
			
			if(front.right != null)
			{
				BinaryTreeNode<Integer> right = front.right;
				System.out.print("R:"+right.data);
				pendingChild.add(right);
			}
			System.out.println();
		}
	}
	
	
	//Now we will make a function to take input level wise;
	
	public static BinaryTreeNode<Integer> takeInputLevelWise()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the root data");
		
		int rootData = sc.nextInt();
		 if(rootData == -1)
		 {
			 return null;
		 }
		 
		 BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		 
		Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
		
		pendingChildren.add(root);
		
		while(! pendingChildren.isEmpty())
		{
			BinaryTreeNode<Integer> front = pendingChildren.poll();
			System.out.println("Enter the left child of " + front.data);
			
			int left = sc.nextInt();
			
			if(left != -1)// if left != -1 then we will make a node for this otherwise not make
			{
				
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
				
				front.left = leftChild;
				pendingChildren.add(leftChild);
				}
			
		//Similar thigs we will do for right child
System.out.println("Enter the right child of " + front.data);
			
			int right = sc.nextInt();
			
			if(right != -1)// if left != -1 then we will make a node for this otherwise not make
			{
				
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
				
				front.right = rightChild;
				pendingChildren.add(rightChild);
				}
			
			
		}
		
		return root;
	}
	
	//Now we will make a function to fund the diameter of tree
	
	
	public static int diameter(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		
		
		int leftHeight = height(root.left);
		int  rightHeight = height(root.right);
		
		
		int diameterLeft = diameter(root.left);
		
		int diameterRight = diameter(root.right);
		
		
		return Math.max(leftHeight+rightHeight,Math.max(diameterLeft, diameterRight));
		
	}
	
// Now we will make a function which will check is tree is ballenced or not 
	
	
	public static boolean isBalenced(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return true;
		}
		
		
		int leftHeight = height(root.left);
		
		int rightHeight = height(root.right);
		
		if(Math.abs(leftHeight - rightHeight) > 1)
		{
			return false;
			
		}
		
		boolean isLeftBalenced = isBalenced(root.left);
		
		boolean isRightBalenced = isBalenced(root.right);
		
		return isLeftBalenced && isRightBalenced ;
	}
	
	private static int height(BinaryTreeNode<Integer> root) {
	
		
		if(root==null)
		{
			return 0;
		}
		
		
		int leftHeight = height(root.left);
		int rightHeight  = height(root.right);
		
		return 1+Math.max(leftHeight,rightHeight);
}

	//Now we will make a function rfor mirror the binary tree
	
	public static void  mirror(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return;
		}
		
		 mirror(root.left);
	        mirror(root.right); 
	        BinaryTreeNode<Integer> temp =root.left;
	        root.left=root.right;
	        root.right=temp;

		
	
	}
	
	//now we will make a function to remove leaf node of binarytree
	
	public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return null;
		}
		
		if(root.left==null && root.right == null)
		{
			return null;
		}
		
		
	root.left =	removeLeaf(root.left);
	root.right =	removeLeaf(root.right);
		
		return root;
	}
	
	
	public static void printDetail(BinaryTreeNode<Integer> root)
	{
		
		if(root == null)
		{
			return;
		}
		System.out.print(root.data + ":");
		
		if(root.left != null)  //we will check if it is null or not
		{
			System.out.print("L" + root.left.data + ", ");
		}
		
		if(root.right != null)
		{
			System.out.print("R" + root.right.data);
		}
		System.out.println();
		
		printDetail(root.left);
		printDetail(root.right);
	}
	
	
	public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot , int parentData ,boolean isLeft)
	{
		
		if(isRoot) //if this is a first root then it is only exicute
		{
		System.out.println("Enter the root data");
		}
		else
		{
			if(isLeft)
			{
				System.out.println("Enter leftChild of" + parentData);
			}
			else
			{
				System.out.println("Enter rightChild of" +  parentData);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int rootData = sc.nextInt();
		
		if(rootData == -1)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		//Now we will make the left child of node
		
		BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false,rootData,true);
		
		BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false,rootData,false);
		
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
		
		
	}

	public static void main(String[] args) {
		//BinaryTreeNode<Integer> root = takeTreeInputBetter(true,0,true);
		
		//printDetail(root);
		
		System.out.println();
		
		//printDetail(removeLeaf(root));
		
		//printDetail(mirror(root));
		
		//System.out.println(isBalenced(root));
		
		//System.out.println("Diameter is:" + diameter(root));
		
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		//printDetail(root);
		// printLevelWise(root);
		 
//		 int pre[] = {1,2,3,4,15,5,6,7,8,10,9,12};
//		 
//		 int in[] =  {4,15,3,2,5,1,6,10,8,7,9,12};
//		 
//		 int len = pre.length;
//		 
//		 printLevelWise(build(in,pre,0,len-1));
//		
//		int post[] = {8,4,5,2,6,7,3,1};
//		
//		int in[] = {4,8,2,5,1,6,3,7};
//		 printLevelWise(getTreeFromPostorderAndInorde(post,in));
		
		//System.out.println("Level wise inserted");
		
		// printLevelWise(root);
		 
		 //System.out.println("Your output is");
		 
		// print(root);
		
		//rootToLeafPathsSumToK(root,13);
		
		
		//printNodeFromK1ToK2(root,6,10);
//		
//		int arr[] = {1,2,3,4,5,6,7};
//		
//		printLevelWise(SortedArrayToBST(arr));
		
		//System.out.println(isBst(root));
		
//		isBstReturn a = isBst2(root);
//		
//		System.out.println(a.isBst);
//		
//	

//		ArrayList<Integer> path = rootToNode(root,2);
//		
//		for(int i:path)
//		{
//			System.out.print(i+" ");
//		}
//		
//		

		System.out.println(logest(root,""));
		 
		 
		 
		 
		
		
		
		
		 
		 

		

	}

}

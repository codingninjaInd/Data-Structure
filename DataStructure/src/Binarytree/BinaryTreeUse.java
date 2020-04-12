package Binarytree;



import java.util.Scanner;

public class BinaryTreeUse {
	
	
	
//Now we will make a function that will print a node without siblings
	
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		if(root.left==null && root.right != null || root.right==null && root.left != null)
		{
			if(root.left==null && root.right != null)
			{
				System.out.println(root.right.data);
			}
			else
			{
				System.out.println(root.left.data);
			}
			
		}
		
		
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);
		
		
	}
	
	//now we will make a function to check if node is present in tree or not
	
	public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x)
	{
		if(root == null)
		{
			return false;
		}
		
		if(root.data == x)
		{
			return true;
		}
		
		boolean a =isNodePresent(root.left,x);
	boolean b=	isNodePresent(root.right,x);
	
	if(a == true || b==true)
	{
		return true;
	}
	return false;
		
		
}
	
	
	//Now we will make a function to replade root data with its 
	
	static void replaceDepth(BinaryTreeNode<Integer> n1)
	{
		helper(n1,0);
	}
	
	private static void helper(BinaryTreeNode<Integer> n1, int i) {
		
		if(n1 == null)
		{
			return ;
		}
		
		n1.data = i;
		System.out.println(n1.data);
		
		helper(n1.left,i+1);
		helper(n1.right,i+1);
		
		
		
		
	}

	//Now we will make a function to mprint at depth k

		public static void printAtDepthK(BinaryTreeNode<Integer> root,int k)
		{
			if(root == null)
			{
				return;
			}
			
			if(k==0)
			{
				System.out.println(root.data);
			}
			
			printAtDepthK(root.left,k-1);
			printAtDepthK(root.right,k-1);
		}
	
	
	//Now we will make a function to find no of leafs in binary tree
	 
	public static int numLeaves(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		
		if(root.left == null && root.right == null)
		{
			return 1;
		}
		
		
		return  numLeaves(root.left)+numLeaves(root.right);
	}
	
	// Now we will make a function to find height of binary tree
	
	public static int height(BinaryTreeNode<Integer> root) 
	{
		if(root == null)
		{
			return 0;
		}
		
		int left = height(root.left);
		int right = height(root.right);
		
		return 1+Math.max(left, right);
	}
	
	
	
	//Now we will make a function for count of the node whose data is greter then the node of tree;
	
	public static int numNodesGreaterX(BinaryTreeNode<Integer> root,int x)
	{
		if(root == null)
		{
			return 0;
		}
		
		int left = numNodesGreaterX(root.left,x);
		
		int right = numNodesGreaterX(root.right,x);
		
		if(root.data>x)
		{
			return 1+left+right;
		}
		else
		{
			return left+right;
		}
		
	}
	
	// Now we will make a function to find largest node in tree
	
	public static int largest(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return -1;
		}
		
		int largestLeft = largest(root.left);
		int largestRight = largest(root.right);
		
		// rather then writing multiple if we will use here math.max
		
	   return Math.max(root.data,Math.max(largestLeft, largestRight));
	}
	
	//Now we will make a function to print data into post order
	
	public static void postOrder(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return ;
		}
		
	
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
		
	}
	
	// Now we will make a function of preorder traversal of tree;
	
	public static void preOrder(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return ;
		}
		
		System.out.println(root.data);
		
		preOrder(root.left);
		preOrder(root.right);
	}
	
	
	//Now we will make a function to sum the node data we will also do this with recursion
	
	public static int sumNode(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		
		int left = sumNode(root.left);
		int right = sumNode(root.right);
		
		return root.data+left+right;
		
	}
	
	//Now we will make a function for count no of node in tree we will do this by recursion 
	
	public static int numNode(BinaryTreeNode<Integer> root)
	{
		if(root == null)
		{
			return 0;
		}
		
		int left = numNode(root.left);
		int right = numNode(root.right);
		
		
		return 1+left+right;    //adding 1 is very important bacause if we are not adding 1 then we are not followng indection of recursion so we will get 0 as output
	}
	
	
	//Now we will make a function to take input better way
	
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
	
	
	
	
	
	///Now we will make a function to take input in treee
	
	public static BinaryTreeNode<Integer> takeTreeInput()
	{
		System.out.println("Enter the root data");
		
		Scanner sc = new Scanner(System.in);
		
		int rootData = sc.nextInt();
		
		if(rootData == -1)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		//Now we will make the left child of node
		
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		
		root.left = leftChild;
		root.right = rightChild;
		
		return root;
		
		
	}
	
	
	///Now we will make a function to take input in treee
	
	public static BinaryTreeNode<Integer> takeTreeInput()
	{
		System.out.println("Enter the root data");
		
		Scanner sc = new Scanner(System.in);
		
		int rootData = sc.nextInt();
		
		if(rootData == -1)
		{
			return null;
		}
		
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		//Now we will make the left child of node
		
		BinaryTreeNode<Integer> leftChild = takeTreeInput();
		
		BinaryTreeNode<Integer> rightChild = takeTreeInput();
		
		root.left = leftChild;
		root.right = rightChild;
		
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
	
	public static void print(BinaryTreeNode<Integer> root)
	{
		
		if(root == null)
		{
			return;
		}
		System.out.println(root.data);
		print(root.left);
		print(root.right);
		
		
		
		
		//Not bretter to write this way or in this case we can not handil the case where empty root is passed
//		if(root.left != null)
//		{
//		print(root.left);
//		}
//		
//		if(root.right != null)
//		{
//		print(root.right);
//		}
	}

	public static void main(String[] args) {
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> Left = new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> Right = new BinaryTreeNode<>(3);
//		//Now we will put the value in left and right
//		
//		root.left = Left;
//		root.right = Right;
//		
//		
//		BinaryTreeNode<Integer> leftRight = new BinaryTreeNode<>(4);
//	BinaryTreeNode<Integer> rightLeft = new BinaryTreeNode<>(5);
	
	
//	Left.right =  leftRight;
//	Right.left = rightLeft;
		
		BinaryTreeNode<Integer> root = takeTreeInputBetter(true,0,true);
		printDetail(root);
		
		System.out.println();
		
		//System.out.println(numNode(root));
		
		//System.out.println("Sum of Node data is :"+ sumNode(root));
		
		//preOrder(root);
		
		//Now we will call post order function to see their output
		
		//postOrder(root);
		//System.out.println("largest is :" + largest(root));
		
		//Now we will make a function for count of the node whose data is greter then the node of tree
		
		     //System.out.println(numNodesGreaterX(root,2));
		
		
		// Now we will make a function to find height of binary tree
		     // System.out.println("Height is :" + height(root));
		
		//Now we will call a function which return no of leves in tree
		
		     //System.out.println("No of leaves is :" + numLeaves(root));
		
		//printAtDepthK(root,2);
		
		//replaceDepth(root);
		//System.out.println(isNodePresent( root,11));
		
		//Now we will call a function that will print node with out siblings
		
		printNodesWithoutSibling(root);
		
		
		
		
		
		
		
		

	}

}
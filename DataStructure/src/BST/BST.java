package BST;

import Binarytree.BinaryTreeNode;

public class BST {

	private BinaryTreeNode<Integer> root;
	
	private int size;
	
	private static  boolean isPresentHelper(BinaryTreeNode<Integer> node,int x)
	{
		if(node==null)
		{
			return false;
		}
		
		if(node.data == x)
		{
			return true;
		}
		
		if(x < node.data )
		{
			return isPresentHelper(node.left,x);
		}
		else{
			return isPresentHelper(node.right,x);
		}
	}
	
	//Now we will make a function to check is node is present or not
	
	public boolean isPresent(int x)
	{
		return isPresentHelper(root,x);
	}
	
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node,int x)
	{
		if(node == null)
		{
			BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
			
			return newRoot;
		}
		
		if(x >= node.data)
		{
			node.right = insertHelper(node.right,x);
		}
		else{
			node.left = insertHelper(node.left,x);
		}
		
		return node;
	}
	
	//Now we will make a function to insert the node in BSt
	
	public void insert(int x)
	{
		root = insertHelper(root,x);
		
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
	
	private static BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root,int x)
	{
		if(root== null)
		{
			return new BSTDeleteReturn(null,false);
			
		}
		
		if(root.data <x)
		{
			BSTDeleteReturn outputRight = deleteDataHelper(root.right,x);
			
			root.right = outputRight.root;
			
			outputRight.root = root;
			
			return outputRight;
		}
		
		if(root.data >  x)
		{
			BSTDeleteReturn outputLeft = deleteDataHelper(root.left,x);
			
			root.left = outputLeft.root;
			
			outputLeft.root = root;
			
			return outputLeft;
		}
		
		// for 0 child
		
		if(root.left==null && root.right==null)
		{
			return new BSTDeleteReturn(null,true);
		}
		
		//if root has only left child
		
		if(root.left != null && root.right==null)
		{
			return new BSTDeleteReturn(root.left,true);
		}
		
		if(root.right != null && root.left==null)
		{
			return new BSTDeleteReturn(root.right,true);
		}
		
		
		// if both the children is present
		
		int rightmin = minimum(root.right);
		
		root.data = rightmin;
		
		BSTDeleteReturn outputRight = deleteDataHelper(root.right,rightmin);
		
		root.right = outputRight.root;
		
		return new BSTDeleteReturn(root,true);
	}
	
	//Now we will make a function that will delete the x node if that node is not present in BST it will return false
	
	public boolean deleteData(int x)
	{
		BSTDeleteReturn output = deleteDataHelper(root,x);
		
		root = output.root;
		
		if(output.deleted)
			size--;
		
		return output.deleted;
		
		
	}
	
	public  int size()
	{
		return size;
	}
	
	private static void printTreeHelper(BinaryTreeNode<Integer> node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.data + ":");
		
		if(node.left != null)  //we will check if it is null or not
		{
			System.out.print("L" + node.left.data + ", ");
		}
		
		if(node.right != null)
		{
			System.out.print("R" + node.right.data);
		}
		System.out.println();
		
		printTreeHelper(node.left);
		printTreeHelper(node.right);
	}
	
	//Now we will make a function to print tree 
	
	public void printTree()
	{
		printTreeHelper(root);
		
	}
}

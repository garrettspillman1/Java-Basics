
public class BinarySearchTree <T extends Comparable<T>>
{
	private class Node
	{
		T data;
		Node leftChild;
		Node rightChild;
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//Start 
	public BinarySearchTree()
	{
		root = null;
	}
	public void add(T aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			add(root,aData);
	}
	private Node add(Node aNode, T aData)
	{
		if(aNode == null)
			aNode = new Node(aData);
		else if(aData.compareTo(aNode.data)<0)// Go Left
			aNode.leftChild = add(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//Go Right
		aNode.rightChild = add(aNode.rightChild,aData);
		return aNode;
	}
	public void printPreorder()
	{
		printPreorder(root);
	}
	private void printPreorder(Node aNode)
	{
		if(aNode == null)
			return;
		System.out.println(aNode.data);//Process
		printPreorder(aNode.leftChild);//Left
		printPreorder(aNode.rightChild);//Right
	}
	public void printInorder()
	{
		printInorder(root);
	}
	private void printInorder(Node aNode)
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);//Left
		System.out.println(aNode.data);//Process
		printInorder(aNode.rightChild);//Right

	}
	public void printPostorder()
	{
		printPostorder(root);
	}
	private void printPostorder(Node aNode)
	{
		if(aNode == null)
			return;
		printInorder(aNode.leftChild);//Left
		printInorder(aNode.rightChild);//Right
		System.out.println(aNode.data);//Process	
	}
	public boolean search(T aData)
	{
		return search(root,aData);
	}
	private boolean search(Node aNode, T aData)
	{
		if(aNode == null)
			return false;
		else if(aData.compareTo(aNode.data)<0)// Go Left
			return search(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//Go Right
			return search(aNode.rightChild,aData);
		else	
			return true;
	}
	public void remove(T aData)
	{
		root = remove(root,aData);
	}
	private Node remove(Node aNode,T aData)
	{
		//Find node
		if(aNode == null)
			return null;
		else if(aData.compareTo(aNode.data)<0)// Go Left
			aNode.leftChild = remove(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data)>0)//Go Right
			aNode.rightChild = remove(aNode.rightChild,aData);
		else// Found it
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild,temp.data);
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode)
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}

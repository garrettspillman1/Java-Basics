/**
 * @garrettspillman1
 *                   A generic binary search tree implementation.
 *
 * @param <T> The type of data to be stored in the tree, must implement
 *            Comparable.
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * Inner class representing a node in the binary search tree.
	 */
	private class Node {
		T data;
		Node leftChild;
		Node rightChild;

		/**
		 * Constructs a node with the given data.
		 *
		 * @param aData The data to be stored in the node.
		 */
		public Node(T aData) {
			data = aData;
			leftChild = rightChild = null;
		}
	}

	private Node root; // Start

	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * Adds a new data element to the tree.
	 *
	 * @param aData The data to be added to the tree.
	 */
	public void add(T aData) {
		if (root == null)
			root = new Node(aData);
		else
			add(root, aData);
	}

	/**
	 * Helper method to recursively add a new data element to the tree.
	 *
	 * @param aNode The current node being considered.
	 * @param aData The data to be added.
	 * @return The updated node.
	 */
	private Node add(Node aNode, T aData) {
		if (aNode == null)
			aNode = new Node(aData);
		else if (aData.compareTo(aNode.data) < 0) // Go Left
			aNode.leftChild = add(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0) // Go Right
			aNode.rightChild = add(aNode.rightChild, aData);
		return aNode;
	}

	/**
	 * Prints the elements of the tree in preorder traversal.
	 */
	public void printPreorder() {
		printPreorder(root);
	}

	/**
	 * Helper method to recursively print the elements of the tree in preorder
	 * traversal.
	 *
	 * @param aNode The current node being considered.
	 */
	private void printPreorder(Node aNode) {
		if (aNode == null)
			return;
		System.out.println(aNode.data); // Process
		printPreorder(aNode.leftChild); // Left
		printPreorder(aNode.rightChild); // Right
	}

	/**
	 * Prints the elements of the tree in inorder traversal.
	 */
	public void printInorder() {
		printInorder(root);
	}

	/**
	 * Helper method to recursively print the elements of the tree in inorder
	 * traversal.
	 *
	 * @param aNode The current node being considered.
	 */
	private void printInorder(Node aNode) {
		if (aNode == null)
			return;
		printInorder(aNode.leftChild); // Left
		System.out.println(aNode.data); // Process
		printInorder(aNode.rightChild); // Right
	}

	/**
	 * Prints the elements of the tree in postorder traversal.
	 */
	public void printPostorder() {
		printPostorder(root);
	}

	/**
	 * Helper method to recursively print the elements of the tree in postorder
	 * traversal.
	 *
	 * @param aNode The current node being considered.
	 */
	private void printPostorder(Node aNode) {
		if (aNode == null)
			return;
		printInorder(aNode.leftChild); // Left
		printInorder(aNode.rightChild); // Right
		System.out.println(aNode.data); // Process
	}

	/**
	 * Searches for a data element in the tree.
	 *
	 * @param aData The data to search for.
	 * @return True if the data is found, false otherwise.
	 */
	public boolean search(T aData) {
		return search(root, aData);
	}

	/**
	 * Helper method to recursively search for a data element in the tree.
	 *
	 * @param aNode The current node being considered.
	 * @param aData The data to search for.
	 * @return True if the data is found, false otherwise.
	 */
	private boolean search(Node aNode, T aData) {
		if (aNode == null)
			return false;
		else if (aData.compareTo(aNode.data) < 0) // Go Left
			return search(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0) // Go Right
			return search(aNode.rightChild, aData);
		else
			return true;
	}

	/**
	 * Removes a data element from the tree.
	 *
	 * @param aData The data to be removed.
	 */
	public void remove(T aData) {
		root = remove(root, aData);
	}

	/**
	 * Helper method to recursively remove a data element from the tree.
	 *
	 * @param aNode The current node being considered.
	 * @param aData The data to be removed.
	 * @return The updated node.
	 */
	private Node remove(Node aNode, T aData) {
		// Find node
		if (aNode == null)
			return null;
		else if (aData.compareTo(aNode.data) < 0) // Go Left
			aNode.leftChild = remove(aNode.leftChild, aData);
		else if (aData.compareTo(aNode.data) > 0) // Go Right
			aNode.rightChild = remove(aNode.rightChild, aData);
		else { // Found it
			if (aNode.rightChild == null)
				return aNode.leftChild;
			else if (aNode.leftChild == null)
				return aNode.rightChild;
			Node temp = findMinInTree(aNode.rightChild);
			aNode.data = temp.data;
			aNode.rightChild = remove(aNode.rightChild, temp.data);
		}
		return aNode;
	}

	/**
	 * Finds the minimum value node in a subtree.
	 *
	 * @param aNode The root node of the subtree.
	 * @return The node with the minimum value.
	 */
	private Node findMinInTree(Node aNode) {
		if (aNode == null)
			return null;
		else if (aNode.leftChild == null)
			return aNode;
		else
			return findMinInTree(aNode.leftChild);
	}
}

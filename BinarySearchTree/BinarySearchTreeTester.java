/**
 * @garrettspillman1
 *                   The BinarySearchTreeTester class is used to test the
 *                   functionality of the BinarySearchTree class.
 *                   It adds values to the binary search tree, prints the tree
 *                   in different traversal orders,
 *                   searches for a value, and removes some values.
 */
public class BinarySearchTreeTester {

	/**
	 * The main method serves as the entry point for the BinarySearchTreeTester
	 * program.
	 * It creates a BinarySearchTree, adds values, and performs various operations
	 * to test the BinarySearchTree class.
	 *
	 * @param args The command-line arguments (not used in this program).
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		BST.add(8);
		BST.add(2);
		BST.add(12);
		BST.add(1);
		BST.add(4);
		BST.add(10);
		BST.add(16);

		System.out.println("Preorder");
		BST.printPreorder();

		System.out.println("Inorder");
		BST.printInorder();

		System.out.println("Postorder");
		BST.printPostorder();

		System.out.println(BST.search(1));

		BST.remove(4);
		System.out.println("Removed 4 Inorder");
		BST.printInorder();

		BST.remove(8);
		System.out.println("Removed 8 Inorder");
		BST.printInorder();
	}
}

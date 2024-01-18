
public class BinarySearchTreeTester {

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

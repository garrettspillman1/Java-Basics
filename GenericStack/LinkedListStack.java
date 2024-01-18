/**
 * @garrettspillman1
 *                   A generic implementation of a stack using a linked list.
 *
 * @param <T> The type of elements stored in the stack.
 */
public class LinkedListStack<T> implements StackInterface<T> {
	private class ListNode {
		T data;
		ListNode link;

		/**
		 * Constructs a new node with the specified data and link to the next node.
		 *
		 * @param data The data to be stored in the node.
		 * @param link The link to the next node.
		 */
		public ListNode(T data, ListNode link) {
			this.data = data;
			this.link = link;
		}
	}

	private ListNode head;

	/**
	 * Constructs a LinkedListStack with an empty linked list.
	 */
	public LinkedListStack() {
		head = null;
	}

	/**
	 * Adds an element to the top of the stack.
	 *
	 * @param data The data to be pushed onto the stack.
	 */
	public void push(T data) {
		ListNode newNode = new ListNode(data, head);
		head = newNode;
	}

	/**
	 * Removes and returns the element from the top of the stack.
	 *
	 * @return The element removed from the top of the stack.
	 */
	public T pop() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}

	/**
	 * Returns the element from the top of the stack without removing it.
	 *
	 * @return The element from the top of the stack.
	 */
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}

	/**
	 * Prints the elements in the stack.
	 */
	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}

/**
 * @garrettspillman1
 *                   A generic implementation of a queue using a linked list.
 *
 * @param <T> The type of elements stored in the queue.
 */
public class LinkedListQueue<T> implements QueueInterface<T> {
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
	private ListNode tail;

	/**
	 * Constructs a LinkedListQueue with an empty linked list.
	 */
	public LinkedListQueue() {
		head = tail = null;
	}

	/**
	 * Adds an element to the end of the queue.
	 *
	 * @param data The data to be enqueued.
	 */
	public void enqueue(T data) {
		ListNode newNode = new ListNode(data, null);
		if (head == null) {
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}

	/**
	 * Removes and returns the element at the front of the queue.
	 *
	 * @return The element removed from the front of the queue.
	 */
	public T dequeue() {
		if (head == null)
			return null;
		T ret = head.data;
		head = head.link;
		return ret;
	}

	/**
	 * Returns the element at the front of the queue without removing it.
	 *
	 * @return The element at the front of the queue.
	 */
	public T peek() {
		if (head == null)
			return null;
		return head.data;
	}

	/**
	 * Prints the elements in the queue.
	 */
	public void print() {
		for (ListNode temp = head; temp != null; temp = temp.link)
			System.out.println(temp.data);
	}
}

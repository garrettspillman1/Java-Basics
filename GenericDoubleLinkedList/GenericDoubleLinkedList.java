/**
 * TODO: Not sure if this works may need to revist
 * 
 * @garrettspillman1
 *                   A generic doubly linked list implementation.
 *                   This class allows for the manipulation of elements in a
 *                   doubly linked list,
 *                   providing methods for navigation, modification, and
 *                   retrieval of data.
 * 
 * @param <T> The type of elements stored in the linked list.
 */
public class GenericDoubleLinkedList<T> {

	/**
	 * Inner class representing a node in the doubly linked list.
	 */
	private class Node {
		T data;
		Node next;
		Node prev;

		/**
		 * Constructs a new node with the specified data, next node, and previous node.
		 *
		 * @param data The data to be stored in the node.
		 * @param next The next node in the list.
		 * @param prev The previous node in the list.
		 */
		public Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}

	private Node head; // Reference to the head of the list
	private Node current; // Reference to the current position in the list
	private int size; // Number of elements in the list

	/**
	 * Moves the current position to the next node in the list.
	 */
	public void gotoNext() {
		if (current != null) {
			current = current.next;
		}
	}

	/**
	 * Moves the current position to the previous node in the list.
	 */
	public void goToPrev() {
		if (current != null && current.prev != null) {
			current = current.prev;
		}
	}

	/**
	 * Resets the current position to the head of the list.
	 */
	public void reset() {
		current = head;
	}

	/**
	 * Moves the current position to the end of the list.
	 */
	public void gotoEnd() {
		if (head == null) {
			return;
		}
		current = head;
		while (current.next != null) {
			current = current.next;
		}
	}

	/**
	 * Checks if there are more nodes in the list after the current position.
	 *
	 * @return True if there are more nodes, false otherwise.
	 */
	public boolean hasMore() {
		return current != null;
	}

	/**
	 * Gets the data at the current position.
	 *
	 * @return The data at the current position, or null if the position is null.
	 */
	public T getCurrent() {
		return current != null ? current.data : null;
	}

	/**
	 * Sets the data at the current position.
	 *
	 * @param data The data to set.
	 */
	public void setCurrent(T data) {
		if (current != null) {
			current.data = data;
		}
	}

	/**
	 * Adds a new node with the specified data to the end of the list.
	 *
	 * @param data The data to be added.
	 */
	public void add(T data) {
		Node temp1 = new Node(data, null, null);
		if (head == null) {
			head = current = temp1;
		} else {
			Node temp2 = head;
			while (temp2.next != null) {
				temp2 = temp2.next;
			}
			temp2.next = temp1;
			temp1.prev = temp2;
		}
		size++;
	}

	/**
	 * Adds a new node with the specified data after the current position.
	 *
	 * @param data The data to be added.
	 */
	public void addAfterCurrent(T data) {
		if (current == null) {
			return;
		}
		Node temp = new Node(data, current.next, current);
		if (current.next != null) {
			current.next.prev = temp;
		}
		current.next = temp;
		size++;
	}

	/**
	 * Removes the first occurrence of the specified data from the list.
	 *
	 * @param data The data to be removed.
	 */
	public void remove(T data) {
		Node temp = head;
		while (temp != null && !temp.data.equals(data)) {
			temp = temp.next;
		}
		if (temp == null) {
			return;
		}
		if (temp.prev == null) {
			head = temp.next;
		} else {
			temp.prev.next = temp.next;
		}
		if (temp.next != null) {
			temp.next.prev = temp.prev;
		}
		if (current == temp) {
			current = temp.next;
		}
		size--;
	}

	/**
	 * Removes the node at the current position from the list.
	 */
	public void removeCurrent() {
		if (current == null) {
			return;
		}
		if (current.prev == null) {
			head = current.next;
		} else {
			current.prev.next = current.next;
		}
		if (current.next != null) {
			current.next.prev = current.prev;
			current = current.next;
		} else {
			current = current.prev;
		}
		size--;
	}

	/**
	 * Prints the elements in the linked list.
	 */
	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * Checks if the linked list contains the specified data.
	 *
	 * @param data The data to check for.
	 * @return True if the data is found, false otherwise.
	 */
	public boolean contains(T data) {
		Node temp = head;
		while (temp != null) {
			if (temp.data.equals(data)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	/**
	 * Gets the size of the linked list.
	 *
	 * @return The size of the linked list.
	 */
	public int getSize() {
		return size;
	}
}
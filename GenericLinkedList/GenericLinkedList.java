// Garrett Spillman
public class GenericLinkedList<T> {
	private class ListNode {
		T data;
		ListNode link;
		
		public ListNode(T data, ListNode link) {
			this.data = data;
			this.link = link;
		}
	}
	
	private ListNode head;
	private ListNode current;
	private ListNode previous;
	private int size;
	
	public GenericLinkedList() {
		head = current = previous = null;
		size = 0;
	}
	//resetMethod
	public void reset() {
		current = head;
		previous = null;
	}
	//getLast method
	public T getLast() {
		if (head == null) {
			return null;
		}
		
		ListNode temp = head;
		while (temp.link != null) {
			temp = temp.link;
		}
		
		return temp.data;
	}
	// goToNext Method
	public void gotoNext() {
		if (current != null) {
			previous = current;
			current = current.link;
		}
	}
	// getCurrent Method
	public T getCurrent() {
		if (current == null) {
			return null;
		}
		
		return current.data;
	}
	// setCurrent Method
	public void setCurrent(T data) {
		if (current != null && data != null) {
			current.data = data;
		}
	}
	// add Method
	public void add(T data) {
		if (data == null) {
			return;
		}
		
		ListNode newNode = new ListNode(data, null);
		
		if (head == null) {
			head = current = newNode;
			size = 1;
			return;
		}
		
		ListNode temp = head;
		while (temp.link != null) {
			temp = temp.link;
		}
		
		temp.link = newNode;
		size++;
	}
	// addAfterCurrent method
	public void addAfterCurrent(T data) {
		if (data == null || current == null) {
			return;
		}
			ListNode newNode = new ListNode(data, current.link);
			current.link = newNode;
			this.size++;
			}
		
	// removeCurrent method
	public void removeCurrent() {
		if (current != null && previous != null) {
			previous.link = current.link;
			current = current.link;
		}
		else if(current != null && previous == null) 
		{
			head = head.link;
			current = head;
		}
		if(this.size > 0)
			size --;
		
	}

	// showList method
	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

	// contains method
	public boolean contains(T data) {
		if (data != null) {
			ListNode temp = head;
			while (temp != null) {
				if (temp.data.equals(data)) {
					return true;
				}
				temp = temp.link;
			}
		}
		return false;
	}
	//hasMore Method
	public boolean hasMore()
	{
		return current != null;
	}
	//getSize Method
	public int getSize()
	{
		return this.size;
	}
	//isEmpty method
	public boolean isEmpty() {
		return head == null;
	}
	//getInterable
	//gets data at int i with in the bounds of int size lets for loops iterate through the list
	public T getIterable(int i) {
		if (i < 0 || i >= size) {
			return null;
		}
		ListNode current = head;
		for (int j = 0; j < i; j++) {
			current = current.link;
		}
		return current.data;
	}
	
}
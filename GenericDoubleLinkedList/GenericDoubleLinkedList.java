public class GenericDoubleLinkedList<T> {
	// Doesn't work need to workshop it 
	private class Node {
		T data;
		Node next;
		Node prev;
		
		public Node(T data, Node next, Node prev ) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
	
	private Node head;
	private Node current;
	private int size;
	
	public void gotoNext()
	{
		if (current != null) {
	        current = current.next;
	        
	    }
	}
	public void goToPrev()
	{
		if (current != null && current.prev != null) {
	        current = current.prev;
	        
	    }
	}
	public void reset() {
		current = head;
	}
	public void gotoEnd() {
	    if (head == null) {
	        return;
	    }
	    current = head;
	    while (current.next != null) {
	        current = current.next;
	    }
	}

	public boolean hasMore() {
		    if (current == null) 
		    {
		        return false; 
		    }
		    return true;
		}
	
	public T getCurrent() {
	    if (current != null) {
	        return current.data;
	    }
	    return null;
	}
	public void setCurrent(T data) {
	    if (current != null) {
	        current.data = data;
	    }
	}
	public void add(T data) {
	    Node temp1 = new Node(data, null, null);
	    if (head == null) {
	        // The list is empty
	        head = current = temp1;
	    } else {
	        //go to the end and add the new node
	        Node temp2 = head;
	        while (temp2.next != null) {
	            temp2 = temp2.next;
	        }
	        temp2.next = temp1;
	        temp1.prev = temp2;
	    }
	    size++;
	}
	public void addAfterCurrent(T data) {
	    if (current == null) {
	        return; // Do not add the data to the list
	    }
	    Node temp = new Node(data, current.next, current);
	    if (current.next != null) {
	        current.next.prev = temp;
	    }
	    current.next = temp;
	    size++;
	    
	}
	public void remove(T data) {
	    Node temp = head;
	    while (temp != null && temp.data != data) {
	        temp = temp.next;
	    }
	    if (temp == null) {
	        return; // The data is not in the list
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
	public void removeCurrent() {
	    if (current == null) {
	        return; // can't remove if the current reference is null
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
	public void print() {
	    while (head != null) {
	        System.out.println(head.data);
	        head = head.next;
	    }
	    System.out.println();
	}
	public boolean contains(T data) {
	    Node temp = head;
	    while (temp != null) {
	        if (temp.data == data) {
	            return true;
	        }
	        temp = temp.next;
	    }
	    return false;
	}
	public int getSize() {
	    return size;
	}
	
}
